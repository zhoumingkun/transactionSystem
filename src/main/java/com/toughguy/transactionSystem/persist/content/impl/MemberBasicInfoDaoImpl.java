package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberBasicInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 会员基本信息模块Dao实现
 * @author 张泽
 *
 */
@Service
public class MemberBasicInfoDaoImpl 
	extends GenericDaoImpl<MemberBasicInfo, Integer>
	implements IMemberBasicInfoDao {


	@Override
	public List<MemberBasicInfo> enterpriseInfo() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".enterpriseInfo");
	}

	

}
