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
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingApplyService;
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
	
	// 会员提交融资申请
	@ApiOperation(value = "会员提交融资申请", notes = "填写融资申请的具体内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "financingId", value = "融资产品id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query"),
			/*@ApiImplicitParam(name = "applyEnterpriseName", value = "企业名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "enterpriseCode", value = "企业代码", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "applyMoney", value = "资金需求", required = true, dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "listedTime", value = "挂牌时间", required = true, dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "financingDo", value = "融资用途", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "whetherMortgage", value = "是否有抵押", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "complianceSituation", value = "合规情况", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "enterpriseSetupTime", value = "企业成立时间", required = true, dataType = "date", paramType = "query"),
			@ApiImplicitParam(name = "enterpriseRegProvince", value = "企业注册省", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "enterpriseRegCity", value = "企业注册市", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "enterpriseRegCounties", value = "企业注册区（县）", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "applyPersonName", value = "姓名", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "applyPersonTel", value = "电话", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "applyPersonPosition", value = "职务", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "applyPersonEmail", value = "邮箱", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "enterpriseRegMoney", value = "注册资本", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "lastYearIncome", value = "上一年收入", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "lastYearSharp", value = "上一年营业利", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "lastYearNetprofit", value = "上一年净利润", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "netassetSize", value = "净资产规模", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "lastYearGrossProfit", value = "上一年毛利润", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "assetsDebtRatio", value = "资产负债率", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "yearGrowthRate", value = "一年增长率", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "halfYearSales", value = "半年销售", required = true, dataType = "double", paramType = "query"), 
			@ApiImplicitParam(name = "competitiveAdvantageContent", value = "竞争优势内容", required = true, dataType = "string", paramType = "query"), 
			@ApiImplicitParam(name = "applyImg", value = "图片", required = true, dataType = "string", paramType = "query"), 
			@ApiImplicitParam(name = "applyDate", value = "申请时间", required = true, dataType = "date", paramType = "query"),*/ 
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addApply(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
			JSONObject json = requestJSONUtil.request(request, response);
			transactionFinancingApply.setFinancingId(json.getInteger("financingId"));
			transactionFinancingApply.setMemberId(json.getInteger("memberId"));
			/*transactionFinancingApply.setApplyEnterpriseName(json.getString("applyEnterpriseName"));
			transactionFinancingApply.setEnterpriseCode(json.getString("enterpriseCode"));
			transactionFinancingApply.setApplyMoney(json.getDouble("applyMoney"));
			transactionFinancingApply.setListedTime(json.getDate("listedTime"));
			transactionFinancingApply.setFinancingDo(json.getString("financingDo"));
			transactionFinancingApply.setWhetherMortgage(json.getString("whetherMortgage"));
			transactionFinancingApply.setComplianceSituation(json.getString("complianceSituation"));
			transactionFinancingApply.setEnterpriseSetupTime(json.getDate("enterpriseSetupTime"));
			transactionFinancingApply.setEnterpriseRegProvince(json.getString("enterpriseRegProvince"));
			transactionFinancingApply.setEnterpriseRegCity(json.getString("enterpriseRegCity"));
			transactionFinancingApply.setEnterpriseRegCounties(json.getString("enterpriseRegCounties"));
			transactionFinancingApply.setApplyPersonName(json.getString("applyPersonName"));
			transactionFinancingApply.setApplyPersonTel(json.getString("applyPersonTel"));
			transactionFinancingApply.setApplyPersonPosition(json.getString("applyPersonPosition"));
			transactionFinancingApply.setApplyPersonEmail(json.getString("applyPersonEmail"));
			transactionFinancingApply.setEnterpriseRegMoney(json.getDouble("enterpriseRegMoney"));
			transactionFinancingApply.setLastYearIncome(json.getDouble("lastYearIncome"));
			transactionFinancingApply.setLastYearSharp(json.getDouble("lastYearSharp"));
			transactionFinancingApply.setLastYearNetprofit(json.getDouble("lastYearNetprofit"));
			transactionFinancingApply.setNetassetSize(json.getDouble("netassetSize"));
			transactionFinancingApply.setLastYearGrossProfit(json.getDouble("lastYearGrossProfit"));
			transactionFinancingApply.setAssetsDebtRatio(json.getDouble("assetsDebtRatio"));
			transactionFinancingApply.setYearGrowthRate(json.getDouble("yearGrowthRate"));
			transactionFinancingApply.setHalfYearSales(json.getDouble("halfYearSales"));
			transactionFinancingApply.setCompetitiveAdvantageContent(json.getString("competitiveAdvantageContent"));
			transactionFinancingApply.setApplyImg(json.getString("applyImg"));
			transactionFinancingApply.setApplyDate(json.getDate("applyDate"));*/
			transactionFinancingApplyService.save(transactionFinancingApply);
			map.put("code", "200");
			map.put("msg", "申请成功");
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
		Map<String, Object> params1 = new HashMap<String, Object>();
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		params1.put("memberId", memberId);
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findPaginated = financingapplyFinancingMemberEnterpriseInfoService.findPaginated(params1);
		List<FinancingapplyFinancingMemberEnterpriseInfo> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "200");
		params.put("msg", "查找成功");
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}
	
	// 通过某人的融资请求
	@ApiOperation(value = "通过某人的融资请求", notes = "申请id必传")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "applyId", value = "申请id", required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/passRequest", method = RequestMethod.GET)
	public String passRequest(HttpServletRequest request, HttpServletResponse response) {
		int applyId = Integer.parseInt(request.getParameter("applyId"));
		TransactionFinancingApply transactionFinancingApply = new TransactionFinancingApply();
		transactionFinancingApply.setApplyId(applyId);
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			transactionFinancingApplyService.update(transactionFinancingApply);
			params.put("code", "200");
			params.put("msg", "修改成功");
		} catch (Exception e) {
			params.put("code", "500");
			params.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(params);
	}
	
	
	
}
