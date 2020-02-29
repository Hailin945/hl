package com.hl.zuul.filter;

/**
 * zuul过滤器类型枚举
 *
 * @author Hailin
 * @date 2020/1/15
 */
public enum FilterTypeEnum {
    /**
     * 路由之前
     */
    PRE("pre"),
    /**
     * 路由之时
     */
    ROUTING("routing"),
    /**
     * 路由之后
     */
    POST("post"),
    /**
     * 发送错误调用
     */
    ERROR("error");


    private String code;

    FilterTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
