package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 融资controller
 * @author liDongSheng
 *
 */
@RestController
@RequestMapping("/financing")
@Slf4j
@Api(tags = "FinancingController")
public class TransactionFinancingController {
	@Autowired
	private ITransactionFinancingService transactionFinancingService; 
	@Autowired
	private IFinancingapplyFinancingMemberEnterpriseInfoService financingapplyFinancingInfoService;
	
	// 新增融资内容
	@ApiOperation(value = "新增融资内容", notes = "发布融资的具体内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingName", value = "产品的名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingPeople", value = "发起企业（人）", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingContent", value = "融资产品内容", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingImg", value = "融资活动图片", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "financingStart", value = "活动开始时间", required = true, dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "financingEnd", value = "活动结束时间", required = true, dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "financingRank", value = "可报名等级", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addFinancing(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionFinancing transactionFinancing = new TransactionFinancing();
		transactionFinancing.setFinancingName(json.getString("financingName"));
		transactionFinancing.setFinancingPeople(json.getString("financingPeople"));
		transactionFinancing.setFinancingContent(json.getString("financingContent"));
		transactionFinancing.setFinancingImg(json.getString("financingImg"));
		transactionFinancing.setFinancingStart(json.getDate("financingStart"));
		transactionFinancing.setFinancingEnd(json.getDate("financingEnd"));
		transactionFinancing.setFinancingRank(json.getInteger("financingRank"));
		try {
			transactionFinancingService.save(transactionFinancing);
			map.put("code", "200");
			map.put("msg", "发布成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 融资：查看未结束的融资活动 连微信的搜索框
	@ApiOperation(value = "融资：未结束的融资活动 连微信的搜索框", notes = "默认查全部未结束的融资活动，可以传参page和rows进行分页查找，tradeId和addressId在微信端进行所在区域和企业类型的分类，financingName是在pc端搜索名称，微信端可以输入区域的名字或者企业的类型")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingName", value = "融资项目名称", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "tradeId", value = "企业分类", required = false, dataType = "int", paramType = "query"), 
			@ApiImplicitParam(name = "addressId", value = "所在区域", required = false, dataType = "int", paramType = "query"), 
	})
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
	public String lookNoEnd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String financingName = request.getParameter("financingName");
		String tradeId = request.getParameter("tradeId");
		String addressId = request.getParameter("addressId");
		params1.put("financingName", financingName);
		params1.put("tradeId", tradeId);
		params1.put("addressId", addressId);
		PagerModel<TransactionFinancing> findPaginated = transactionFinancingService.findPaginated(params1);
		List<TransactionFinancing> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "200");
		params.put("msg", "查找成功");
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}

	// 查看结束的融资活动
	@ApiOperation(value = "融资：查看结束的融资活动", notes = "默认查全部结束的融资活动，可以传参page和rows进行分页查找，financingName进行关键字模糊查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingName", value = "融资项目名称", required = false, dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	public String lookEnd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String financingName = request.getParameter("financingName");
		params1.put("financingName", financingName);
		PagerModel<TransactionFinancing> findEndActivityPage = transactionFinancingService.findEndFinancingPage(params1);
		List<TransactionFinancing> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 查看某一个融资活动内容
	@ApiOperation(value = "查看具体某一个的融资活动", notes = "通过融资id来查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "financingId", value = "融资编号", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/lookFinancing", method = RequestMethod.GET)
	public String lookFinancing(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financingId = Integer.parseInt(request.getParameter("financingId"));
		try {
			TransactionFinancing find = transactionFinancingService.find(financingId);
			map.put("code", "200");
			map.put("msg", "查找成功");
			map.put("data", find);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 查看某一个融资活动中待启动的融资
	@ApiOperation(value = "查看某一个融资活动中待启动的融资", notes = "默认查全部结束的融资活动，可以传参page和rows进行分页查找，financingId进行查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingId", value = "融资id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookStartFinancing", method = RequestMethod.GET)
	public String lookStartFinancing(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String financingId = request.getParameter("financingId");
		params1.put("financingId", financingId);
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndActivityPage = financingapplyFinancingInfoService.findStartFinancingList(params1);
		List<FinancingapplyFinancingMemberEnterpriseInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 查看某一个融资活动中进行的融资
	@ApiOperation(value = "查看某一个融资活动中进行的融资", notes = "默认查全部结束的融资活动，可以传参page和rows进行分页查找，financingId进行查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingId", value = "融资id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookRunFinancing", method = RequestMethod.GET)
	public String lookRunFinancing(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String financingId = request.getParameter("financingId");
		params1.put("financingId", financingId);
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndActivityPage = financingapplyFinancingInfoService
				.findRunFinancingList(params1);
		List<FinancingapplyFinancingMemberEnterpriseInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 查看某一个融资活动中结束的融资
	@ApiOperation(value = "查看某一个融资活动中结束行的融资", notes = "默认查全部结束的融资活动，可以传参page和rows进行分页查找，financingId进行查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingId", value = "融资id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookEndFinancing", method = RequestMethod.GET)
	public String lookEndFinancing(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String financingId = request.getParameter("financingId");
		params1.put("financingId", financingId);
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndActivityPage = financingapplyFinancingInfoService
				.findEndFinancingList(params1);
		List<FinancingapplyFinancingMemberEnterpriseInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 删除融资活动
	@ApiOperation(value = "删除融资活动", notes = "通过融资id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "financingId", value = "融资编号", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delFinancing(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financingId = Integer.parseInt(request.getParameter("financingId"));
		try {
			transactionFinancingService.delete(financingId);
			map.put("code", "200");
			map.put("msg", "删除成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 更新浏览量
	@ApiOperation(value = "更新浏览量", notes = "通过融资id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "financingId", value = "融资编号", required = true, dataType = "int", paramType = "query") 
	})
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyFinancing(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financingId = Integer.parseInt(request.getParameter("financingId"));
		try {
			TransactionFinancing transactionFinancing = new TransactionFinancing();
			transactionFinancing.setFinancingId(financingId);
			transactionFinancingService.update(transactionFinancing);
			map.put("code", "200");
			map.put("msg", "更新成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 查看热门的融资活动
	@ApiOperation(value = "融资：查看热门的融资活动", notes = "默认查全部热门的融资活动，顺序是从大到小（浏览量），可以传参page和rows进行分页查找，通过设置financingPv（访问量），显示大于等于多少访问量的产品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "financingPv", value = "访问量", required = false, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookHostFinancing", method = RequestMethod.GET)
	public String lookHostFinancing(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("financingPv", request.getParameter("financingPv"));
		PagerModel<TransactionFinancing> findHostActivityPage = transactionFinancingService.findHostFinancingPage(params1);
		List<TransactionFinancing> data = findHostActivityPage.getData();
		int total = findHostActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
}
