package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberBasicInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 会员基本信息模块Dao实现
 * @author 张泽
 *
 */
@Service
public class MemberBasicInfoDaoImpl 
	extends GenericDaoImpl<MemberBasicInfo, Integer>
	implements IMemberBasicInfoDao {

	@Override
	public void saveBasicInfo(MemberBasicInfo info) {
		sqlSessionTemplate.insert(typeNameSpace + ".saveBasicInfo1", info);
		sqlSessionTemplate.insert(typeNameSpace + ".saveBasicInfo2", info);
	}

	@Override
	public boolean loginCheck(TransactionMember info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".loginCheck", info).size()==1;
	}

	@Override
	public boolean checkOpenId(TransactionMember info) {
		// TODO Auto-generated method stub
		System.out.println("1111111111111");
		return sqlSessionTemplate.selectList(typeNameSpace + ".checkOpenId", info).size()==1;
	}
	
	@Override
	public void updatePassword(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updatePassword", info);
	}

	@Override
	public void updateUserTel(TransactionMember info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateUser", info);
	}

	@Override
	public List<MemberBasicInfo> memberInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".memberInfo");
	}
	
	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".enterpriseInfo");
	}

	

}
