package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dictionary")
@Slf4j
public class DictionaryManagementController {
	
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
	 * 查找企业区域的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/areamsg")
	public Map<String,Object> enterpriseAreaMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseArea> areaAllMsg = areaService.findAll();
			map.put("code", "200");
			map.put("data", areaAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加企业区域的信息
	 * @return
	 */
	@RequestMapping("/enterprise/areaMsgAdd")
	public Map<String,Object> enterpriseAreaMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String enterpriseArea = request.getParameter("enterpriseArea");		
			areaService.save(new TransactionEnterpriseArea(enterpriseArea));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除企业区域的信息
	 * @return
	 */
	@RequestMapping("/enterprise/areaMsgDel")
	public Map<String,Object> enterpriseAreaMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			areaService.delete(enterpriseAreaId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改企业区域的信息
	 * @return
	 */
	@RequestMapping("/enterprise/areaMsgUpdate")
	public Map<String,Object> enterpriseAreaMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
			String enterpriseArea = request.getParameter("enterpriseArea");
			areaService.update(new TransactionEnterpriseArea(enterpriseAreaId, enterpriseArea));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	
	/**
	 * 查找企业状态的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/statusmsg")
	public Map<String,Object> enterpriseStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseStatus> statusAllMsg = statusService.findAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加企业状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/statusMsgAdd")
	public Map<String,Object> enterpriseStatusMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String enterpriseStatus = request.getParameter("enterpriseStatus");		
			statusService.save(new TransactionEnterpriseStatus(enterpriseStatus));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除企业状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/statusMsgDel")
	public Map<String,Object> enterpriseStatusMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseStatusId = Integer.parseInt(request.getParameter("enterpriseStatusId"));
			statusService.delete(enterpriseStatusId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改企业状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/statusMsgUpdate")
	public Map<String,Object> enterpriseStatusMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseStatusId = Integer.parseInt(request.getParameter("enterpriseStatusId"));
			String enterpriseStatus = request.getParameter("enterpriseStatus");
			statusService.update(new TransactionEnterpriseStatus(enterpriseStatusId, enterpriseStatus));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 查找企业类型的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/typemsg")
	public Map<String,Object> enterpriseTypeMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseType> typeAllMsg = typeService.findAll();
			map.put("code", "200");
			map.put("data", typeAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加企业类型的信息
	 * @return
	 */
	@RequestMapping("/enterprise/typeMsgAdd")
	public Map<String,Object> enterpriseTypeMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String enterpriseType = request.getParameter("enterpriseType");		
			typeService.save(new TransactionEnterpriseType(enterpriseType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除企业类型的信息
	 * @return
	 */
	@RequestMapping("/enterprise/typeMsgDel")
	public Map<String,Object> enterpriseTypeMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));
			typeService.delete(enterpriseTypeId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改企业类型的信息
	 * @return
	 */
	@RequestMapping("/enterprise/typeMsgUpdate")
	public Map<String,Object> enterpriseTypeMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));
			String enterpriseType = request.getParameter("enterpriseType");
			typeService.update(new TransactionEnterpriseType(enterpriseTypeId, enterpriseType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	
	/**
	 * 查找审核状态的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/auditstatusmsg")
	public Map<String,Object> enterpriseAuditStatusMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAuditStatus> statusAllMsg = auditStatusService.findAll();
			map.put("code", "200");
			map.put("data", statusAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加审核状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/auditStatusMsgAdd")
	public Map<String,Object> enterpriseAuditStatusMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String auditStatusType = request.getParameter("auditStatusType");		
			auditStatusService.save(new TransactionEnterpriseAuditStatus(auditStatusType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除审核状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/auditStatusMsgDel")
	public Map<String,Object> enterpriseAuditStatusMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int auditStatusId = Integer.parseInt(request.getParameter("auditStatusId"));
			auditStatusService.delete(auditStatusId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改审核状态的信息
	 * @return
	 */
	@RequestMapping("/enterprise/auditStatusMsgUpdate")
	public Map<String,Object> enterpriseAuditStatusMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int auditStatusId = Integer.parseInt(request.getParameter("auditStatusId"));
			String auditStatusType = request.getParameter("auditStatusType");
			auditStatusService.update(new TransactionEnterpriseAuditStatus(auditStatusId, auditStatusType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	
	
	/**
	 * 查找地址的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/addressmsg")
	public Map<String,Object> enterpriseAddressMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseAddress> addressAllMsg = addressService.findAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/addressMsgAdd")
	public Map<String,Object> enterpriseAddressMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String addressName = request.getParameter("addressName");		
			addressService.save(new TransactionEnterpriseAddress(addressName));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/addressMsgDel")
	public Map<String,Object> enterpriseAddressMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			addressService.delete(addressId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/addressUpdate")
	public Map<String,Object> enterpriseAddressMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			String addressName = request.getParameter("addressName");
			addressService.update(new TransactionEnterpriseAddress(addressId, addressName));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	
	/**
	 * 查找行业的所有信息
	 * @return
	 */
	@RequestMapping("/enterprise/trademsg")
	public Map<String,Object> enterpriseTradeMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionEnterpriseTrade> addressAllMsg = tradeService.findAll();
			map.put("code", "200");
			map.put("data", addressAllMsg);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/tradeMsgAdd")
	public Map<String,Object> enterpriseTradeMsgAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String tradeType = request.getParameter("tradeType");		
			tradeService.save(new TransactionEnterpriseTrade(tradeType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	/**
	 * 删除地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/tradeMsgDel")
	public Map<String,Object> enterpriseTradeMsgDel(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int tradeId = Integer.parseInt(request.getParameter("tradeId"));
			tradeService.delete(tradeId);
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	

	/**
	 * 修改地址的信息
	 * @return
	 */
	@RequestMapping("/enterprise/tradeUpdate")
	public Map<String,Object> enterpriseTradeMsgUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		
		try {
			int tradeId = Integer.parseInt(request.getParameter("tradeId"));
			String tradeType = request.getParameter("tradeType");
			tradeService.update(new TransactionEnterpriseTrade(tradeId, tradeType));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
	
	
}
