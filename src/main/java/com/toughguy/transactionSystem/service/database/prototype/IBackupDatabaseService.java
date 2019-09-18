package com.toughguy.binheSportSystem.service.database.prototype;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.toughguy.binheSportSystem.model.database.BackupDatabaseInfo;
import com.toughguy.binheSportSystem.service.prototype.IGenericService;

/**
 * 数据库备份服务接口类
 * @author fengjie
 * @date 2017-10-16
 * @since JDK1.7
 * @version 1.0
 */
public interface IBackupDatabaseService extends IGenericService<BackupDatabaseInfo, Integer>{
	
	/**
	 * 数据库备份
	 * @param path 备份文件存储路径
	 */
	public void backup(String path) throws IOException;
	
	/**
	 * 数据库还原
	 * @param path 备份文件存储路径
	 * 
	 */
	public void recover(String path,HttpSession session) throws IOException;
}
