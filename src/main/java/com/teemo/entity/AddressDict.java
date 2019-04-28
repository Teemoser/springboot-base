package com.teemo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "address_dict")
@Getter
@Setter
@Builder
public class AddressDict {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cityCode;

	private String adCode;

	private String name;

	private String center;

	private Integer level;

	private Long parentId;

}