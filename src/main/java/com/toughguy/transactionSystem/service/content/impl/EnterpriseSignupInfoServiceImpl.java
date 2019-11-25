package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.EnterpriseSignupInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseSignupInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseSignupInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseSignupInfoServiceImpl extends GenericServiceImpl<EnterpriseSignupInfo, Integer>implements IEnterpriseSignupInfoService{
	@Autowired
	private IEnterpriseSignupInfoDao enterpriseSignupInfoDao; 
	@Override
	public List<EnterpriseSignupInfo> findSignupEnterpriseList(EnterpriseSignupInfo enterpriseSignupInfo) {
		return enterpriseSignupInfoDao.findSignupEnterprise(enterpriseSignupInfo);
	}

}
