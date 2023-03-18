package com.by.controller.vo;

import org.slf4j.MDC;

import java.io.Serializable;
import java.util.Collection;

public class APIResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 200;
    public static final String SUCCESS_MSG = "SUCCESS";
    public static final int SYS_FAIL = 500;
    public static final String ERROR_MSG = "系统异常！";
    public static final int PARAMS_ERROR = 1000;
    public static final String PARAMS_ERROR_MSG = "参数异常";
    public static final int BUSINESS_ERROR = 1002;
    public static final String BUSINESS_ERROR_MSG = "系统打盹了";
    public String reqUuid;
    private int code;
    private String message;
    private T reult;

    public APIResult() {
        this.reqUuid = getTraceId();
    }

    public APIResult(T data) {
        this.reult = data;
        this.reqUuid = getTraceId();
    }

    public APIResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.reqUuid = getTraceId();
    }

    public APIResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.reult = data;
        this.reqUuid = getTraceId();
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public static <T> APIResult<T> success(T data) {
        return new APIResult(200, (String)null, data);
    }

    public static <T> APIResult<T> success(T data, String message) {
        return new APIResult(200, message, data);
    }

    public static <T> APIResult<T> systemError(String message) {
        return new APIResult(500, message);
    }

    public static <T> APIResult<T> parameterError(String message) {
        return new APIResult(1000, message);
    }

    public static <T> APIResult<T> businessError(String message) {
        return new APIResult(1002, message);
    }

    public static <T> APIResult<T> result(int code, String message, T data) {
        return new APIResult(code, message, data);
    }

    public static String getTraceId() {
        return MDC.get("traceId");
    }

    public static <T> APIResult<T> fillUuid(APIResult<T> result) {
        result.setReqUuid(getTraceId());
        return result;
    }

    public static <T> boolean isSuccessRes(APIResult<T> result) {
        return !isFailRes(result);
    }

    public static <T> boolean isFailRes(APIResult<T> result) {
        return null == result || !result.isSuccess();
    }

    public static <T> boolean isSuccessResAndNotEmptyData(APIResult<T> result) {
        return !isFailResOrEmptyData(result);
    }

    public static <T> boolean isFailResOrEmptyData(APIResult<T> result) {
        return isFailRes(result) || null == result.getResult() || result.getResult() instanceof Collection && ((Collection)result.getResult()).isEmpty();
    }

    public String getReqUuid() {
        return this.reqUuid;
    }

    public void setReqUuid(String reqUuid) {
        this.reqUuid = reqUuid;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.reult;
    }

    public void setResult(T data) {
        this.reult = data;
    }

    public String toString() {
        return "APIResult(reqUuid=" + this.getReqUuid() + ", code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getResult() + ")";
    }

}

