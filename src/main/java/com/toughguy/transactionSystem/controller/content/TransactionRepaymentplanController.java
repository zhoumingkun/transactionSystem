package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionRepaymentplan;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionRepaymentplanService;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 还款计划的controller
 * @author liDongSheng
 *
 */
@RestController
@RequestMapping("/repaymentplan")
@Slf4j
@Api(tags="RepaymentplanController")
public class TransactionRepaymentplanController {
	@Autowired
	private ITransactionRepaymentplanService transactionRepaymentplanService;
	
	// 通过融资，新建还款计划
	@ApiOperation(value = "新建还款计划", notes = "需要申请的id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "applyId", value = "申请的id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanStart", value = "还款的开始时间", required = true, dataType = "date", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanEnd", value = "还款的结束时间", required = true, dataType = "date", paramType = "query"), 
			@ApiImplicitParam(name = "repaymentplanMoneyall", value = "还款的总额", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "repaymentplanPeriod", value = "还款周期", required = true, dataType = "int", paramType = "query"), 
			@ApiImplicitParam(name = "repaymentplanPeriodMoney", value = "还款周期金额", required = true, dataType = "double", paramType = "query"), 
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRepaymentplan(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JSONObject json = requestJSONUtil.request(request, response);
			Integer applyId = json.getInteger("applyId");
			Date repaymentplanStart = json.getDate("repaymentplanStart");
			Date repaymentplanEnd = json.getDate("repaymentplanEnd");
			Double repaymentplanMoneyall = json.getDouble("repaymentplanMoneyall");
			Integer repaymentplanPeriod = json.getInteger("repaymentplanPeriod");
			Double repaymentplanPeriodMoney = json.getDouble("repaymentplanPeriodMoney");
			TransactionRepaymentplan transactionRepaymentplan = new TransactionRepaymentplan();
			transactionRepaymentplan.setApplyId(applyId);
			transactionRepaymentplan.setRepaymentplanStart(repaymentplanStart);
			transactionRepaymentplan.setRepaymentplanEnd(repaymentplanEnd);
			transactionRepaymentplan.setRepaymentplanMoneyall(repaymentplanMoneyall);
			transactionRepaymentplan.setRepaymentplanPeriod(repaymentplanPeriod);
			transactionRepaymentplan.setRepaymentplanPeriodMoney(repaymentplanPeriodMoney);
			transactionRepaymentplanService.save(transactionRepaymentplan);
			map.put("code", "200");
			map.put("msg", "新建成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
		
	// 修改还款计划
	@ApiOperation(value = "修改还款计划", notes = "需要还款id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "repaymentplanId", value = "还款id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanStart", value = "还款的开始时间", required = true, dataType = "date", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanEnd", value = "还款的结束时间", required = true, dataType = "date", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanMoneyall", value = "还款的总额", required = true, dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanPeriod", value = "还款周期", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "repaymentplanPeriodMoney", value = "还款周期金额", required = true, dataType = "double", paramType = "query"), })
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updateRepaymentplan(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JSONObject json = requestJSONUtil.request(request, response);
			Integer repaymentplanId = json.getInteger("repaymentplanId");
			Date repaymentplanStart = json.getDate("repaymentplanStart");
			Date repaymentplanEnd = json.getDate("repaymentplanEnd");
			Double repaymentplanMoneyall = json.getDouble("repaymentplanMoneyall");
			Integer repaymentplanPeriod = json.getInteger("repaymentplanPeriod");
			Double repaymentplanPeriodMoney = json.getDouble("repaymentplanPeriodMoney");
			TransactionRepaymentplan transactionRepaymentplan = new TransactionRepaymentplan();
			transactionRepaymentplan.setRepaymentplanId(repaymentplanId);
			transactionRepaymentplan.setRepaymentplanStart(repaymentplanStart);
			transactionRepaymentplan.setRepaymentplanEnd(repaymentplanEnd);
			transactionRepaymentplan.setRepaymentplanMoneyall(repaymentplanMoneyall);
			transactionRepaymentplan.setRepaymentplanPeriod(repaymentplanPeriod);
			transactionRepaymentplan.setRepaymentplanPeriodMoney(repaymentplanPeriodMoney);
			transactionRepaymentplanService.update(transactionRepaymentplan);
			map.put("code", "200");
			map.put("msg", "修改成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	//查看某一个还款计划
	@ApiOperation(value = "查看某一个还款计划", notes = "需要申请id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "applyId", value = "申请id", required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/lookOne", method = RequestMethod.GET)
	public String lookOneRepaymentplan(HttpServletRequest request, HttpServletResponse response) {
		int applyId = Integer.parseInt(request.getParameter("applyId"));
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionRepaymentplan transactionRepaymentplan = transactionRepaymentplanService.find(applyId);
		map.put("code", "200");
		map.put("msg", "修改成功");
		map.put("data", transactionRepaymentplan);
		return JsonUtil.objectToJson(map);
	}
	
}
