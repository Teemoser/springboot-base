package com.teemo.common.db.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2018年2月2日
 * @description mybatis通用mapper基类
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}