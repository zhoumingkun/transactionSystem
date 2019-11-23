package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberCompleteInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 会员完整信息模块Dao实现
 * @author 张泽
 *
 */
@Repository
public class MemberCompleteInfoDaoImpl extends GenericDaoImpl<MemberCompleteInfo, Integer> implements IMemberCompleteInfoDao{

	@Override
	public void saveCompleteInfo(MemberCompleteInfo info) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".saveCompleteInfo", info);
	}

	@Override
	public MemberCompleteInfo findEnterpriseInfo(MemberCompleteInfo info) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findEnterpriseInfo", info);
	}


}
