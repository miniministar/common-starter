package com.exercise.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;

/**
 * 自定义导出Excel数据注解
 * 1.导入模板
 @RequestMapping("/importTemplate")
 @ApiOperation(value="导入模板生成",notes="")
 public CommonResult importTemplate() throws Exception {
 ExcelUtil<GdFactorHistory> util = new ExcelUtil<GdFactorHistory>(GdFactorHistory.class);
 return util.importTemplateExcel("影响因数");
 }

 * 2.导入数据 导入不分顺序，根据列导入
 @MyLog(title = "影响因数管理", businessType = BusinessType.IMPORT)
 @RequestMapping("/import")
 @ApiOperation(value="导入",notes="先删除历史数据再重新导入，entity: 传入 类型，年度")
 public CommonResult importData(@RequestParam(value="file") MultipartFile file, GdFactorHistory entity) throws Exception {

 ExcelUtil<GdFactorHistory> util = new ExcelUtil<>(GdFactorHistory.class);
 List<GdFactorHistory> list = util.importExcel(file.getInputStream() );
 Integer count = service.importData(list, entity);
 return CommonResult.success("导入成功" + count + "条数据");
 }

 * 3.导出数据
 @MyLog(title = "影响因数管理", businessType = BusinessType.IMPORT)
 @RequestMapping("export")
 @ApiOperation(value="导出",notes="查询参数Filter")
 public CommonResult export(@RequestBody RequestDTO<GdFactorHistory> params) {
 List<GdFactorHistory> list = service.getList(params.getFilter());
 ExcelUtil<GdFactorHistory> excelUtil = new ExcelUtil<>(GdFactorHistory.class);
 return excelUtil.exportExcel(list, "影响因数");
 }


 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel
{
    /**
     * 导出时在excel中排序
     */
    int sort() default Integer.MAX_VALUE;

    /**
     * 导出到Excel中的名字.
     */
    String name() default "";

    /**
     * 日期格式, 如: yyyy-MM-dd
     */
    String dateFormat() default "";

    /**
     *  todo 不使用
     * 如果是字典类型，请设置字典的type值 (如: sys_user_sex)
     */
    String dictType() default "";

    /**
     * 读取内容转表达式 (如: 0=男,1=女,2=未知)
     */
    String readConverterExp() default "";

    /**
     * 分隔符，读取字符串组内容
     */
    String separator() default ",";

    /**
     * BigDecimal 精度 默认:-1(默认不开启BigDecimal格式化)
     */
    int scale() default -1;

    /**
     * BigDecimal 舍入规则 默认:BigDecimal.ROUND_HALF_EVEN
     */
    int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * 导出类型（0数字 1字符串）
     */
    ColumnType cellType() default ColumnType.STRING;

    /**
     * 导出时在excel中每个列的高度 单位为字符
     */
    double height() default 14;

    /**
     * 导出时在excel中每个列的宽 单位为字符
     */
    double width() default 16;

    /**
     * 文字后缀,如% 90 变成90%
     */
    String suffix() default "";

    /**
     * 当值为空时,字段的默认值
     */
    String defaultValue() default "";

    /**
     * 提示信息
     */
    String prompt() default "";

    /**
     * 设置只能选择不能输入的列内容.
     */
    String[] combo() default {};

    /**
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     */
    boolean isExport() default true;

    /**
     * 另一个类中的属性名称,支持多级获取,以小数点隔开
     */
    String targetAttr() default "";

    /**
     * 是否自动统计数据,在最后追加一行统计数据总和
     */
    boolean isStatistics() default false;

    /**
     * 字段类型（0：导出导入；1：仅导出；2：仅导入）
     */
    Type type() default Type.ALL;

    enum Type
    {
        ALL(0), EXPORT(1), IMPORT(2);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        int value()
        {
            return this.value;
        }
    }

    enum ColumnType
    {
        NUMERIC(0), STRING(1);
        private final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        int value()
        {
            return this.value;
        }
    }
}