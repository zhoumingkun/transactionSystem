package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseDaoImpl 
extends GenericDaoImpl<TransactionEnterprise, Integer>
implements IEnterpriseDao{

	@Override
	public void insertBasicMsg(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".insertMsg", info);
	}
	
	@Override
	public void insertMsgNoCard(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".insertMsgNoCard", info);
	}
	
	@Override
	public TransactionEnterprise findEnterpriseName(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findEnterpriseName", info);
	}

	@Override
	public void saveCompleteInfo(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".saveCompleteInfo", info);
	}

	@Override
	public TransactionEnterprise isComplete(TransactionEnterprise transactionEnterprise) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".isComplete", transactionEnterprise);
	}

	@Override
	public MemberCompleteInfo findEnterpriseInfo(TransactionEnterprise transactionEnterprise) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findEnterpriseInfo", transactionEnterprise);
	}

	



}
