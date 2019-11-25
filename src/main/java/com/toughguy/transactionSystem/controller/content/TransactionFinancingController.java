package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/financing")
@Slf4j
@Api(tags = "FinancingController")
public class TransactionFinancingController {
	@Autowired
	private ITransactionFinancingService transactionFinancingService; 
	
	// 新增融资内容
	@ApiOperation(value = "新增融资内容", notes = "发布融资的具体内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingName", value = "产品的名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingPeople", value = "发起企业（人）", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingContent", value = "融资产品内容", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingImg", value = "融资活动图片", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingStart", value = "活动开始时间", required = true, dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "financingEnd", value = "活动结束时间", required = true, dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "financingRank", value = "可报名等级", required = true, dataType = "String", paramType = "query"), })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addFinancing(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionFinancing transactionFinancing = new TransactionFinancing();
		transactionFinancing.setFinancingName(request.getParameter("financingName"));
		transactionFinancing.setFinancingPeople(request.getParameter("financingPeople"));
		transactionFinancing.setFinancingContent(request.getParameter("financingContent"));
		transactionFinancing.setFinancingImg(request.getParameter("financingImg"));
		transactionFinancing.setFinancingStart(DateUtil.getDate(request.getParameter("financingStart"), "yyyy-MM-dd HH:mm:ss"));
		transactionFinancing.setFinancingEnd(DateUtil.getDate(request.getParameter("financingEnd"), "yyyy-MM-dd HH:mm:ss"));
		transactionFinancing.setFinancingRank(Integer.parseInt(request.getParameter("financingRank")));
		try {
			transactionFinancingService.save(transactionFinancing);
			map.put("code", "200");
			map.put("msg", "发布成功");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	// 融资：查看未结束的融资活动
	@ApiOperation(value = "未结束的融资活动", notes = "默认查全部未结束的融资活动，可以传参page和rows进行分页查找，financingName进行关键字模糊查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingName", value = "融资项目名称", required = false, dataType = "String", paramType = "query"), })
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
	public String lookNoEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("financingName", request.getParameter("financingName"));
		PagerModel<TransactionFinancing> findPaginated = transactionFinancingService.findPaginated(params1);
		List<TransactionFinancing> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}

	// 查看结束的融资活动
	@ApiOperation(value = "融资：查看结束的融资活动", notes = "默认查全部结束的融资活动，可以传参page和rows进行分页查找，financingName进行关键字模糊查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingName", value = "融资项目名称", required = false, dataType = "String", paramType = "query"), })
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	public String lookEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("financingName", request.getParameter("financingName"));
		PagerModel<TransactionFinancing> findEndActivityPage = transactionFinancingService.findEndFinancingPage(params1);
		List<TransactionFinancing> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 查看某一个融资活动
	@ApiOperation(value = "查看具体某一个的融资活动", notes = "通过融资id来查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingId", value = "融资编号", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/lookFinancing", method = RequestMethod.GET)
	public String lookFinancing(int financingId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TransactionFinancing find = transactionFinancingService.find(financingId);
			map.put("code", "200");
			map.put("msg", "查找成功");
			map.put("date", find);
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	// 删除融资活动
	@ApiOperation(value = "删除融资活动", notes = "通过融资id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingId", value = "融资编号", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delFinancing(int financingId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			transactionFinancingService.delete(financingId);
			map.put("code", "200");
			map.put("msg", "删除成功");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
}
