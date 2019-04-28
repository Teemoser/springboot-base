package com.teemo.miniapp.pojo.vo;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressVo {
	private Long id;

	private String cityCode;

	private String adCode;

	@NotNull(message = "地址名称非空")
	private String name;

	private String center;

	private Integer level;

	private Long parentId;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
}
