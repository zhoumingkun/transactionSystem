package com.toughguy.transactionSystem.service.content.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionRichText;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionRichTextDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionRichTextSerive;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class TransactionRichTextServiceImpl
	extends GenericServiceImpl<TransactionRichText, Serializable>
	implements ITransactionRichTextSerive {

	@Autowired
	private ITransactionRichTextDao dao;
	
	@Override
	public List<TransactionRichText> findAllInfo() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void saveInfo(TransactionRichText RichText) {
		// TODO Auto-generated method stub
		dao.saveInfo(RichText);
	}

	@Override
	public void deleteInfo(int id) {
		// TODO Auto-generated method stub
		dao.deleteInfo(id);
	}

	@Override
	public void updateInfo(TransactionRichText richText) {
		// TODO Auto-generated method stub
		dao.updateInfo(richText);
	}

}
