package com.toughguy.transactionSystem.persist.content.prototype;

import java.io.Serializable;
import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionRichText;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 
 * @author 富文本实体类Dao层
 *
 */
public interface ITransactionRichTextDao
	extends IGenericDao<TransactionRichText, Serializable> {
	
	/**
	 * 查询所有的信息
	 * @return List<TransactionRichText>
	 */
	public List<TransactionRichText> findAllInfo();
	
	/**
	 * 添加一条信息
	 * @param RichText
	 */
	public void saveInfo(TransactionRichText RichText);
	
	/**
	 * 删除一条信息
	 * @param id
	 */
	public void deleteInfo(int id);
	
	/**
	 * 编辑一条信息
	 * @param richText
	 */
	public void updateInfo(TransactionRichText richText);
	
}
