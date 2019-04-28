package com.teemo.common.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.teemo.common.dto.WebListDto;
import com.teemo.common.exception.ResponseInfo;
import com.teemo.common.exception.ResultStatusEnum;

public class BaseController {

	protected ResponseInfo<?> createResult(int code, String msg) {

		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	protected ResponseInfo<Object> createDataResult(Object t) {

		ResponseInfo<Object> result = new ResponseInfo<>();
		result.setData(t);
		result.setCode(ResultStatusEnum.SUCCESS.getErrorCode());
		result.setMsg(ResultStatusEnum.SUCCESS.getErrorMsg());
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	protected ResponseInfo<?> createResult() {

		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(ResultStatusEnum.SUCCESS.getErrorCode());
		result.setMsg(ResultStatusEnum.SUCCESS.getErrorMsg());
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	protected ResponseInfo<?> createBadRequest() {
		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(ResultStatusEnum.http_status_bad_request.getErrorCode());
		result.setMsg(ResultStatusEnum.http_status_bad_request.getErrorMsg());
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	/**
	 * 创建 api列表返回
	 * 
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	protected ResponseInfo<?> createApiListData(List<?> t, Integer pageNum, Integer pageSize) {

		BaseApiDataResult<?> result = new BaseApiDataResult<>(t, pageNum, pageSize);
		result.setCode(ResultStatusEnum.SUCCESS.getErrorCode());
		result.setMsg(ResultStatusEnum.SUCCESS.getErrorMsg());
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	protected ResponseInfo<?> createBadRequest(String msg) {

		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(ResultStatusEnum.http_status_bad_request.getErrorCode());
		result.setMsg(msg);
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

	protected ResponseInfo<?> createWebListResult(PageInfo<?> pageInfo) {

		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(ResultStatusEnum.SUCCESS.getErrorCode());
		result.setMsg(ResultStatusEnum.SUCCESS.getErrorMsg());
		result.setData(new WebListDto(pageInfo));
		result.setCurrentDate(System.currentTimeMillis());
		return result;
	}

//    /**
//     * 得到登录用户手机号
//     * @param request
//     * @return
//     */
//    protected String getLoginCustomerPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws LoginException {
//
//        String auth = request.getHeader("Authorization");
//
//        Claims claims = null;
//        try {
//
//            claims = JwtUtil.checkHandlerAuth(auth, jwtProperty.getBase64Secret());
//        }catch (ExpiredJwtException e){
//
//            auth = response.getHeader("refreshToken");
//            claims = JwtUtil.checkHandlerAuth(auth, jwtProperty.getBase64Secret());
//        }
//
//        if (claims != null && null != claims.get("phoneNumber")) {
//
//            return String.valueOf(claims.get("phoneNumber"));
//        }
//        throw new LoginException("登录超时");
//    }

//    /**
//     * 得到登录用户id
//     * @param request
//     * @return
//     */
//    protected String getLoginCustomerId(HttpServletRequest request, HttpServletResponse response) throws LoginException {
//
//        String auth = request.getHeader("Authorization");
//
//        Claims claims = null;
//        try {
//
//            claims = JwtUtil.checkHandlerAuth(auth, jwtProperty.getBase64Secret());
//        }catch (ExpiredJwtException e){
//
//            auth = response.getHeader("refreshToken");
//            claims = JwtUtil.checkHandlerAuth(auth, jwtProperty.getBase64Secret());
//        }
//
//        if (claims != null && null != claims.get("id")) {
//
//            return String.valueOf(claims.get("id"));
//        }
//
//        throw new LoginException("登录超时");
//
//    }
}
