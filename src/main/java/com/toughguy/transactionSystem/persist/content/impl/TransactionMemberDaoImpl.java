package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionMemberDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 会员dao实现
 * @author liDongSheng
 *
 */
@Repository
public class TransactionMemberDaoImpl extends GenericDaoImpl<TransactionMember, Integer>implements ITransactionMemberDao{

	@Override
	public TransactionMember findmeber(TransactionMember member) {
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findmeber", member);
	}

	@Override
	public List<TransactionMember> findMemberAll() {
		return sqlSessionTemplate.selectList(typeNameSpace+".findMemberAll");
	}

}
