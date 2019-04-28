package com.teemo.miniapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teemo.common.controller.BaseController;
import com.teemo.common.exception.ResponseInfo;
import com.teemo.miniapp.pojo.vo.AddressVo;
import com.teemo.miniapp.service.AddressDictService;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2019年4月28日
 * @description controller demo
 */
@RequestMapping("/address")
@RestController
public class DemoController extends BaseController {

	@Autowired
	private AddressDictService addressDictService;

	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description api分页 demo，用于移动端上下拉刷新
	 */
	@GetMapping(value = "/list")
	public ResponseInfo<?> list(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum,
			String provinceName) {
		return createApiListData(addressDictService.list(pageSize, pageNum, provinceName), pageNum, pageSize);
	}

	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description web分页 demo，用于后台分页查询
	 */
	@GetMapping(value = "/listForWeb")
	public ResponseInfo<?> listForWeb(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageNum") Integer pageNum, String provinceName) {
		return createWebListResult(addressDictService.listForWeb(pageSize, pageNum, provinceName));
	}

	/**
	 * @author xiaojin_wu
	 * @email wuxiaojin258@126.com
	 * @date 2019年4月28日
	 * @description 新增编辑 demo
	 */
	@PostMapping(value = "/saveOrUpdate")
	public ResponseInfo<?> saveOrUpdate(@RequestBody AddressVo vo) {
		addressDictService.saveOrUpdate(vo);
		return createResult();
	}
}
