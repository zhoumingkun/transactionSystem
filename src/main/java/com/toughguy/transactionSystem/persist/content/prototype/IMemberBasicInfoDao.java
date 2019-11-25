package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 会员的基本信息
 * @author 张泽
 *
 */
public interface IMemberBasicInfoDao extends IGenericDao<MemberBasicInfo, Integer> {
	
	/**
	 * 所有的基本企业信息
	 * @return List<MemberBasicInfo>
	 */
	public List<MemberBasicInfo> enterpriseInfo();

}
