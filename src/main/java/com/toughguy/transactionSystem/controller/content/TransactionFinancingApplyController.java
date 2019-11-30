package com.toughguy.transactionSystem.controller.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.model.content.vo.TransactionFinancingApplyRepaymentplanInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.content.prototype.IMemberService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingApplyRepaymentplanInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingApplyService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 融资申请的controller
 * @author liDongSheng
 *
 */
@RestController
@RequestMapping("/financingApply")
@Slf4j
@Api(tags="FinancingApplyController")
public class TransactionFinancingApplyController {
	@Autowired
	private ITransactionFinancingApplyService transactionFinancingApplyService;
	@Autowired
	private IFinancingapplyFinancingMemberEnterpriseInfoService financingapplyFinancingMemberEnterpriseInfoService;
	@Autowired
	private ITransactionFinancingApplyRepaymentplanInfoService transactionFinancingApplyRepaymentplanInfo;
	@Autowired
	private ITransactionFinancingService transactionFinancingService;
	@Autowired
	private IMemberService memberService; 
	// 会员提交融资申请
	@ApiOperation(value = "会员提交融资申请", notes = "填写融资申请的具体内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingId", value = "融资产品id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query"),
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addApply(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
			JSONObject json = requestJSONUtil.request(request, response);
			transactionFinancingApply.setFinancingId(json.getInteger("financingId"));
			transactionFinancingApply.setMemberId(json.getInteger("memberId"));
			TransactionFinancingApply judgeFinancingApply = transactionFinancingApplyService.judgeFinancingApply(transactionFinancingApply);
			if(judgeFinancingApply!=null) {
				map.put("code", "500");
				map.put("msg", "已报名");
			}else {
				Date now = new Date();
				TransactionFinancing financing = transactionFinancingService.find(json.getInteger("financingId"));
				TransactionMember member = memberService.find(json.getInteger("memberId"));
				if((now.compareTo(financing.getFinancingStart())==0||now.compareTo(financing.getFinancingStart())==1)&&(now.compareTo(financing.getFinancingEnd())==0||now.compareTo(financing.getFinancingEnd())==-1)) {
					if(member.getMemberRank()>=financing.getFinancingRank()) {
						transactionFinancingApplyService.save(transactionFinancingApply);
						map.put("code", "200");
						map.put("msg", "申请成功");
					}else {
						map.put("code", "500");
						map.put("msg", "会员等级不够");
					}
				}else {
					map.put("code", "500");
					map.put("msg", "报名时间已过");
				}
				
			}
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 会员：查看我通过的融资
	@ApiOperation(value = "会员：查看我通过的融资", notes = "默认查全部通过的融资活动，可以传参page和rows进行分页查找，会员id必传")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookPassFinancing", method = RequestMethod.GET)
	public String lookPassFinancing(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			Map<String, Object> params1 = new HashMap<String, Object>();
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			params1.put("memberId", memberId);
			PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findPaginated = financingapplyFinancingMemberEnterpriseInfoService.findPaginated(params1);
			List<FinancingapplyFinancingMemberEnterpriseInfo> data = findPaginated.getData();
			int total = findPaginated.getTotal();
			params.put("code", "200");
			params.put("msg", "查找成功");
			params.put("data", data);
			params.put("total", total);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return JsonUtil.objectToJson(params);
	}
	
	// 通过某人的融资请求
	@ApiOperation(value = "通过某人的融资请求", notes = "申请id必传")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "applyId", value = "申请id", required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/passRequest", method = RequestMethod.GET)
	public String passRequest(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			int applyId = Integer.parseInt(request.getParameter("applyId"));
			TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
			transactionFinancingApply.setApplyId(applyId);
			transactionFinancingApplyService.update(transactionFinancingApply);
			params.put("code", "200");
			params.put("msg", "修改成功");
		} catch (Exception e) {
			params.put("code", "500");
			params.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(params);
	}
	
	// 修改某人的融资状态
	@ApiOperation(value = "修改某人的融资状态", notes = "申请id必传")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "applyId", value = "申请id", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/completeStatus", method = RequestMethod.GET)
	public String completeStatus(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			int applyId = Integer.parseInt(request.getParameter("applyId"));
			TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
			transactionFinancingApply.setApplyId(applyId);
			transactionFinancingApplyService.updateFinancingCompleteStatus(transactionFinancingApply);
			params.put("code", "200");
			params.put("msg", "修改成功");
		} catch (Exception e) {
			params.put("code", "500");
			params.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(params);
	}
	
	//提示还款计划的数据列表(可以输任易一个月)
	@ApiOperation(value = "提示还款计划的数据列表(可以输任易的几个月)", notes = "默认查全部，可以传参page和rows进行分页查找，会员id必传")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/lookPromptDay", method = RequestMethod.GET)
	public String lookPromptDay(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			params1.put("memberId", memberId);
			PagerModel<TransactionFinancingApplyRepaymentplanInfo> findPaginated = transactionFinancingApplyRepaymentplanInfo
					.findPaginated(params1);
			List<TransactionFinancingApplyRepaymentplanInfo> data = findPaginated.getData();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<TransactionFinancingApplyRepaymentplanInfo> datas=new ArrayList<TransactionFinancingApplyRepaymentplanInfo>();
			for (TransactionFinancingApplyRepaymentplanInfo transactionFinancingApplyRepaymentplanInfo : data) {
				//是否还款
				Boolean financingCompleteStatus = transactionFinancingApplyRepaymentplanInfo.getFinancingCompleteStatus();
				// 还款结束
				if (financingCompleteStatus) {
//					params.put("code", "500");
//					params.put("msg", "没有还款项目");
					continue;
				} else {
					//还款计划开始的时间
					Date repaymentplanStart = transactionFinancingApplyRepaymentplanInfo.getRepaymentplanStart();
					//现在的时间
					Date now = new Date();
					//还款的周期
					int repaymentplanPeriod = transactionFinancingApplyRepaymentplanInfo.getRepaymentplanPeriod();
					Calendar time = Calendar.getInstance();
					time.setTime(repaymentplanStart);
					time.add(Calendar.MONTH, repaymentplanPeriod);
					// -得到第一个还款时间
					Date repayTime= time.getTime();
					while (true) {
						//得到下一次的还款日期
						if(sdf.format(now).compareTo(sdf.format(repayTime))==1) {
							time.setTime(repayTime);
							time.add(Calendar.MONTH, repaymentplanPeriod);
							repayTime= time.getTime();
						}else {
							break;
						}
					}
					// 设置还款提示的时间(提前一天)
					time.setTime(repayTime);
					time.add(Calendar.DATE, -1);
					//如果还款前一天的时间等于现在的时间，就发消息
					if (sdf.format(time.getTime()).compareTo(sdf.format(now))==0) {
						// 设置还款时间
						transactionFinancingApplyRepaymentplanInfo.setRepaymentplanDay(repayTime);
						//设置提示时间
						transactionFinancingApplyRepaymentplanInfo.setPromptDay(now);
						//将显示的列表添加到list集合
						datas.add(transactionFinancingApplyRepaymentplanInfo);
					}
					
				}
				
			}
			params.put("code", 200);
			params.put("msg", "查找成功");
			params.put("data", datas);
			params.put("total", datas.size());
		} catch (Exception e) {
			// TODO: handle exception
			params.put("code", 500);
			params.put("msg", "服务器异常");
		}
		return JsonUtil.objectToJson(params);
	}
		
	// 判断会员是否重复申请融资
	@ApiOperation(value = "判断会员是否重复申请融资", notes = "通过融资id和会员id进行判断是否报名")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingId", value = "融资的id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "memberId", value = "会员的id", required = true, dataType = "int", paramType = "query"), })
	@RequestMapping(value = "/judgeSignup", method = RequestMethod.GET)
	public String judgeSignup(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int financingId = Integer.parseInt(request.getParameter("financingId"));
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
			transactionFinancingApply.setFinancingId(financingId);;
			transactionFinancingApply.setMemberId(memberId);
			TransactionFinancingApply judgeFinancingApply = transactionFinancingApplyService.judgeFinancingApply(transactionFinancingApply);
			if (judgeFinancingApply != null) {
				map.put("code", "500");
				map.put("msg", "已报名");
			} else {
				map.put("code", "200");
				map.put("msg", "未报名");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return JsonUtil.objectToJson(map);
	}
}
