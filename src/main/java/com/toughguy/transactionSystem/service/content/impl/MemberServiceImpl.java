package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralTwoString;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberDao;
import com.toughguy.transactionSystem.service.content.prototype.IMemberService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class MemberServiceImpl 
extends GenericServiceImpl<TransactionMember, Integer>
implements IMemberService{
	
	@Autowired
	private IMemberDao dao;
	
	@Override
	public boolean check(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.check(info);
	}

	@Override
	public boolean loginCheck(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.loginCheck(info);
	}

	@Override
	public void updatePassword(SqlGeneralTwoString info) {
		// TODO Auto-generated method stub
		dao.updatePassword(info);
	}

	@Override
	public void updateUserTel(TransactionMember info) {
		// TODO Auto-generated method stub
		dao.updateUserTel(info);
	}

	@Override
	public TransactionMember saveBasicInfo(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.saveBasicInfo(info);
	}

	@Override
	public TransactionMember findOnlineTimes(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.findOnlineTimes(info);
	}

	@Override
	public void updateOnlineTimes(TransactionMember info) {
		// TODO Auto-generated method stub
		dao.updateOnlineTimes(info);
	}

	@Override
	public TransactionMember findIntegral(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.findIntegral(info);
	}

	@Override
	public void updateIntegral(TransactionMember info) {
		// TODO Auto-generated method stub
		dao.updateIntegral(info);
	}

	@Override
	public boolean findTel(SqlGeneralInfo info) {
		// TODO Auto-generated method stub
		return dao.findTel(info);
	}

	@Override
	public List<TransactionMember> memberInfo() {
		// TODO Auto-generated method stub
		return dao.memberInfo();
	}

	@Override
	public TransactionMember openIdFindUser(TransactionMember info) {
		// TODO Auto-generated method stub
		return dao.openIdFindUser(info);
	}

	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return dao.enterpriseInfo();
	}
	
	
	@Override
	public List<MemberBasicInfo> findKeyword(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return dao.findKeyword(sqlGeneralInfo);
	}

	@Override
	public boolean isOnline(TransactionMember transactionMember) {
		// TODO Auto-generated method stub
		TransactionMember info = dao.findTodayOnline(transactionMember);
		return info == null;
	}

	@Override
	public PagerModel<MemberBasicInfo> enterpriseInfoPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.enterpriseInfoPage(params);
	}

	
}
