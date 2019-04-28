package com.teemo.common.db.service.impl;

import com.github.pagehelper.PageHelper;
import com.teemo.common.db.mapper.BaseMapper;
import com.teemo.common.db.service.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public int saveList(List<T> list) {
		return baseMapper.insertList(list);
	}

	@Override
	public int save(T t) {
		return baseMapper.insert(t);
	}

	@Override
	public int update(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}

	@Override
	public int delete(T t) {
		return baseMapper.delete(t);
	}

	@Override
	public T selectOne(T t) {
		return baseMapper.selectOne(t);
	}

	@Override
	public List<T> selectList(T t) {
		return baseMapper.select(t);
	}

	@Override
	public List<T> selectListPage(T t,int pageNum,int pageSize){

		PageHelper.startPage(pageNum,pageSize);
		return baseMapper.select(t);
	};
}