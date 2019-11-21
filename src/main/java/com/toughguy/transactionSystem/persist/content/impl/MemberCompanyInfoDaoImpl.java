package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.MemberCompanyInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IMemberCompanyInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/**
 * 会员信息及企业信息 数据的Dao接口实现类
 * @author 张泽
 *
 */
@Service
public class MemberCompanyInfoDaoImpl extends GenericDaoImpl<MemberCompanyInfo, Integer> implements IMemberCompanyInfoDao {
	
	
//	@Override
//	public List<MemberCompanyInfo> findAllInfo() {	
//		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllInfo");
//	}
	
	@Override
	public void saveInfo(MemberCompanyInfo memberCompanyInfo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".saveInfo1", memberCompanyInfo);
System.out.println(memberCompanyInfo.getMemberId());
		sqlSessionTemplate.insert(typeNameSpace + ".saveInfo2", memberCompanyInfo);
	}

//	@Override
//	public boolean deleteInfo(int id) {
//		// TODO Auto-generated method stub
////		sqlSessionTemplate.delete(typeNameSpace + ".deleteInfo1", id);
////		sqlSessionTemplate.delete(typeNameSpace + ".deleteInfo2", id);
//		return false;
//	}
//
//	@Override
//	public boolean updateInfo(MemberCompanyInfo memberCompanyInfo) {
//		sqlSessionTemplate.update(typeNameSpace + ".updateInfo1", memberCompanyInfo);
//		sqlSessionTemplate.update(typeNameSpace + ".updateInfo2", memberCompanyInfo);
//		return false;
//	}

	
	
}
