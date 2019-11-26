package com.toughguy.transactionSystem.controller.content;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionPolicyService;
import com.toughguy.transactionSystem.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
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
	@ApiImplicitParam(name = "policyId", value = "id",
        required = true, dataType = "int", paramType = "query")
	@RequestMapping("/aaaaa")
	public String getIntelligence(HttpServletRequest request) {
		int policyId = Integer.parseInt(request.getParameter("policyId"));		
		// - 查询用户信息
		TransactionEnterprise m = enterpriseService.find(policyId);
		// - 查找出所有的政策信息
		PagerModel<TransactionPolicy> findPaginated = policyService.findPaginated(null);
		List<TransactionPolicy> lists = findPaginated.getData();
		// - 遍历所有的政策信息，11对比
		for (int i = 0; i <lists.size(); i++) {
			// - 定义所占百分比
			int num = 0;
			if(m.getEnterpriseAddressId()==lists.get(i).getEnterpriseAddressId()) {
				// -如果所属地区一样，加20百分比
				num += 20; 
			}
			if(m.getEnterpriseTypeId() == lists.get(i).getEnterpriseTypeId()) {
				// -如果企业类型一样，加25百分比
				num += 25;
			}
			if(m.getEnterpriseAreaId() == lists.get(i).getEnterpriseAreaId()) {
				// -如果所属领域一样，加25百分比
				num += 25;
			}
			if(m.getEnterpriseTradeId() == lists.get(i).getEnterpriseTradeId()) {
				// -如果行业一样，加30百分比
				num += 30;
			}
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
        required = true, dataType = "double", paramType = "query")
	}) 
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String getUpdate(HttpServletRequest request) {

		try {
			int policyId = Integer.parseInt(request.getParameter("policyId"));
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			int enterpriseTradeId = Integer.parseInt(request.getParameter("enterpriseTradeId"));
			String policyName = request.getParameter("policyName");
			String policyUnit = request.getParameter("policyUnit");
			String policyContent = request.getParameter("policyContent");
			String policyTime = request.getParameter("policyTime");
			int enterpriseAddressId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));
			String policMoney = request.getParameter("policMoney");
			TransactionPolicy policy  = new TransactionPolicy(
					policyId,enterpriseAreaId,enterpriseTradeId,
					policyName,policyUnit,policyContent,DateUtil.getDate(policyTime),
					enterpriseAddressId,enterpriseTypeId,Double.parseDouble(policMoney)
					);
			policyService.update(policy);
		
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
        required = true, dataType = "double", paramType = "query")
	}) 
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String getAdd(HttpServletRequest request) {
		/*try {*/
		
		
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			int enterpriseTradeId = Integer.parseInt(request.getParameter("enterpriseTradeId"));
			int enterpriseAddressId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));
			String policMoney = request.getParameter("policMoney");
			String policyName = request.getParameter("policyName");
			String policyUnit = request.getParameter("policyUnit");
			String policyContent = request.getParameter("policyContent");
			String policyTime = request.getParameter("policyTime");
			TransactionPolicy policy  = new TransactionPolicy(
					enterpriseAreaId,enterpriseTradeId,
					policyName,policyUnit,policyContent,DateUtil.getDate(policyTime),
					enterpriseAddressId,enterpriseTypeId,Double.parseDouble(policMoney)
					);
			policyService.save(policy);
			
			return "{msg:succer,code:200}";
	/*	} catch (Exception e) {
			return "{msg:服务器错误,code:500}";
		}*/
	}
	
	
	/**
	 * 	删除政策
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "删除政策",notes = "删除政策")

	@ApiImplicitParam(name = "policyId", value = "所属领域id",
			required = true, dataType = "String", paramType = "query")
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String getDelete(HttpServletRequest request) {
		try {
	
			policyService.delete(Integer.parseInt(request.getParameter("policyId")));
			return "{msg:succer,code:200}";
		} catch (Exception e) {
			return "{msg:服务器错误,code:500}";
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
				required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "行业类型id",
		required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页数",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
		required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/selectOrId",method = RequestMethod.GET)
	public String getListOrId(HttpServletRequest request) {
		PagerModel<TransactionPolicy> pa;
		try {
			Map<String,Object> params = new HashMap<>();
			try {
				int enterpriseAddressId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
				int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
				System.out.println(enterpriseAddressId);
				System.out.println(enterpriseTypeId);
				params.put("enterpriseAddressId", enterpriseAddressId);
				params.put("enterpriseTypeId", enterpriseTypeId);
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
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "条数",
		required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value  ="/like",method=RequestMethod.GET)
	public String getSelectLike(HttpServletRequest request) {
		Map<String ,Object> map = new HashMap<>();
		String policyName = request.getParameter("policyName");
		map.put("policyName", policyName);
		PagerModel<TransactionPolicy> list = policyService.selectLike(map);
		return JSON.toJSONString(list).toString();
	}
}
