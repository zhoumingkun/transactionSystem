package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberBasicInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IMemberBasicInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class MemberBasicInfoServiceImpl 
extends GenericServiceImpl<MemberBasicInfo,Integer>
	implements IMemberBasicInfoService{
	
	@Autowired
	IMemberBasicInfoDao dao;
	

	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return dao.enterpriseInfo();
	}


}
