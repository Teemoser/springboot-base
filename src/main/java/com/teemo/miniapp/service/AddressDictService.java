package com.teemo.miniapp.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.teemo.common.db.service.IBaseService;
import com.teemo.entity.AddressDict;
import com.teemo.miniapp.pojo.dto.AddressDto;
import com.teemo.miniapp.pojo.vo.AddressVo;

public interface AddressDictService extends IBaseService<AddressDict> {

	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description api分页查询demo，用于移动端上下拉刷新
	 */
	List<AddressDto> list(Integer pageSize,Integer pageNum, String provinceName);
	
	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description api分页查询demo，用于移动端上下拉刷新
	 */
	PageInfo<AddressDto> listForWeb(Integer pageSize,Integer pageNum, String provinceName);
	
	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description 修改编辑demo
	 */
	void saveOrUpdate(AddressVo vo);
}
