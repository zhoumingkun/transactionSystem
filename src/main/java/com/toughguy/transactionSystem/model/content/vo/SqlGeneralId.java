package com.toughguy.transactionSystem.model.content.vo;

public class SqlGeneralId {
	private int id;

	public SqlGeneralId(int id) {
		super();
		this.id = id;
	}

	public SqlGeneralId() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		SqlGeneralId other = (SqlGeneralId) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
