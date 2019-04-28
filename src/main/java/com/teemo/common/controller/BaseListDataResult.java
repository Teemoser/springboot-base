package com.teemo.common.controller;


import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseListDataResult {

    private Integer pageSize;

    private Integer pageNum;

    private List<?> list;
}
