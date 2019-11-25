package com.toughguy.transactionSystem.model.content.vo;

/**
 * sqlSessionTemplate 传入与返回的单个信息
 * @author 张泽
 *
 */
public class SqlGeneralInfo {
	private String info;

	public SqlGeneralInfo(String info) {
		super();
		this.info = info;
	}

	public SqlGeneralInfo() {
		super();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SqlGeneralInfo [info=" + info + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SqlGeneralInfo other = (SqlGeneralInfo) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}

	
	
	
}
