package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.toughguy.transactionSystem.model.content.po.TransactionLog;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.impl.TransactionLogServiceImpl;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 	日志管理controlller层
 * @author Guozhenze
 *
 */
@RestController
@RequestMapping("/log")
@Slf4j
@Api(value="日志管理")
public class TransactionLogController {
	
	@Autowired
	private ITransactionLogService logService;
	
	/**
	 * 	获取全部的日志
	 * @return
	 */
	
	@ApiOperation(value = "获取全部的日志",notes = "获取全部的日志")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "page", value = "页码",
            required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "行数",
        required = false, dataType = "int", paramType = "query")
	}) 
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	
	public String  getList() {
		Map<String, Object> map = new HashMap<>();
		PagerModel<TransactionLog> lits = null;
		
		try {
			lits = logService.findPaginated(null);
			map.put("code", 200);
			map.put("data", lits);
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg","服务器异常" );
		}
		return JSON.toJSONString(map);
	}
	


	/***
	 * 删除某个日志
	 * 
	 * @param request
	 * @return
	 */
	
	@ApiOperation(value = "删除某个日志",notes = "删除某个日志")
	@ApiImplicitParam(name = "logId", value = "日志id",
    required = true, dataType = "int", paramType = "query")
	@RequestMapping(value="update" , method=RequestMethod.GET)
	public String getDelete(HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		int id = 0 ; 
		try {
			id = Integer.parseInt(request.getParameter("logId"));
		} catch (NumberFormatException e) {
			map.put("code", "500");
			map.put("msg", "请正确传入参数");
			return JSON.toJSONString(map).toString();
		}
		try {
			logService.delete(id);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JSON.toJSONString(map).toString();
		}
		map.put("code", "200");
		map.put("msg", "seccess");
		return JSON.toJSONString(map).toString();
	}
	
}
