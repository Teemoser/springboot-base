package com.teemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teemo.common.db.mapper.BaseMapper;
import com.teemo.entity.AddressDict;
import com.teemo.miniapp.pojo.dto.AddressDto;

public interface AddressDictMapper extends BaseMapper<AddressDict> {

	List<AddressDto> list(@Param("name") String name);
}