package com.teemo.miniapp.pojo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {
	private Long id;

	private String cityCode;

	private String adCode;

	private String name;

	private String center;

	private Integer level;

	private Long parentId;
}
