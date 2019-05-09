package com.toughguy.binheSportSystem.persist.content.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.toughguy.binheSportSystem.model.content.WXBind;
import com.toughguy.binheSportSystem.persist.content.prototype.IWXBindDao;
import com.toughguy.binheSportSystem.persist.impl.GenericDaoImpl;

/**
 *用户信息查询绑定Dao实现类
 * @author 
 *
 */
@Service
public class WXBindDaoImpl extends GenericDaoImpl<WXBind, Integer> implements IWXBindDao{

	
/*	@Override
	public WXBind findOne(String openid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findOne", openid);
	}*/


	@Override
	public List<WXBind> findBindInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBindInfo", map);
	}

	@Override
	public List<WXBind> findUsedBindInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findUsedBindInfo", map);
	}
}
