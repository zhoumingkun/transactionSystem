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
import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralTwoString;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseService;
import com.toughguy.transactionSystem.service.content.prototype.IMemberService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.MD5Util;
import com.toughguy.transactionSystem.util.SendTelUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IEnterpriseService enterpriseService;
	
	
	/**
	 * 获取OpenId
	 */
	@ApiOperation(value = "获取OpenId",notes = "获取OpenId")
	@RequestMapping(value = "/getopenid", method = RequestMethod.POST)
	public Map<String,Object> sendOpenId(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		try {
			// 获取openId
			String openId = "000011112" ;//+ ((Math.random()*9+1)*1000);
			
			map.put("data", openId);
			map.put("code", "200");
			map.put("msg", "发送成功");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	/**
	 * 发送手机验证码
	 */
	
	@ApiOperation(value = "发送手机验证码",notes = "发送手机验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberTel", value = "用户的手机号",
        required = true, dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/sendcodetwo", method = RequestMethod.GET)
	public Map<String,Object> sendCodeTwo(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		try {
			String tel = request.getParameter("memberTel");
			// 手机是否已经注册
			boolean findTel = memberService.findTel(new SqlGeneralInfo(tel));
			if(findTel) {	//未注册
				map.put("msg", "手机号未存在");
				map.put("code", "404");
				return map;
			}else {		//已注册
				int sendCode = SendTelUtil.sendTel(tel);
//				int sendCode =2000;
				map.put("data", sendCode);
				map.put("code", "200");
				map.put("msg", "发送成功");
				return map;
			}
		}catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	
	/**
	 * 发送手机验证码
	 * 注册
	 */
	
	@ApiOperation(value = "发送手机验证码",notes = "发送手机验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberTel", value = "用户的手机号",
        required = true, dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/sendcode", method = RequestMethod.GET)
	public Map<String,Object> sendCode(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		try {
			String tel = request.getParameter("memberTel");
			// 手机是否已经注册
			boolean findTel = memberService.findTel(new SqlGeneralInfo(tel));
			if(findTel) {	//未注册
				int sendCode = SendTelUtil.sendTel(tel);
//				int sendCode =2000;
				map.put("data", sendCode);
				map.put("code", "200");
				map.put("msg", "发送成功");
				return map;
				
			}else {		//已注册
				map.put("msg", "手机号已存在");
				map.put("code", "404");
				return map;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	/**
	 * 根据openId登录检查
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ApiOperation(value = "登录检查",notes = "根据openId登录检查")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "openId", value = "用户的标识ID",
        required = true, dataType = "String", paramType = "query")
	})
	public Map<String,String> check(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String openId = json.getString("openId");
			boolean check = memberService.check(new TransactionMember(openId));
			if(check) {
				map.put("code", "404");
				map.put("msg", "用户未注册");
				
			}else {
				map.put("code", "200");
				map.put("msg", "用户已注册");
			}
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	/**
	 * 登录检查
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	@ApiOperation(value = "登录检查",notes = "登录检查")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "openId", value = "用户的唯一标识ID",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberTel", value = "手机号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberPwd", value = "密码",
        required = true, dataType = "String", paramType = "query"),
	})
	public Map<String,String> loginCheck(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		
		try{
			String openId = json.getString("openId");
		//解除绑定后openId为0; 
		//判断是不是该用户是不是解绑后的用户 openId==0
		//如果手机号和密码正确，设置该用户的openId为当前的。
			String memberTel = json.getString("memberTel");
			String memberPwd = json.getString("memberPwd");
			//MD5加密
			String memberPassword = MD5Util.MD5Encode(memberPwd, "UTF-8");
			
			// 判定当前openId是否存在
			boolean check = memberService.check(new TransactionMember(openId));
			
			if(check) {		// openId不存在
				
				//检测手机号和密码
				boolean checkTelPwd = memberService.checkTelPwd(new SqlGeneralTwoString(memberTel, memberPassword));
				if(checkTelPwd) { // 手机号和密码不正确
					map.put("code", "404");
					map.put("msg", "手机号或密码错误");
					return map;
				
				}else {	// 手机号和密码正确
					
					//判断是否为解绑用户
					boolean checkOpenIdZero = memberService.checkOpenIdZero(new SqlGeneralTwoString(memberTel, memberPassword));
					if(checkOpenIdZero) {	//不是解绑用户
						map.put("code", "404");
						map.put("msg", "登录失败");
						return map;
					}else {  	//是解绑用户  将用户当前的openId 存到数据库
						memberService.setOpenId(new TransactionMember(openId,memberTel, memberPassword) );
						map.put("code", "200");
						map.put("msg", "登录成功");
						return map;
					}
					
				}
			}else {		// openId存在
				boolean loginCheck = memberService.loginCheck(new TransactionMember(openId,memberTel, memberPassword));
				if(loginCheck) {	// 不存在
					map.put("code", "404");
					map.put("msg", "手机号或密码错误");
					return map;
				}else {	// 存在
					map.put("code", "200");
					map.put("msg", "登录成功");
					return map;
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	
	/**
	 * 修改密码（检查openId是否存在）
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	@ApiOperation(value = "修改密码",notes = "修改密码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "openId", value = "用户唯一标识",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberPwd", value = "密码",
        required = true, dataType = "String", paramType = "query")
		})
	public Map<String,String> updatePwd(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String openId = json.getString("openId");
			String memberPwd = json.getString("memberPwd");
			//MD5加密
			String memberPassword = MD5Util.MD5Encode(memberPwd, "UTF-8");
			
			memberService.updatePassword(
					new SqlGeneralTwoString(openId,memberPassword));
			map.put("code", "200");
			map.put("msg", "成功");
		}catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}

	/**
	 * 解除绑定第一步：判定用户手机号和密码
	 * @param request
	 * @return
	 */
	
	@ApiOperation(value = "解除绑定第一步",notes = "解除绑定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberTel", value = "手机号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberPwd", value = "旧的密码",
        required = true, dataType = "String", paramType = "query")
		})
	@RequestMapping(value = "/checkpwd", method = RequestMethod.POST)
	public Map<String,String> checkPwd(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		
		try {
			int memberId = json.getInteger("memberId");
			String memberTel = json.getString("memberTel");
			String memberPwd = json.getString("memberPwd");
			String memberPassword = MD5Util.MD5Encode(memberPwd, "UTF-8");
			
			boolean check = memberService.checkPwd(
					new TransactionMember(memberId, memberTel, memberPassword));
			if(check) {		//手机号和密码错误
				map.put("code", "404");
				map.put("msg", "手机号或密码错误");
				return map;
			}else{			//手机号和密码正确
				map.put("code", "200");
				map.put("msg", "成功");
				return map;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}

		return map;
	}
	
	
	/**
	 * 解除绑定第二部：设置新的手机号和密码 [ openid改为0] 更换手机号 密码
	 * @param request
	 * @return
	 */
	
	@ApiOperation(value = " 解除绑定第二部：设置新的手机号和密码",notes = "解除绑定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberTel", value = "手机号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberPwd", value = "新的密码",
        required = true, dataType = "String", paramType = "query")
		})
	@RequestMapping(value = "/updatetel", method = RequestMethod.POST)
	public Map<String,String> updateTel(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		
		try {
			int memberId = json.getInteger("memberId");
			String memberTel = json.getString("memberTel");
			String memberPwd = json.getString("memberPwd");
			
			String memberPassword = MD5Util.MD5Encode(memberPwd, "UTF-8");
			memberService.updateUserTel(
					new TransactionMember(memberId, memberTel, memberPassword));
			
			map.put("code", "200");
			map.put("msg", "成功");
		}catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}

		return map;
	}
	
	/**
	 * 注册用户基本信息 
	 * @param request
	 * @return
	 */
	
	@ApiOperation(value = "注册用户",notes = "注册用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "openId", value = "唯一ID",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberTel", value = "手机号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberPwd", value = "密码",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberName", value = "姓名",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "memberCard", value = "身份证号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseCardType", value = "企业证件类型",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseCardId", value = "证件号",
        required = true, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public Map<String,String> registeredMsg(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		Map<String,String> map = new HashMap<>();
		
		String enterpriseCardId = null;
		try {
			enterpriseCardId = json.getString("enterpriseCardId");
		}catch (Exception e) {
System.out.println("可以为空");
		}
		
		try {
			String openId = json.getString("openId");
			String memberTel = json.getString("memberTel");
			String memberPwd = json.getString("memberPwd");
			String memberName = json.getString("memberName");
			String memberCard = json.getString("memberCard");
			String enterpriseName = json.getString("enterpriseName");
			String enterpriseCardType = json.getString("enterpriseCardType");
			
			//判断openId是否注册  ==Null
			boolean isUniqueOpenId = memberService.check(new TransactionMember(openId));
			if(!isUniqueOpenId) {
				map.put("msg", "已经注册过了");
				map.put("code", "404");
			}
			
			//判断手机号是否唯一  ==Null
			boolean findTel = memberService.findTel(new SqlGeneralInfo(memberTel));
			if(!findTel) {
				map.put("code", "404");
				map.put("msg", "手机号已存在");
				return map;
			}
			//判断企业名是否唯一  ==Null
			boolean findName = enterpriseService.findEnterpriseName(new TransactionEnterprise(enterpriseName));
			if(!findName) {
				map.put("code", "404");
				map.put("msg", "企业名已存在");
				return map;
			}
			//判断企业证件号是否唯一  ==Null
			if(!enterpriseCardId.equals("")) { 
				boolean isUnique = enterpriseService.isUniqueEnterCard(new SqlGeneralInfo(enterpriseCardId));
				if(!isUnique) {
					map.put("msg", "企业证件号已经存在了");
					map.put("code", "404");
					return map;
				}
			}
			
			//MD5加密
			String memberPassword = MD5Util.MD5Encode(memberPwd, "UTF-8");
			
			// 向会员表存取数据
			TransactionMember memberInfo = memberService.saveBasicInfo(
					new TransactionMember(openId, memberTel, memberPassword, new Date(), memberName, memberCard));
			int memberId = memberInfo.getMemberId();
			
			// 向企业表存取数据
			if(enterpriseCardId.equals("")) { 
				enterpriseService.insertMsgNoCard(
						new TransactionEnterprise(memberId,enterpriseName, enterpriseCardType));
			}else{
				enterpriseService.insertMsg(
						new TransactionEnterprise(memberId,enterpriseName, enterpriseCardType, enterpriseCardId));
			}
				
			map.put("code", "200");	
			map.put("msg", "注册成功");
		
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}

		return map;
	}
	
	/**
	 * 用户登陆后的返回信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "用户界面",notes = "用户界面")
	@RequestMapping(value = "/memberviewmsg", method = RequestMethod.POST)
	public Map<String,Object> memberViewMsg(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		Map<String,Object> map = new HashMap<>();
		
		try {
			String openId = json.getString("openId");
			
			TransactionMember member = memberService.openIdFindUser(new TransactionMember(openId));
			map.put("code", "200");
			map.put("msg", "成功");
			map.put("data", member);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", "404");
			map.put("msg", "用户错误");
		}
		
		return map;
	}
	
	/**
	 * 添加完善信息之前返回的信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "添加完善信息之前返回的信息",notes = "添加完善信息之前返回的信息")
	@RequestMapping(value = "/completemsgreturn", method = RequestMethod.POST)
	public Map<String,Object> completeMsgReturn(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		Map<String,Object> map = new HashMap<>();
		
		try {
			int memberId = json.getInteger("memberId");
			
			TransactionMember memberMsg = memberService.find(memberId);
			TransactionEnterprise enterpriseMsg = enterpriseService.find(memberId);
			
			Map<String,Object> data = new HashMap<>();
			data.put("memberName", memberMsg.getMemberName());
			data.put("memberCard", memberMsg.getMemberCard());
			data.put("memberTel", memberMsg.getMemberTel());
			
			if(enterpriseMsg.getEnterpriseName()==null) {
				data.put("enterpriseName", "");
			}else {
				data.put("enterpriseName",enterpriseMsg.getEnterpriseName());
			}
			map.put("code", "200");
			map.put("msg", "成功");
			map.put("data", data);
		}catch (Exception e) {
			map.put("code", "404");
			map.put("msg", "用户错误");
		}
		return map;
	}
	/**
	 * 完善资料
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/completemsg", method = RequestMethod.POST)
	@ApiOperation(value = "完善资料",notes = "完善资料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "用户ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseName", value = "企业名",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseCardType", value = "企业证件类型",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseCardId", value = "企业证件号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTradeId", value = "行业id",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAreaId", value = "企业领域ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseAddressId", value = "企业所在区域ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTaxpayer", value = "纳税人识别号",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseValidityDateStart", value = "证件有效开始时间",
        required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseValidityDateEnd", value = "证件有效结束时间",
        required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseCertificationUnit", value = "发证单位",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseRegAddress", value = "注册地址",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseStatusId", value = "企业状态ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseRegDate", value = "企业注册日期",
        required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseRegMoney", value = "企业注册资本",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseLegalPersonName", value = "企业法人",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseLegalPersonCard", value = "企业法人ID",
        required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型ID",
        required = true, dataType = "int", paramType = "query")
	})
	public Map<String,String> completeMsg(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			String enterpriseName = json.getString("enterpriseName");
			String enterpriseCardType = json.getString("enterpriseCardType");
			String enterpriseCardId = json.getString("enterpriseCardId");
			int enterpriseTradeId = json.getInteger("enterpriseTradeId");
			int enterpriseAreaId = json.getInteger("enterpriseTradeId");
			int enterpriseAddressId = json.getInteger("enterpriseTradeId");
			String enterpriseTaxpayer = json.getString("enterpriseTaxpayer");
			Date enterpriseValidityDateStart = DateUtil.getDate(
					json.getString("enterpriseValidityDateStart"), "yyyy-MM-dd");
			Date enterpriseValidityDateEnd = DateUtil.getDate(json.getString("enterpriseValidityDateEnd"),"yyyy-MM-dd");
			String enterpriseCertificationUnit = json.getString("enterpriseCertificationUnit");
			String enterpriseRegAddress = json.getString("enterpriseRegAddress");
			int enterpriseStatusId = json.getInteger("enterpriseStatusId");
			Date enterpriseRegDate = DateUtil.getDate(json.getString("enterpriseRegDate"),"yyyy-MM-dd");
			Double enterpriseRegMoney = json.getDouble("enterpriseRegMoney");
			String enterpriseLegalPersonName = json.getString("enterpriseLegalPersonName");
			String enterpriseLegalPersonCard = json.getString("enterpriseLegalPersonCard");
			int enterpriseTypeId = json.getInteger("enterpriseTypeId");
			
			// 判断企业名唯一  是否为Null
			boolean findName = enterpriseService.findEnterpriseName(new TransactionEnterprise(enterpriseName));
			if(!findName) {
				map.put("code", "404");
				map.put("msg", "企业名已存在");
				return map;
			}
			
			enterpriseService.saveCompleteInfo(
					new TransactionEnterprise(
							memberId, enterpriseName,
							enterpriseCardType, enterpriseCardId,
							enterpriseTypeId, enterpriseTradeId,
							enterpriseAreaId, enterpriseAddressId,
							enterpriseTaxpayer, enterpriseValidityDateStart,
							enterpriseValidityDateEnd, 
							enterpriseCertificationUnit, 
							enterpriseRegAddress, enterpriseStatusId,
							enterpriseRegDate, enterpriseRegMoney, 
							enterpriseLegalPersonName, enterpriseLegalPersonCard)
					
					);
			map.put("code", "200");
			map.put("msg", "成功");
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}

		return map;
	}
	
	
	/**
	 * 一名企业会员的完整信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oneenterprisememberinfo", method = RequestMethod.GET)
	@ApiOperation(value = "完整信息",notes = "完整信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "int", paramType = "query"),
		})
	public Map<String, Object> oneEnterpriseMemberInfo(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
//		JSONObject json = requestJSONUtil.request(request, response);
		
		try {
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			
			MemberCompleteInfo info = enterpriseService.findEnterpriseInfo(
					new TransactionEnterprise(memberId));
			
			map.put("data", info);
			map.put("msg", "成功");
			map.put("code", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	/**
	 * 【未用】
	 * 所有的普通会员信息[分页]
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = "/allmemberinfo", method = RequestMethod.POST)
//	@ApiOperation(value = "普通会员资料",notes = "普通会员资料")
//	public Map<String, Object> allMemberInfo(HttpServletRequest request, HttpServletResponse response){
//		Map<String,Object> map = new HashMap<>();
//		
//		try {
//			List<TransactionMember> info = memberService.memberInfo();
//			map.put("data", info);
//			map.put("code", "200");
//			map.put("msg", "成功");
//		} catch (Exception e) {
//			map.put("code", "500");
//			map.put("msg", "服务器异常");
//		}
//		return map;
//	}
	
	/**
	 * 所有的企业会员信息[分页]
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/enterpriseinfo", method = RequestMethod.GET)
	@ApiOperation(value = "企业会员信息",notes = "企业会员信息")
	public Map<String, Object> allEnterpriseInfo(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();

		try {
			//List<MemberBasicInfo> info = memberService.enterpriseInfo();
			
			PagerModel<MemberBasicInfo> enterpriseInfoPage = memberService.enterpriseInfoPage(null);
			map.put("data", enterpriseInfoPage.getData());
			map.put("total", enterpriseInfoPage.getTotal());
			map.put("code", "200");
			map.put("msg", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "404");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 签到接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/onlinetimes", method = RequestMethod.POST)
	@ApiOperation(value = "签到接口",notes = "签到接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "用户ID",
        required = true, dataType = "int", paramType = "query"),
		})
	public Map<String, Object> onlineTimes(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		
		try {
			int memberId = json.getInteger("memberId");
			//判断该会员是否今天已签到
			boolean isOnline = memberService.isOnline(new TransactionMember(memberId));
			if(!isOnline) {
				map.put("msg", "已经签到了");
				map.put("code", "404");
				return map;
			}
			// 查询会员签到次数
			TransactionMember findOnlineTimes = memberService.findOnlineTimes(new TransactionMember(memberId));
			
			//更新签到次数和日期
			int times = findOnlineTimes.getMemberOnlineTimes();
			findOnlineTimes.setMemberOnlineTimes(times+1);
				
			memberService.updateOnlineTimes(findOnlineTimes);
			
			map.put("msg", "签到成功");
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "404");
			map.put("msg", "签到失败");
		}
		return map;
	} 
	/**
	 * 累加积分接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateIntegral", method = RequestMethod.POST)
	@ApiOperation(value = "累加积分接口",notes = "累加积分接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "int", paramType = "query"),
		})
	public Map<String, Object> updateIntegral(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			
			// 查询积分
			TransactionMember findIntegral = memberService.findIntegral(new TransactionMember(memberId));
			int integral = findIntegral.getMemberIntegral();
			
			// 更新积分
			findIntegral.setMemberIntegral(integral + 1);
			
			memberService.updateIntegral(findIntegral);
			
			map.put("code", "200");
			map.put("msg", "成功");
		} catch (Exception e) {
			map.put("code", "404");
			map.put("msg", "失败");
		}
		return map;
	} 
	
	/**
	 * 手机号验证
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findtel", method = RequestMethod.POST)
	@ApiOperation(value = "手机号验证",notes = "手机号验证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberTel", value = "手机号",
        required = true, dataType = "String", paramType = "query"),
		})
	public Map<String, Object> findTel(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String memberTel = json.getString("memberTel");
			// 判断手机号是否为Null
			boolean findTel = memberService.findTel(new SqlGeneralInfo(memberTel));
			if(findTel) {
				map.put("msg", "成功");
				map.put("code", "200");
			}else {
				map.put("msg", "手机号已存在");
				map.put("code", "404");
			}
			
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	} 
	
	/**
	 * 公司名验证
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findenterprise", method = RequestMethod.POST)
	@ApiOperation(value = "公司名验证",notes = "公司名验证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "enterpriseName", value = "企业名称",
        required = true, dataType = "String", paramType = "query"),
		})
	public Map<String, Object> findEnterprise(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		
		try {
			String enterpriseName = json.getString("enterpriseName");
			//是否为Null
			boolean findName = enterpriseService.findEnterpriseName(new TransactionEnterprise(enterpriseName));
			
			if(findName) {
				map.put("code", "200");
				map.put("msg", "成功");
			}else {
				map.put("code", "404");
				map.put("msg", "已存在");
			}
		} catch (Exception e) {
			map.put("code", "404");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 企业查询关键字接口[分页]
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "查询关键字",notes = "查询关键字")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "keyword", value = "关键字",
        required = true, dataType = "String", paramType = "query"),
		})
	@RequestMapping(value = "/findkeyword", method = RequestMethod.GET)
	public Map<String, Object> findKeyword(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		
		try {
			String keyword = request.getParameter("keyword");
			Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("keyword", keyword);
			PagerModel<MemberBasicInfo> member = memberService.findKeyword(hashMap);
			
			map.put("data", member);
			map.put("msg", "成功");
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	} 
	
	/**
	 * 资料是否完善//根据openId 还是 memberId
	 */
	@ApiOperation(value = "资料是否完善",notes = "资料是否完善")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "int", paramType = "query"),
		})
	@RequestMapping(value = "/iscomplete", method = RequestMethod.POST)
	public Map<String, Object> isComplete(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			boolean isComplete = enterpriseService.isComplete(new TransactionEnterprise(memberId));
			if(isComplete) {
				map.put("msg", "信息不完善");
				map.put("code", "404");
			}else {
				map.put("msg", "信息完善");
				map.put("code", "200");
			}
			
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	} 
	
	/**
	 * 是否可以签到 memberId
	 */
	@ApiOperation(value = "是否可以签到",notes = "是否可以签到")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "int", paramType = "query"),
		})
	@RequestMapping(value = "/isonline", method = RequestMethod.POST)
	public Map<String, Object> isOnline(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			boolean isOnline = memberService.isOnline(new TransactionMember(memberId));
			if(isOnline) {
				map.put("msg", "未签到");
				map.put("code", "200");
			}else {
				map.put("msg", "已经签到了");
				map.put("code", "404");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	/**
	 * openId是否唯一
	 */
	@ApiOperation(value = "openId是否唯一",notes = "openId是否唯一")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "openId", value = "openId",
        required = true, dataType = "String", paramType = "query"),
		})
	@RequestMapping(value = "/isuniqueopenid", method = RequestMethod.POST)
	public Map<String, Object> isUniqueOpenId(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String openId = json.getString("openId");
			boolean isUnique = memberService.check(new TransactionMember(openId));
			if(isUnique) {
				map.put("msg", "不存在");
				map.put("code", "200");
			}else {
				map.put("msg", "已经存在了");
				map.put("code", "404");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
	
	/**
	 * 企业证件号是否唯一
	 */
	@ApiOperation(value = "企业证件号是否唯一",notes = "企业证件号是否唯一")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "enterpriseCardId", value = "企业证件号",
        required = true, dataType = "String", paramType = "query"),
		})
	@RequestMapping(value = "/isuniqueentercard", method = RequestMethod.POST)
	public Map<String, Object> isUniqueEnterCard(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String enterpriseCardId = json.getString("enterpriseCardId");
			boolean isUnique = enterpriseService.isUniqueEnterCard(new SqlGeneralInfo(enterpriseCardId));
			if(isUnique) {
				map.put("msg", "不存在");
				map.put("code", "200");
			}else {
				map.put("msg", "已经存在了");
				map.put("code", "404");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		
		return map;
	}
}
