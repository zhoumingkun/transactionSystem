package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.ReghostServiceMemberEnterpriseInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IReghostServiceMemberEnterpriseInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class ReghostServiceInfoDaoImpl extends GenericDaoImpl<ReghostServiceMemberEnterpriseInfo, Integer>implements IReghostServiceMemberEnterpriseInfoDao{

}
