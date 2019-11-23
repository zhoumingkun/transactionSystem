package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
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
	public void saveBasicInfo(MemberBasicInfo info) {
		// TODO Auto-generated method stub
		dao.saveBasicInfo(info);
	}

	@Override
	public boolean loginCheck(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.loginCheck(info);
	}
	
	@Override
	public boolean check(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.checkOpenId(info);
	}
	
	@Override
	public void updatePassword(TransactionMember info) {
		// TODO Auto-generated method stub
		dao.updatePassword(info);
	}

	@Override
	public void updateUserTel(TransactionMember info) {
		// TODO Auto-generated method stub
		dao.updateUserTel(info);
	}

	@Override
	public List<MemberBasicInfo> memberInfo() {
		// TODO Auto-generated method stub
		return dao.memberInfo();
	}

	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return dao.enterpriseInfo();
	}

}
