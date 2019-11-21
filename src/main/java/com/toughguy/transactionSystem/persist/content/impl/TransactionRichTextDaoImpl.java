package com.toughguy.transactionSystem.persist.content.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionRichText;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionRichTextDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class TransactionRichTextDaoImpl 
	extends GenericDaoImpl<TransactionRichText, Serializable>
	implements ITransactionRichTextDao {

	@Override
	public List<TransactionRichText> findAllInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllInfo");
	}

	@Override
	public void saveInfo(TransactionRichText RichText) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".saveInfo", RichText);
	}

	@Override
	public void deleteInfo(int id) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(typeNameSpace + ".deleteInfo", id);
	}

	@Override
	public void updateInfo(TransactionRichText richText) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateInfo", richText);
	}

}
