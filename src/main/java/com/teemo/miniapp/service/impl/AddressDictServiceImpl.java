package com.teemo.miniapp.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teemo.common.db.service.impl.BaseServiceImpl;
import com.teemo.entity.AddressDict;
import com.teemo.mapper.AddressDictMapper;
import com.teemo.miniapp.pojo.dto.AddressDto;
import com.teemo.miniapp.pojo.vo.AddressVo;
import com.teemo.miniapp.service.AddressDictService;

@Service
public class AddressDictServiceImpl extends BaseServiceImpl<AddressDict> implements AddressDictService {

	@Autowired
	private AddressDictMapper addressMapper;

	@Override
	public List<AddressDto> list(Integer pageSize, Integer pageNum, String provinceName) {
		PageInfo<AddressDto> pageInfo = PageHelper.startPage(pageNum, pageSize)
				.doSelectPageInfo(() -> addressMapper.list(provinceName));
		return pageInfo.getList();
	}

	@Override
	public PageInfo<AddressDto> listForWeb(Integer pageSize, Integer pageNum, String provinceName) {
		PageInfo<AddressDto> pageInfo = PageHelper.startPage(pageNum, pageSize)
				.doSelectPageInfo(() -> addressMapper.list(provinceName));
		return pageInfo;
	}

	@Override
	public void saveOrUpdate(AddressVo vo) {
		AddressDict address = AddressDict.builder().build();
		// 浅拷贝
		BeanUtils.copyProperties(vo, address);
		if (null == vo.getId()) {
			// 新增
			this.save(address);
		} else {
			// 编辑
			this.update(address);
		}
	}

}
