package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseStatus;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAddressService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAreaService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAuditStatusService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseStatusService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTradeService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTypeService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 字典管理模块：
 * 	企业领域	企业状态   企业类型  
 *  审核状态    地址       行业
 * 
 * @author 张泽
 */
@RestController
@RequestMapping("/dictionary")
@Slf4j
public class DictionaryManagementController {
	
	@Autowired
	private ITransactionLogService logService;
	
	@Autowired
	private IEnterpriseAddressService addressService;
	
	@Autowired
	private IEnterpriseAreaService areaService;
	
	@Autowired
	private IEnterpriseAuditStatusService auditStatusService;
	
	@Autowired
	private IEnterpriseStatusService statusService;
	
	@Autowired
	private IEnterpriseTradeService tradeService;
	
	@Autowired
	private IEnterpriseTypeService typeService;
	
	/**
	 * 查找企业领域的所有信息
	 * @return
	 */
	@ApiOperation(value = "企业领域",notes = "查找企业领域的所有信息")
	@RequestMapping(value = "areamsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAreaMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseArea> areaAllMsg = areaService.findAll();
			
			map.put("code", "200");
			map.put("data", areaAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 查找企业领域的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "企业领域",notes = "查找企业领域的所有信息")
	@RequestMapping(value = "/areastatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAreaStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseArea> areaAllMsg = areaService.findStatusAll();
			
			map.put("code", "200");
			map.put("data", areaAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 添加企业领域的信息
	 * @return
	 */
	@ApiOperation(value = "企业领域",notes = "添加企业领域的信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "enterpriseArea", value = "企业领域",
            required = true, dataType = "String", paramType = "query"),
    		@ApiImplicitParam(name = "rootId", value = "管理员id",
            required = true, dataType = "int", paramType = "query")
    })
	
	@RequestMapping(value = "/areamsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAreaMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
//		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String enterpriseArea = request.getParameter("enterpriseArea");		
			areaService.save(new TransactionEnterpriseArea(enterpriseArea));
			
			int rootId =  Integer.parseInt(request.getParameter("rootId"));
			logService.insert("添加企业领域的信息: "+ enterpriseArea +"", rootId);
			
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除企业领域的信息
	 * @return
	 */
	@ApiOperation(value = "企业领域",notes = "删除企业领域的信息")
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "enterpriseAreaId", value = "企业领域ID",
	            required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rootId", value = "管理员id",
	    required = true, dataType = "int", paramType = "query")
	  })
	@RequestMapping(value = "/areamsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAreaMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			
			int rootId =  Integer.parseInt(request.getParameter("rootId"));
			logService.insert("删除企业领域的信息: "+ areaService.find(enterpriseAreaId).getEnterpriseArea() +"", rootId);
			
			areaService.delete(enterpriseAreaId);
			
			
			
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	

	/**
	 * 修改企业领域的信息
	 * @return
	 */
	@ApiOperation(value = "企业领域",notes = "修改企业领域的信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "enterpriseAreaId", value = "企业领域ID",
            required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "status", value = "状态",
            required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "rootId", value = "管理员id",
            required = true, dataType = "int", paramType = "query")
    		
    })
            
	@RequestMapping(value = "/areamsgupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAreaMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			areaService.update(new TransactionEnterpriseArea(enterpriseAreaId, status));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("修改企业领域的信息: "
					+ areaService.find(enterpriseAreaId).getEnterpriseArea() +"的状态"
					, rootId);
		}catch(Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	/**
	 * 查找企业状态的所有信息
	 * @return
	 */
	@ApiOperation(value = "企业状态",notes = "查找企业状态的所有信息")
	@RequestMapping(value = "/statusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseStatus> statusAllMsg = statusService.findAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 查找企业状态的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "企业状态",notes = "查找企业状态的所有信息")
	@RequestMapping(value = "/statusstatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseStatusStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseStatus> statusAllMsg = statusService.findStatusAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	/**
	 * 添加企业状态的信息
	 * @return
	 */
	@ApiOperation(value = "企业状态",notes = "添加企业状态的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "enterpriseStatus", value = "企业状态",
	    required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query")
		
	})
	
	@RequestMapping(value = "/statusmsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseStatusMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String enterpriseStatus = request.getParameter("enterpriseStatus");		
			statusService.save(new TransactionEnterpriseStatus(enterpriseStatus));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("添加企业状态: "
					+ enterpriseStatus
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除企业状态的信息
	 * @return
	 */
	@ApiOperation(value = "企业状态",notes = "删除企业状态的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseStatusId", value = "企业状态ID",
        required = true, dataType = "int", paramType = "query")
		
	})
	@RequestMapping(value = "/statusmsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseStatusMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseStatusId = Integer.parseInt(request.getParameter("enterpriseStatusId"));
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除企业状态: "
					+ statusService.find(enterpriseStatusId).getEnterpriseStatus()
					, rootId);
			
			statusService.delete(enterpriseStatusId);
			map.put("code", "200");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	

	/**
	 * 修改企业状态的信息
	 * @return
	 */
	@ApiOperation(value = "企业状态",notes = "修改企业状态的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseStatusId", value = "企业状态ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态",
        required = true, dataType = "int", paramType = "query")
		
	})
	@RequestMapping(value = "/statusmsgupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseStatusMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseStatusId = Integer.parseInt(request.getParameter("enterpriseStatusId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			statusService.update(new TransactionEnterpriseStatus(enterpriseStatusId, status));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("修改企业状态: "
					+ statusService.find(enterpriseStatusId).getEnterpriseStatus() + " 状态 "
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 查找企业类型的所有信息
	 * @return
	 */
	@ApiOperation(value = "企业类型",notes = "查找企业类型的所有信息")
	@RequestMapping(value = "/typemsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTypeMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseType> typeAllMsg = typeService.findAll();
			map.put("code", "200");
			map.put("data", typeAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 查找企业类型的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "企业类型",notes = "查找企业类型的所有信息")
	@RequestMapping(value = "/typestatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTypeStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseType> typeAllMsg = typeService.findStatusAll();
			map.put("code", "200");
			map.put("data", typeAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 添加企业类型的信息
	 * @return
	 */
	@ApiOperation(value = "企业类型",notes = "添加企业类型的信息")
    
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseType", value = "企业类型",
        required = true, dataType = "String", paramType = "query")
		
	})
	@RequestMapping(value = "/typemsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTypeMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String enterpriseType = request.getParameter("enterpriseType");		
			typeService.save(new TransactionEnterpriseType(enterpriseType));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("添加企业类型: "
					+ enterpriseType
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除企业类型的信息
	 * @return
	 */
	@ApiOperation(value = "企业类型",notes = "删除企业类型的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型ID",
        required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/typemsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTypeMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));

			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除企业类型: "
					+ typeService.find(enterpriseTypeId).getEnterpriseType()
					, rootId);
			
			typeService.delete(enterpriseTypeId);
			map.put("code", "200");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	

	/**
	 * 修改企业类型的信息
	 * @return
	 */
	@ApiOperation(value = "企业类型",notes = "修改企业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态",
        required = true, dataType = "int", paramType = "query")
	})       
	@RequestMapping(value = "/typemsgupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTypeMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			typeService.update(new TransactionEnterpriseType(enterpriseTypeId, status));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("修改企业类型: "
					+ typeService.find(enterpriseTypeId).getEnterpriseType()+" 状态 "
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	/**
	 * 查找审核状态的所有信息
	 * @return
	 */
	@ApiOperation(value = "审核状态",notes = "查找审核状态的所有信息")
	@RequestMapping(value = "/auditmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAuditStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAuditStatus> statusAllMsg = auditStatusService.findAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 查找审核状态的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "审核状态",notes = "查找审核状态的所有信息")
	@RequestMapping(value = "/auditstatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAuditStatusStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAuditStatus> statusAllMsg = auditStatusService.findStatusAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 添加审核状态的信息
	 * @return
	 */
	@ApiOperation(value = "审核状态",notes = "添加审核状态的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "auditStatusType", value = "审核状态",
        required = true, dataType = "String", paramType = "query")
	})       
	@RequestMapping(value = "/auditstatusmsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAuditStatusMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String auditStatusType = request.getParameter("auditStatusType");		
			auditStatusService.save(new TransactionEnterpriseAuditStatus(auditStatusType));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("添加审核状态: "
					+ auditStatusType
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除审核状态的信息
	 * @return
	 */
	@ApiOperation(value = "审核状态",notes = "删除审核状态的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "auditStatusId", value = "审核状态ID",
        required = true, dataType = "int", paramType = "query")
	}) 
	@RequestMapping(value = "/auditstatusmsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAuditStatusMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int auditStatusId = Integer.parseInt(request.getParameter("auditStatusId"));
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除审核状态: "
					+ auditStatusService.find(auditStatusId).getAuditStatusType()
					, rootId);
			
			auditStatusService.delete(auditStatusId);
			map.put("code", "200");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	

	/**
	 * 修改审核状态的信息
	 * @return
	 */
	@ApiOperation(value = "审核状态",notes = "修改审核状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "auditStatusId", value = "审核状态ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态",
        required = true, dataType = "int", paramType = "query")
	})         
	@RequestMapping(value = "/auditstatusmsgupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAuditStatusMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int auditStatusId = Integer.parseInt(request.getParameter("auditStatusId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			auditStatusService.update(new TransactionEnterpriseAuditStatus(auditStatusId, status));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除审核状态: "
					+ auditStatusService.find(auditStatusId).getAuditStatusType() + "状态"
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	
	/**
	 * 查找地址的所有信息
	 * @return
	 */
	@ApiOperation(value = "地址",notes = "查找地址的所有信息")
	@RequestMapping(value = "/addressmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAddressMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAddress> addressAllMsg = addressService.findAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 查找地址的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "地址",notes = "查找地址的所有信息")
	@RequestMapping(value = "/addressstatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAddressStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAddress> addressAllMsg = addressService.findStatusAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 添加地址的信息
	 * @return
	 */
	@ApiOperation(value = "地址",notes = "添加地址的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "addressName", value = "地址",
         required = true, dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/addressmsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAddressMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String addressName = request.getParameter("addressName");		
			addressService.save(new TransactionEnterpriseAddress(addressName));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("添加地址: "
					+ addressName
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除地址的信息
	 * @return
	 */
	@ApiOperation(value = "地址",notes = "删除地址的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "addressId", value = "地址ID",
        required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/addressmsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAddressMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int addressId = Integer.parseInt(request.getParameter("addressId"));

			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除地址: "
					+ addressService.find(addressId).getAddressName()
					, rootId);
			
			addressService.delete(addressId);
			map.put("code", "200");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	

	/**
	 * 修改地址的信息
	 * @return
	 */
	@ApiOperation(value = "地址",notes = "修改地址的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "addressId", value = "地址ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态",
        required = true, dataType = "int", paramType = "query")
	})       
	@RequestMapping(value = "/addressupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseAddressMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			addressService.update(new TransactionEnterpriseAddress(addressId, status));
			map.put("code", "200");
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("修改地址: "
					+ addressService.find(addressId).getAddressName()+"状态"
					, rootId);
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	/**
	 * 查找行业的所有信息(状态为1)
	 * @return
	 */
	@ApiOperation(value = "行业",notes = "查找行业的所有信息")
	@RequestMapping(value = "/tradestatusmsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTradeStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try { 
			List<TransactionEnterpriseTrade> addressAllMsg = tradeService.findStatusAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 查找行业的所有信息
	 * @return
	 */
	@ApiOperation(value = "行业",notes = "查找行业的所有信息")
	@RequestMapping(value = "/trademsg", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTradeMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseTrade> addressAllMsg = tradeService.findAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 添加行业的信息
	 * @return
	 */
	@ApiOperation(value = "行业",notes = "添加行业的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "tradeType", value = "行业",
        required = true, dataType = "String", paramType = "query")
	}) 
	@RequestMapping(value = "/trademsgadd", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTradeMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String tradeType = request.getParameter("tradeType");		
			tradeService.save(new TransactionEnterpriseTrade(tradeType));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("添加行业: "
					+ tradeType
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 删除行业的信息
	 * @return
	 */
	@ApiOperation(value = "行业",notes = "删除行业的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
	    @ApiImplicitParam(name = "tradeId", value = "行业ID",
        required = true, dataType = "int", paramType = "query")
	}) 
	@RequestMapping(value = "/trademsgdel", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTradeMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int tradeId = Integer.parseInt(request.getParameter("tradeId"));

			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除行业: "
					+ tradeService.find(tradeId).getTradeType()
					, rootId);
			
			tradeService.delete(tradeId);
			map.put("code", "200");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}

	/**
	 * 修改行业的信息
	 * @return
	 */
	@ApiOperation(value = "行业",notes = "修改行业的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "tradeId", value = "行业ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态",
        required = true, dataType = "int", paramType = "query")
	})         
	@RequestMapping(value = "/tradeupdate", method = RequestMethod.GET)
	public Map<String,Object> enterpriseTradeMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		
		try {
			int tradeId = Integer.parseInt(request.getParameter("tradeId"));
			boolean status = Integer.parseInt(request.getParameter("status"))>0;
			tradeService.update(new TransactionEnterpriseTrade(tradeId, status));
			map.put("code", "200");
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("修改行业: "
					+ tradeService.find(tradeId).getTradeType() + "状态"
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	
	
}
