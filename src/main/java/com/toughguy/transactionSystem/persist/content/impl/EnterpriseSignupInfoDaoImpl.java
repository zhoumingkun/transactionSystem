package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.EnterpriseSignupInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseSignupInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class EnterpriseSignupInfoDaoImpl extends GenericDaoImpl<EnterpriseSignupInfo, Integer>implements IEnterpriseSignupInfoDao{

	@Override
	public List<EnterpriseSignupInfo> findSignupEnterprise(EnterpriseSignupInfo enterpriseSignupInfo) {
		return sqlSessionTemplate.selectList(typeNameSpace+".findSignupEnterprise", enterpriseSignupInfo);
	}

}
