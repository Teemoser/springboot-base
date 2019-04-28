package com.teemo.common.exception;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseInfo<T> {
    //错误信息
    private String msg;
    //错误码
    private Integer code;
    //错误数据
    private Object data;
    //时间
    private long currentDate;

    public ResponseInfo(){

    }

    /**
     *
     * @param code 错误编码
     * @param msg  错误信息
     * @param data 错误数据
     */
    public ResponseInfo(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.currentDate = System.currentTimeMillis();
    }

    public void setData(Object data){
        this.data = data;

    }
    /**
     * 不带错误数据返回
     * @param resultStatusEnum
     */
    public ResponseInfo(ResultStatusEnum resultStatusEnum){
        this.code = resultStatusEnum.getErrorCode();
        this.msg = resultStatusEnum.getErrorMsg();
//        this.data = data;
        this.currentDate = System.currentTimeMillis();
    }

    /**
     * 带错误数据返回
     * @param resultStatusEnum
     * @param data
     */
    public ResponseInfo(ResultStatusEnum resultStatusEnum, T data){
        this.code = resultStatusEnum.getErrorCode();
        this.msg = resultStatusEnum.getErrorMsg();
        this.data = data;
        this.currentDate = System.currentTimeMillis();
    }

}
