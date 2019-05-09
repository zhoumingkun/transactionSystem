package com.toughguy.binheSportSystem.service.content.prototype;

import java.util.List;

import com.toughguy.binheSportSystem.model.content.Holiday;
import com.toughguy.binheSportSystem.service.prototype.IGenericService;

/**
 * 查询某日期是否为节假日 service接口类
 * @author
 *
 */
public interface IHolidayService extends IGenericService<Holiday, Integer> {
	public List<Holiday> findHoliday(String date);
}
