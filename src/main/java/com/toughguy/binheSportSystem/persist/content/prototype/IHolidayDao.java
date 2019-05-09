package com.toughguy.binheSportSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.binheSportSystem.model.content.Holiday;
import com.toughguy.binheSportSystem.persist.prototype.IGenericDao;
/**
 * 查询某日期是否为节假日 Dao接口类
 * @author 
 *
 */

public interface IHolidayDao extends IGenericDao<Holiday, Integer> {

	public List<Holiday> findHoliday(String date);
}
