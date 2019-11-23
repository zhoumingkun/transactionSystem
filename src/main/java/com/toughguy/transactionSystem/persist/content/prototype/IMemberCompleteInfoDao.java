package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 会员完整信息 数据的Dao接口类
 * 实现 完善资料  看看资料
 * @author 张泽
 *
 */
public interface IMemberCompleteInfoDao extends IGenericDao<MemberCompleteInfo, Integer> {
	
	/**
	 * 完善全部信息
	 * @return id
	 */
	public void saveCompleteInfo(MemberCompleteInfo info);
	
	
	/**
	 * 查找一个企业用户信息
	 * @param id
	 * @return
	 */
	public MemberCompleteInfo findEnterpriseInfo(MemberCompleteInfo info);
	
	
	
}
