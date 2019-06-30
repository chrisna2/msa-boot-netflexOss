package com.multiDb.domain;

public class TaskVo {
	
	private int pk;
	private String task_id;
	private String interface_id;
	private String from_col;
	private String to_col;
	private int task_order;
	
	@Override
	public String toString() {
		return "TaskVo [pk=" + pk + ", task_id=" + task_id + ", interface_id=" + interface_id + ", from_col=" + from_col
				+ ", to_col=" + to_col + ", task_order=" + task_order + "]";
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getInterface_id() {
		return interface_id;
	}
	public void setInterface_id(String interface_id) {
		this.interface_id = interface_id;
	}
	public String getFrom_col() {
		return from_col;
	}
	public void setFrom_col(String from_col) {
		this.from_col = from_col;
	}
	public String getTo_col() {
		return to_col;
	}
	public void setTo_col(String to_col) {
		this.to_col = to_col;
	}
	public int getTask_order() {
		return task_order;
	}
	public void setTask_order(int task_order) {
		this.task_order = task_order;
	}

}
