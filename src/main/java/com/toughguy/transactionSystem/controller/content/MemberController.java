package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.service.content.prototype.IMemberBasicInfoService;
import com.toughguy.transactionSystem.service.content.prototype.IMemberCompleteInfoService;
import com.toughguy.transactionSystem.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
	@Autowired
	private IMemberBasicInfoService basicInfo;
	@Autowired
	private IMemberCompleteInfoService completeInfo;
	 
	/**
	 * 登录检查
	 * @param request
	 * @return
	 */
	@RequestMapping("/logincheck")
	public Map<String,String> loginCheck(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		String openId = request.getParameter("openId");
		String memberTel = request.getParameter("memberTel");
		String memberPwd = request.getParameter("memberPwd");
		boolean loginCheck = basicInfo.loginCheck(new TransactionMember(openId,memberTel, memberPwd));
		if(loginCheck) {
			map.put("code", "200");
		}else {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 登录检查
	 * @param request
	 * @return
	 */
	@RequestMapping("/check")
	public Map<String,String> check(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		String openId = request.getParameter("openId");
		boolean check = basicInfo.check(new TransactionMember(openId));
		if(check) {
			map.put("code", "200");
		}else {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatepwd")
	public Map<String,String> updatePwd(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		try {
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			String openId = request.getParameter("openId");
			String memberTel = request.getParameter("memberTel");
			String memberPwd = request.getParameter("memberPwd");
			basicInfo.updatePassword(
					new TransactionMember(memberId,  openId, memberTel, memberPwd));
			map.put("code", "200");
		}catch (Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 解除绑定
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatetel")
	public Map<String,String> updateTel(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		try {
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			String openId = "0";
			String memberTel = request.getParameter("memberTel");
			String memberPwd = request.getParameter("memberPwd");	
			basicInfo.updateUserTel(
					new TransactionMember(memberId, memberTel,memberPwd,openId));
			map.put("code", "200");
		}catch (Exception e) {
			map.put("code", "404");
		}

		return map;
	}
	
	/**
	 * 用户基本信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/registered")
	public Map<String,String> registeredMsg(HttpServletRequest request) {
		
		String memberTel = request.getParameter("memberTel");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String memberCard = request.getParameter("memberCard");
		String openId = request.getParameter("openId");
		String enterpriseName = request.getParameter("enterpriseName");
		String enterpriseCardType = request.getParameter("enterpriseCardType");
		String enterpriseCardId = request.getParameter("enterpriseCardId");
		Map<String,String> map = new HashMap<>();
		try {
			basicInfo.saveBasicInfo(
					new MemberBasicInfo(openId, memberTel, memberPwd, new Date(), memberName, memberCard,
							enterpriseName, enterpriseCardType, enterpriseCardId));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}

		return map;
	}
	
	/**
	 * 完善资料
	 * @param request
	 * @return
	 */
	@RequestMapping("/completemsg")
	public Map<String,String> completeMsg(HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		
		String openId = request.getParameter("openId");
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		int enterpriseTradeId = Integer.parseInt(request.getParameter("enterpriseTradeId"));
		int enterpriseAreaId = Integer.parseInt(request.getParameter("enterpriseAreaId"));
		int enterpriseAddressId = Integer.parseInt(request.getParameter("enterpriseAddressId"));
		String enterpriseTaxpayer = request.getParameter("enterpriseTaxpayer");
		String enterpriseValidityDateStart = request.getParameter("enterpriseValidityDateStart");
		String enterpriseValidityDateEnd = request.getParameter("enterpriseValidityDateEnd");
		String enterpriseCertificationUnit = request.getParameter("enterpriseCertificationUnit");
		String enterpriseRegAddress = request.getParameter("enterpriseRegAddress");
		int enterpriseStatusId = Integer.parseInt(request.getParameter("enterpriseStatusId"));
		String enterpriseRegDate = request.getParameter("enterpriseRegDate");
		Double enterpriseRegMoney = Double.parseDouble(request.getParameter("enterpriseRegMoney"));
		String enterpriseLegalPersonName = request.getParameter("enterpriseLegalPersonName");
		String enterpriseLegalPersonCard = request.getParameter("enterpriseLegalPersonCard");
		int enterpriseAuditStatus = Integer.parseInt(request.getParameter("enterpriseAuditStatus"));
		int enterpriseTypeId = Integer.parseInt(request.getParameter("enterpriseTypeId"));

		try {
			completeInfo.saveCompleteInfo(
					new MemberCompleteInfo(memberId,openId,enterpriseAddressId,enterpriseTradeId, enterpriseAreaId, enterpriseTaxpayer,
							DateUtil.getDate(enterpriseValidityDateStart, "yyyy-MM-dd"), 
							DateUtil.getDate(enterpriseValidityDateEnd, "yyyy-MM-dd"), 
							enterpriseCertificationUnit, enterpriseRegAddress, enterpriseStatusId,
							DateUtil.getDate(enterpriseRegDate, "yyyy-MM-dd"), enterpriseRegMoney, enterpriseLegalPersonName, 
							enterpriseLegalPersonCard, enterpriseAuditStatus, enterpriseTypeId) );
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
			System.out.println("exception");
		}

		return map;
	}
	
	/**
	 * 一个会员的完整信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/memberallinfo")
	public Map<String, Object> oneMemberInfo(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		try {
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			MemberCompleteInfo info = completeInfo.findEnterpriseInfo(
					new MemberCompleteInfo(memberId));
			map.put("data", info);
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 所有的普通会员信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/memberinfo")
	public Map<String, Object> allMemberInfo(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		try {
			List<MemberBasicInfo> info = basicInfo.memberInfo();
			map.put("data", info);
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 所有的企业会员信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/enterpriseinfo")
	public Map<String, Object> allEnterpriseInfo(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		try {
			List<MemberBasicInfo> info = basicInfo.enterpriseInfo();
			map.put("data", info);
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	
}
