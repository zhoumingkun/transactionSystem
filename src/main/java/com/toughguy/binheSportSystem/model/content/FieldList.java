package com.toughguy.binheSportSystem.model.content;

import java.util.Arrays;

/**
 * 场地预定详情类
 * @author 
 *
 */
public class FieldList {
	
		private String fieldName;  	//场馆号
		private int[]  state;	//时间表格状态	//1为未预定   2为已经预定  -1为不可预定
		
		public FieldList() {
			super();
		}
		public FieldList(String fieldName, int[] state) {
			super();
			this.fieldName = fieldName;
			this.state = state;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public int[] getState() {
			return state;
		}
		public void setState(int[] state) {
			this.state = state;
		}
		@Override
		public String toString() {
			return "fieldList [fieldName=" + fieldName + ", state=" + Arrays.toString(state) + "]";
		}
		
}
