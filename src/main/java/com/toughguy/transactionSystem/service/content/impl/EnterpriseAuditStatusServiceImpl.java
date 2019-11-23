package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAuditStatusService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAuditStatusServiceImpl
extends GenericServiceImpl<TransactionEnterpriseAuditStatus, Integer>
implements IEnterpriseAuditStatusService{

}
