package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.vo.MemberCompanyInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 会员信息及企业信息 数据的Dao接口类
 * @author 张泽
 *
 */
public interface IMemberCompanyInfoDao extends IGenericDao<MemberCompanyInfo, Integer> {
	
	/**
	 * 查询全部信息
	 * @return
	 */
//	public List<MemberCompanyInfo> findAllInfo();
	
	/**
	 * 增加一条信息
	 * @return id
	 */
	public void saveInfo(MemberCompanyInfo memberCompanyInfo);
	
	/**
	 * 删除一条信息
	 * @return boolean
	 */
//	public boolean deleteInfo(int id);
	
	/**
	 * 更新一条信息
	 * @return boolean
	 */
//	public boolean updateInfo(MemberCompanyInfo memberCompanyInfo);


}
