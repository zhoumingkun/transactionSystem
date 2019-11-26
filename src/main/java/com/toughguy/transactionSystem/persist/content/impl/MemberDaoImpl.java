package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class MemberDaoImpl 
extends GenericDaoImpl<TransactionMember, Integer>
implements IMemberDao{

	@Override
	public boolean check(TransactionMember info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".checkOpenId", info).size()==1;
	}

	@Override
	public boolean loginCheck(TransactionMember info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".loginCheck", info).size()==1;
	}

	@Override
	public void updatePassword(TransactionMember info) {
		// TODO Auto-generated method stub
System.out.println(info);
		sqlSessionTemplate.update(typeNameSpace + ".updatePassword", info);
	}

	@Override
	public void updateUserTel(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateUser", info);
	}

	@Override
	public TransactionMember saveBasicInfo(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".saveBasicInfo1", info);
		//sqlSessionTemplate.insert(typeNameSpace + ".saveBasicInfo2", info);
		return info;
	}

	@Override
	public TransactionMember findOnlineTimes(TransactionMember info) {
		// TODO Auto-generated method stub
		TransactionMember onlineTimesInfo = sqlSessionTemplate.selectOne(typeNameSpace + ".findOnlineTimes", info);
		return onlineTimesInfo;
	}

	@Override
	public void updateOnlineTimes(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateOnlineTimes", info);
	}

	@Override
	public TransactionMember findIntegral(TransactionMember info) {
		// TODO Auto-generated method stub
		TransactionMember integralInfo = sqlSessionTemplate.selectOne(typeNameSpace + ".findIntegral", info);
		return integralInfo;
	}

	@Override
	public void updateIntegral(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateIntegral", info);
	}

	@Override
	public boolean findTel(SqlGeneralInfo info) {
		// TODO Auto-generated method stub
		TransactionMember telInfo = sqlSessionTemplate.selectOne(typeNameSpace + ".findTel", info);
		return telInfo==null;
	}
	
	@Override
	public List<TransactionMember> memberInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".memberInfo");
	}

	@Override
	public TransactionMember openIdFindUser(TransactionMember info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".openIdFindUser", info);
	}

	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".enterpriseInfo");
	}

	@Override
	public List<MemberBasicInfo> findKeyword(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findKeyword", sqlGeneralInfo);
	}

	@Override
	public TransactionMember findTodayOnline(TransactionMember transactionMember) {
		// TODO Auto-generated method stub
		System.out.println(transactionMember);
		TransactionMember selectOne = sqlSessionTemplate.selectOne(typeNameSpace + ".findTodayOnline", transactionMember);
		System.out.println(selectOne);
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findTodayOnline", transactionMember);
	}
	
}
