package com.toughguy.transactionSystem.service.content.prototype;

import java.io.Serializable;
import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionRichText;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

/**
 * 富文本Service层
 * @author 张泽
 *
 */
public interface ITransactionRichTextSerive
	extends IGenericService<TransactionRichText, Serializable> {

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
