package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toughguy.transactionSystem.model.content.vo.MemberCompanyInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberCompanyInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IMemberCompanyInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class MemberCompanyInfoServiceImpl
	extends GenericServiceImpl<MemberCompanyInfo,Integer> implements IMemberCompanyInfoService{
	
	@Autowired
	private IMemberCompanyInfoDao dao;
	
	@Override
	@Transactional
	public void add(MemberCompanyInfo memberCompanyInfo) {
		dao.saveInfo(memberCompanyInfo);
	}

}
