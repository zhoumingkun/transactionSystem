package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionMemberCompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/MemterCompany")
@Slf4j
public class TransactionMemterCompanyController {
	
	@Autowired
	private ITransactionMemberCompanyService memberCompanyService;
	
	
	@RequestMapping("/a")
	@ResponseBody
	public Map<String, Object> getFindAll() {
		List<TransactionMemberCompany> list = memberCompanyService.findAll();
		Map<String,Object> map = new HashMap<String,Object>();
		for (TransactionMemberCompany transactionMemberCompany : list) {
			map.put("company", transactionMemberCompany);		
		}
		return map;
	}
	
	@RequestMapping("/b")
	@ResponseBody
	public String getFindAll2() {
		/*List<TransactionMemberCompany> list = memberCompanyService.findAll();
		Map<String,Object> map = new HashMap<String,Object>();
		for (TransactionMemberCompany transactionMemberCompany : list) {
			map.put("company", transactionMemberCompany);		
		}*/
		return "b";
	}
	
}