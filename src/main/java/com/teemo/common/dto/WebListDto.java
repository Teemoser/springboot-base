package com.teemo.common.dto;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WebListDto {
	// 总页数
	private Integer totalSize = 1;

	// 总条数
	private Long totalCount = 0L;

	private Integer pageNum;

	private Integer pageSize;

	private List<?> list;

	public WebListDto(PageInfo<?> pageInfo) {
		if (null != pageInfo) {
			this.totalCount = pageInfo.getTotal();
			this.totalSize = pageInfo.getPages();
			this.pageNum = pageInfo.getPageNum();
			this.pageSize = pageInfo.getPageSize();
			this.list = pageInfo.getList();
		}
	}
}
