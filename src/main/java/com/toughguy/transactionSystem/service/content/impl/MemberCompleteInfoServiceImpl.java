package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberCompleteInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IMemberCompleteInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class MemberCompleteInfoServiceImpl 
extends GenericServiceImpl<MemberCompleteInfo,Integer>
	implements IMemberCompleteInfoService{
	
	@Autowired
	IMemberCompleteInfoDao dao;
	
	@Override
	public void saveCompleteInfo(MemberCompleteInfo info) {
		// TODO Auto-generated method stub
		dao.saveCompleteInfo(info);
	}

	@Override
	public MemberCompleteInfo findEnterpriseInfo(MemberCompleteInfo info) {
		// TODO Auto-generated method stub
		return dao.findEnterpriseInfo(info);
	}

}
