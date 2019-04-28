package com.teemo.common.controller;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.teemo.common.exception.ResponseInfo;

import lombok.Setter;

@Setter
public class BaseApiDataResult<T> extends ResponseInfo<T> implements Serializable {

	private static final long serialVersionUID = -8347959172995732259L;
	
    private BaseListDataResult data;


    @Override
    public void setData(Object data) {
        super.setData(data);
    }

    public BaseApiDataResult(List<T> data, Integer pageNum, Integer pageSize){

        this.data = BaseListDataResult.builder().build();
        if(null != data && data.size() > 0){
            data.removeAll(Collections.singleton(null));
            this.data.setList(data);
        }
        this.data.setPageNum(pageNum);
        this.data.setPageSize(pageSize);
        setData(this.data);
    }
}


