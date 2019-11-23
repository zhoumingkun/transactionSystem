package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAuditStatusDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseAuditStatusDaoImpl
extends GenericDaoImpl<TransactionEnterpriseAuditStatus, Integer>
implements IEnterpriseAuditStatusDao{

}
