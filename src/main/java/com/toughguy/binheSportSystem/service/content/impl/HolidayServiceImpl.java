package com.toughguy.binheSportSystem.service.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.binheSportSystem.model.content.Holiday;
import com.toughguy.binheSportSystem.persist.content.prototype.IHolidayDao;
import com.toughguy.binheSportSystem.service.content.prototype.IHolidayService;
import com.toughguy.binheSportSystem.service.impl.GenericServiceImpl;

/**
 * 查询某日期是否为节假日 service实现类
 * @author 
 *
 */
@Service
public class HolidayServiceImpl extends GenericServiceImpl<Holiday, Integer> implements IHolidayService{

	@Override
	public List<Holiday> findHoliday(String date) {
		return ((IHolidayDao)dao).findHoliday(date);
	}

}
