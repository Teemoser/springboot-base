package com.teemo.common.db.service;

import java.util.List;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2018年3月1日
 * @description service基类
 */
public interface IBaseService<T> {

	/**
	 * 新增一组记录
	 * 
	 * @param list
	 * @return
	 */
	int saveList(List<T> list);

	/**
	 * 新增一条记录
	 * 
	 * @param t
	 * @return
	 */
	int save(T t);

	/**
	 * 根据主键修改一条记录
	 * 
	 * @param t
	 * @return
	 */
	int update(T t);

	/**
	 * 根据指定条件删除记录
	 * 
	 * @param t
	 * @return
	 */
	int delete(T t);

	/**
	 * 根据条件查询一条记录
	 * 
	 * @param t
	 * @return
	 */
	T selectOne(T t);

	/**
	 * 根据条件查询集合
	 * 
	 * @param t
	 * @return
	 */
	List<T> selectList(T t);

	/**
	 * 根据条件查询集合
	 * @param t
	 * @param pageNum	分页参数
	 * @param pageSize	分页参数
	 * @return
	 */
	List<T> selectListPage(T t,int pageNum,int pageSize);
}