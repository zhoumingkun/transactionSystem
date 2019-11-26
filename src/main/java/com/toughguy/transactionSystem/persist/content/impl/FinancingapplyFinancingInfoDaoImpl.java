package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IFinancingapplyFinancingInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 融资和融资申请
 * @author liDongSheng
 *
 */
@Repository
public class FinancingapplyFinancingInfoDaoImpl extends GenericDaoImpl<FinancingapplyFinancingInfo, Integer>implements IFinancingapplyFinancingInfoDao {

}
