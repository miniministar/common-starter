package com.exercise.oauth2.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OauthApprovals implements Serializable {
    private String userid;

    private String clientid;

    private String scope;

    private String status;

    private Date expiresat;

    private Date lastmodifiedat;

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExpiresat() {
        return expiresat;
    }

    public void setExpiresat(Date expiresat) {
        this.expiresat = expiresat;
    }

    public Date getLastmodifiedat() {
        return lastmodifiedat;
    }

    public void setLastmodifiedat(Date lastmodifiedat) {
        this.lastmodifiedat = lastmodifiedat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", clientid=").append(clientid);
        sb.append(", scope=").append(scope);
        sb.append(", status=").append(status);
        sb.append(", expiresat=").append(expiresat);
        sb.append(", lastmodifiedat=").append(lastmodifiedat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}