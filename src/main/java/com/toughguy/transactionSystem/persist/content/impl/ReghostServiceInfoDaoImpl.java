package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.ReghostServiceInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IReghostServiceInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class ReghostServiceInfoDaoImpl extends GenericDaoImpl<ReghostServiceInfo, Integer>implements IReghostServiceInfoDao{

}
