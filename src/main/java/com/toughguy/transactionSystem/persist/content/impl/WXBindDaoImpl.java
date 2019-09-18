package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.WXBind;
import com.toughguy.transactionSystem.persist.content.prototype.IWXBindDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/**
 *用户信息查询绑定Dao实现类
 * @author 
 *
 */
@Service
public class WXBindDaoImpl extends GenericDaoImpl<WXBind, Integer> implements IWXBindDao{

	
	@Override
	public void insertBind(WXBind bind) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".insertBind", bind);
	}

	@Override
	public void deleteTime(WXBind wx) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(typeNameSpace + ".deleteTime",wx);
	}

	
	@Override
	public WXBind selectOpenid(WXBind wx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".selectOpenid",wx);
	}
	
	
	@Override
	public List<WXBind> findBindInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBindInfo", map);
	}

	@Override
	public WXBind selecUserBind(WXBind bind) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".selecUserBind", bind);
	}
}
