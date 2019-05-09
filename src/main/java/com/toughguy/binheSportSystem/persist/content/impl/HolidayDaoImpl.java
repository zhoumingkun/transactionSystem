package com.toughguy.binheSportSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.binheSportSystem.model.content.Holiday;
import com.toughguy.binheSportSystem.persist.content.prototype.IHolidayDao;
import com.toughguy.binheSportSystem.persist.impl.GenericDaoImpl;
/**
 * 查询某日期是否为节假日 Dao实现类
 * @author qi
 *
 */

@Repository
public class HolidayDaoImpl extends GenericDaoImpl<Holiday, Integer> implements IHolidayDao {

	@Override
	public List<Holiday> findHoliday(String date) {
		return  sqlSessionTemplate.selectList(typeNameSpace + ".findHoliday", date);
	}

	
}
