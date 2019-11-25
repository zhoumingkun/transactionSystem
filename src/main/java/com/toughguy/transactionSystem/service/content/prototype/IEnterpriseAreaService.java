package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseAreaService extends IGenericService<TransactionEnterpriseArea, Integer>{
	
	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseArea> findStatusAll();
}
