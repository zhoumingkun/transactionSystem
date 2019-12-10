package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingTeaser;
import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingTeaserService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
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
@RequestMapping("/financingTeaser")
@Slf4j
@Api(tags = "FinancingController")
public class TransactionFinancingTeaserController {
	@Autowired
	private ITransactionFinancingTeaserService transactionFinancingTeaserService; 

	
	
	/**
	 * 所有的融资人员信息新增
	 * @param request
	 * @return
	 */
	@ResponseBody	
	@RequestMapping(value = "/save")
//	@RequiresPermissions("activity:save")
	public String saveTransactionFinancingTeaser(TransactionFinancingTeaser transactionFinancingTeaser) {
		try {
			transactionFinancingTeaserService.save(transactionFinancingTeaser);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false, \"msg\" : \"操作失败\" }";
		}
	}
	
	/**
	 * 所有的融资人员信息[分页]
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findPaginated", method = RequestMethod.GET)
	public Map<String, Object> findPaginated(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();

		try {
			//List<MemberBasicInfo> info = memberService.enterpriseInfo();
			
			PagerModel<TransactionFinancingTeaser> findPaginated = transactionFinancingTeaserService.findPaginated(null);
			map.put("data", findPaginated.getData());
			map.put("total", findPaginated.getTotal());
			map.put("code", "200");
			map.put("msg", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "404");
			map.put("msg", "服务器异常");
		}
		return map;
	}
}
