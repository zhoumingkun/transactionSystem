package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.vo.MemberCompanyInfo;
import com.toughguy.transactionSystem.service.content.prototype.IMemberCompanyInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/membercompanyinfo")
@Slf4j
public class MemberCompanyInfoController {
	@Autowired
	private IMemberCompanyInfoService memberCompanyInfoService;
	
	@RequestMapping("/registered")
	public Map<String,String> viewMsg(HttpServletRequest request) {
		
		String memberTel = request.getParameter("memberTel");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String memberCard = request.getParameter("memberCard");
		String companyName = request.getParameter("companyName");
		String companyCardType = request.getParameter("companyCardType");
		String companyCardId = request.getParameter("companyCardId");
		Map<String,String> map = new HashMap<>();
		try {
			memberCompanyInfoService.add(
					new MemberCompanyInfo(memberTel, memberPwd, new Date(), memberName, memberCard, companyName, companyCardType, companyCardId));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}

		return map;
	}
}
