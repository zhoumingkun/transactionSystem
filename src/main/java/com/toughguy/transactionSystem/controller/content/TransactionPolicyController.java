package com.toughguy.transactionSystem.controller.content;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.po.TransactionIntegal;
import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionIntegalService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionPolicyService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.transaction.TransactionID;

/**
 * 
 * 	政策
 * @author Guozhenze
 *
 */

@RestController
@RequestMapping("/policy")
@Slf4j
@Api(value="政策")
public class TransactionPolicyController {
	
	
	@Autowired
	private  ITransactionPolicyService  policyService;
	@Autowired
	private ITransactionLogService logService;
	@Autowired
	private IEnterpriseService enterpriseService;
	@Autowired
	private ITransactionIntegalService integalService;
	/**
	 * 
	 * 	查看所有的政策
	 * @return
	 */
	
	@ApiOperation(value = "查看所有的政策",notes = "查看所有的政策")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "page", value = "页数",
            required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
        required = true, dataType = "int", paramType = "query")
	}) 
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String getSelect() {
		PagerModel<TransactionPolicy> pa;
		try {
			pa = policyService.findPaginated(null);
			return JSON.toJSONString(pa);
		} catch (Exception e) {
			return "{msg:服务器错误,code:500}";
		}
		
	}
	
	
	/***
	 * 
	 * 	政策的智能匹配
	 * @return
	 */
	@ApiOperation(value = "智能匹配",notes = "修改政策")
	@ApiImplicitParam(name = "memberId", value = "用户id",
        required = true, dataType = "int", paramType = "query")
	@RequestMapping(value = "/intelligent",method=RequestMethod.GET)
	public String getIntelligence(HttpServletRequest request) {
		int memberId = Integer.parseInt(request.getParameter("memberId"));		
		// - 查询用户信息
		TransactionEnterprise m = enterpriseService.find(memberId);
		// - 查找出所有的政策信息
		PagerModel<TransactionPolicy> findPaginated = policyService.findPaginated(null);
		List<TransactionPolicy> lists = findPaginated.getData();
		// - 遍历所有的政策信息，11对比
		for (int i = 0; i <lists.size(); i++) {
			TransactionIntegal integral =  integalService.find(1);
			int num = 0;
			if(m.getEnterpriseAddressId()==lists.get(i).getEnterpriseAddressId()) {
				num += integral.getEnterpriseAddress(); 
			}
			if(m.getEnterpriseTypeId() == lists.get(i).getEnterpriseTypeId()) {
				num += integral.getEnterpriseType();
			}
			if(m.getEnterpriseAreaId() == lists.get(i).getEnterpriseAreaId()) {				
				num += integral.getEnterpriseArea();
			}
			if(m.getEnterpriseTradeId() == lists.get(i).getEnterpriseTradeId()) {
				num += integral.getEnterpriseTrade();
			}
			num = num*100 / (integral.getEnterpriseAddress()+
								integral.getEnterpriseArea()+
								integral.getEnterpriseTrade()+
								integral.getEnterpriseType());
			lists.get(i).setIntelligentMatching(num);
		}
		return JSON.toJSONString(lists);
	}
	
	
	
	/**
	 * 	修改政策
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "修改政策",notes = "修改政策")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "policyId", value = "id",
            required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAreaId", value = "所属领域id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTradeId", value = "所属行业id",
        required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "policyName", value = "政策名称",
	        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyUnit", value = "发布单位",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyContent", value = "政策内容",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyTime", value = "发布时间",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAddressId", value = "所属区域",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "policMoney", value = "奖励金额",
        required = true, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query")		
	}) 
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String getUpdate(HttpServletRequest request,HttpServletResponse response) {

		try {
			JSONObject json = requestJSONUtil.request(request, response);
			int policyId = json.getInteger("policyId");
			int enterpriseAreaId = json.getInteger("enterpriseAreaId");
			int enterpriseTradeId = json.getInteger("enterpriseTradeId");
			String policyName = json.getString("policyName");
			String policyUnit = json.getString("policyUnit");
			int rootId =  json.getInteger("rootId");
			String policyContent = json.getString("policyContent");
			String policyTime = json.getString("policyTime");
			int enterpriseAddressId = json.getInteger("enterpriseAddressId");
			int enterpriseTypeId = json.getInteger("enterpriseTypeId");
			String policMoney = request.getParameter("policMoney");
			TransactionPolicy policy  = new TransactionPolicy(
					policyId,enterpriseAreaId,enterpriseTradeId,
					policyName,policyUnit,policyContent,DateUtil.getDate(policyTime),
					enterpriseAddressId,enterpriseTypeId,Double.parseDouble(policMoney)
					);
			policyService.update(policy);
			logService.insert("修改了"+policyName+"政策", rootId);
			return "{msg:succer,code:200}";
		} catch (Exception e) {
			return "{msg:服务器错误,code:500}";
		}
		
	}
	/**
	 * 	新增政策
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "新增政策",notes = "新增政策")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "enterpriseAreaId", value = "所属领域id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTradeId", value = "所属行业id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "policyName", value = "政策名称",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyUnit", value = "发布单位",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyContent", value = "政策内容",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "policyTime", value = "发布时间",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAddressId", value = "所属区域",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "policMoney", value = "奖励金额",
        required = true, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query")	
	}) 
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String getAdd(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("aaa");
		try {
	
			JSONObject json = requestJSONUtil.request(request, response);
			System.out.println(json);
			int enterpriseAreaId = json.getInteger("enterpriseAreaId");
			System.out.println(enterpriseAreaId);
			int enterpriseTradeId = json.getInteger("enterpriseTradeId");
			String policyName = json.getString("policyName");
			String policyUnit = json.getString("policyUnit");
			int rootId =  json.getInteger("rootId");
			String policyContent = json.getString("policyContent");
			String policyTime = json.getString("policyTime");
			int enterpriseAddressId = json.getInteger("enterpriseAddressId");
			int enterpriseTypeId = json.getInteger("enterpriseTypeId");
			String policMoney = json.getString("policMoney");
			TransactionPolicy policy  = new TransactionPolicy(
					enterpriseAreaId,enterpriseTradeId,
					policyName,policyUnit,policyContent,DateUtil.getDate(policyTime),
					enterpriseAddressId,enterpriseTypeId,Double.parseDouble(policMoney)
					);
			policyService.save(policy);
			logService.insert("发布 "+policyName+"政策", rootId);
			return "{'msg':'succer','code':200}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{'msg':'服务器错误',code:500}";
		}
	}
	
	
	/**
	 * 	删除政策
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "删除政策",notes = "删除政策")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "policyId", value = "所属领域id",
				required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rootId", value = "管理员id",
	    required = true, dataType = "int", paramType = "query")	})
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String getDelete(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			System.out.println(11111);
			policyService.delete(Integer.parseInt(request.getParameter("policyId")));
			int rootId = Integer.parseInt(request.getParameter("rootId"));
			logService.insert("删除政策", rootId);
			map.put("code", 200);
			map.put("msg", "success");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "服务器错误");
			return JSON.toJSONString(map);
		}
	}
	
	/**
	 * 
	 * 	根据所在区域或者企业的类型进行政策匹配
	 * @param request
	 * @return
	 */
	
	@ApiOperation(value = "根据所在区域或者企业类型进行查询",notes = "根据所在区域或者企业的类型进行政策匹配")

	@ApiImplicitParams({
		@ApiImplicitParam(name = "enterpriseAddressId", value = "所属区域id",
				required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "行业类型id",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页数",
        required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
		required = false, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/selectOrId",method = RequestMethod.GET)
	public String getListOrId(HttpServletRequest request) {
		PagerModel<TransactionPolicy> pa;
		try {
			Map<String,Object> params = new HashMap<>();
			try {
				int enterpriseAddressId;
				try {
					enterpriseAddressId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
					params.put("enterpriseAddressId", enterpriseAddressId);
				} catch (Exception e) {
				}
				try {
					int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));					
					params.put("enterpriseTypeId", enterpriseTypeId);
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
			pa = policyService.selectOrId(params);
			return JSON.toJSONString(pa);
		} catch (Exception e) {
			e.printStackTrace();
			return "{msg:服务器错误,code:500}";
		}
	}
	
	
	@ApiOperation(value = "模糊查询",notes = "政策的模糊查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "policyName", value = "模糊查询的条件",
				required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页数",
        required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
		required = false, dataType = "int", paramType = "query")
	})
	@RequestMapping(value  ="/like",method=RequestMethod.GET)
	public String getSelectLike(HttpServletRequest request) {
		Map<String ,Object> map = new HashMap<>();
		String policyName = request.getParameter("policyName");
		map.put("policyName", policyName);
		PagerModel<TransactionPolicy> list = policyService.selectLike(map);
		return JSON.toJSONString(list).toString();
	}
	
	
	@ApiOperation(value = "根据政策名字 和行业id或者领域id进行筛选或企业类型id进行筛选",notes = "根据政策名字 和行业id或者领域id进行筛选或企业类型id进行筛选")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "policyName", value = "政策名字",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAddressId", value = "所属区域id",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "行业类型id",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTradeId", value = "企業类型id",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页数",
        required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
		required = false, dataType = "int", paramType = "query")
	})
	@RequestMapping(value  ="/findlike",method=RequestMethod.GET)
	public String getFindLike(HttpServletRequest request) {
		Map<String ,Object> map = new HashMap<>();
		String policyName = null;
		String enterpriseTypeId = null;
		String enterpriseTradeId = null;
		try {
			policyName = request.getParameter("policyName");
			enterpriseTypeId = request.getParameter("enterpriseTypeId");
			enterpriseTradeId = request.getParameter("enterpriseTradeId");
		} catch (Exception e) {
		}
		map.put("policyName", policyName);
		map.put("enterpriseTypeId", enterpriseTypeId);
		map.put("enterpriseTradeId", enterpriseTradeId);
		PagerModel<TransactionPolicy> list = policyService.findLike(map);
		return JSON.toJSONString(list).toString();
	}
	
	
	@ApiOperation(value = "查看某哥政策的详细信息政策",notes = "查看某哥政策的详细信息政策")
	
	@ApiImplicitParam(name = "policyId", value = "所属领域id",
	required = true, dataType = "int", paramType = "query")
	@RequestMapping(value  ="/findpolicy",method=RequestMethod.GET)
	public String getFind(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			int policyId = Integer.parseInt(request.getParameter("policyId"));
			
			TransactionPolicy policy = policyService.find(policyId);
			map.put("data", policy);
			map.put("code", 200);
		} catch (NumberFormatException e) {
			map.put("msg", "服务器异常");
			map.put("code", 500);
		}
		return JSON.toJSONString(map).toString();
	}
}
