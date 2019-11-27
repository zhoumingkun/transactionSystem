package com.toughguy.transactionSystem.model.content.vo;

/**
 * sqlSessionTemplate 传入与返回的信息
 * @author 张泽
 *
 */
public class SqlGeneralTwoString {
	private String arg1;
	private String arg2;
	
	public SqlGeneralTwoString(String arg1, String arg2) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public SqlGeneralTwoString() {
		super();
	}

	public String getArg1() {
		return arg1;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arg1 == null) ? 0 : arg1.hashCode());
		result = prime * result + ((arg2 == null) ? 0 : arg2.hashCode());
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
		SqlGeneralTwoString other = (SqlGeneralTwoString) obj;
		if (arg1 == null) {
			if (other.arg1 != null)
				return false;
		} else if (!arg1.equals(other.arg1))
			return false;
		if (arg2 == null) {
			if (other.arg2 != null)
				return false;
		} else if (!arg2.equals(other.arg2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SqlGeneralTwoString [arg1=" + arg1 + ", arg2=" + arg2 + "]";
	}
	
	
	
}
