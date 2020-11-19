package com.exercise.common.core.validator;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.exercise.common.core.exception.ApiException;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;

/**
 *  <p> 数据库字段内容重复判断处理工具类 </p>
 */
public class FieldRepeatValidatorUtils {

    /**
     * 实体类id字段
     */
    private static String id;
    /**
     * 实体类id字段值
     */
    private static Long idValue;
    /**
     * 校验字段
     */
    private static String field;
    /**
     * 校验字段值 - 字符串、数字、对象...
     */
    private static Object fieldValue;
    /**
     * 校验字段 - 对应数据库字段
     */
    private static String db_field;
    /**
     * 实体类对象值
     */
    private static Object object;

    /**
     * 校验数据 TODO 后期如果需要校验同个字段是否重复的话，将 `field` 做 , 或 - 分割... ；  如果id不唯一考虑传值过来判断 或 取fields第二个字段值拿id
     *
     * @param field：校验字段
     * @param object：对象数据
     * @param message：回调到前端提示消息
     * @return: boolean
     */
    public static boolean fieldRepeat(String id, String field, Object object, String message) {
        // 使用Class类的中静态forName()方法获得与字符串对应的Class对象 ; className: 必须是接口或者类的名字
        // 静态方法forName()调用 启动类加载器 -> 加载某个类xx -> 实例化 ----> 从而达到降耦 更灵活
//        Object object = Class.forName(className).newInstance();

        FieldRepeatValidatorUtils.id = id;
        FieldRepeatValidatorUtils.field = field;
        FieldRepeatValidatorUtils.object = object;
        getFieldValue();

        // ⑦ 校验字段内容是否重复
        // 工厂模式 + ar动态语法
        Model entity = (Model) object;
        QueryWrapper<Model> eq = new QueryWrapper<Model>().eq(db_field, fieldValue);
        Integer count = 0;
        // 如果数据重复返回false -> 再返回自定义错误消息到前端
        if ( idValue == null ){
            count = entity.selectCount(eq);

        } else {
            count = entity.selectCount(eq.and(x -> x.ne(id, idValue)));
        }
        if ( count > 0 ){
            throw new ApiException( message );
        }
        return true;
    }

    /**
     * 获取id、校验字段值
     */
    public static void getFieldValue(){
        // ① 获取所有的字段
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            // ② 设置对象中成员 属性private为可读
            f.setAccessible(true);
            // ③ 判断字段注解是否存在
            if ( f.isAnnotationPresent(ApiModelProperty.class) ) {
                // ④ 如果存在则获取该注解对应的字段,并判断是否与我们要校验的字段一致
                if ( f.getName().equals( field ) ){
                    try {
                        // ⑤ 如果一致则获取其属性值
                        fieldValue = f.get(object);
                        // ⑥ 获取该校验字段对应的数据库字段属性  目的： 给 mybatis-plus 做ar查询使用
                        TableField annotation = f.getAnnotation(TableField.class);
                        db_field = annotation.value();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                // ⑦ 获取id值 -> 作用：判断是插入还是更新操作
                if ( id.equals( f.getName() ) ){
                    try {
                        idValue = (Long) f.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
