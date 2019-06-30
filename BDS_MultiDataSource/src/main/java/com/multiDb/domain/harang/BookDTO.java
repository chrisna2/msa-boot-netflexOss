package com.multiDb.domain.harang;

public class BookDTO {
	
	@Override
	public String toString() {
		return "BookDTO [b_num=" + b_num + ", m_id=" + m_id + ", b_choice=" + b_choice + ", b_want=" + b_want
				+ ", b_regdate=" + b_regdate + ", b_stock=" + b_stock + ", b_name=" + b_name + ", b_writer=" + b_writer
				+ ", b_pub=" + b_pub + ", b_content=" + b_content + ", b_iscomplete=" + b_iscomplete + ", m_name="
				+ m_name + ", bh_regdate=" + bh_regdate + ", bh_want=" + bh_want + ", bh_choice=" + bh_choice
				+ ", bh_iscomplete=" + bh_iscomplete + ", b_photo=" + b_photo + "]";
	}
	
	String b_num;
	String m_id;
	String b_choice;
	int b_want;
	String b_regdate;
	int b_stock;
	String b_name;
	String b_writer;
	String b_pub;
	String b_content;
	String b_iscomplete;
	String m_name;
	String bh_regdate;
	int bh_want;
	String bh_choice;
	String bh_iscomplete;
	String b_photo;
	
	
	public String getB_num() {
		return b_num;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getB_choice() {
		return b_choice;
	}
	public void setB_choice(String b_choice) {
		this.b_choice = b_choice;
	}
	public int getB_want() {
		return b_want;
	}
	public void setB_want(int b_want) {
		this.b_want = b_want;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_stock() {
		return b_stock;
	}
	public void setB_stock(int b_stock) {
		this.b_stock = b_stock;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_pub() {
		return b_pub;
	}
	public void setB_pub(String b_pub) {
		this.b_pub = b_pub;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_iscomplete() {
		return b_iscomplete;
	}
	public void setB_iscomplete(String b_iscomplete) {
		this.b_iscomplete = b_iscomplete;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getBh_regdate() {
		return bh_regdate;
	}
	public void setBh_regdate(String bh_regdate) {
		this.bh_regdate = bh_regdate;
	}
	public int getBh_want() {
		return bh_want;
	}
	public void setBh_want(int bh_want) {
		this.bh_want = bh_want;
	}
	public String getBh_choice() {
		return bh_choice;
	}
	public void setBh_choice(String bh_choice) {
		this.bh_choice = bh_choice;
	}
	public String getBh_iscomplete() {
		return bh_iscomplete;
	}
	public void setBh_iscomplete(String bh_iscomplete) {
		this.bh_iscomplete = bh_iscomplete;
	}
	public String getB_photo() {
		return b_photo;
	}
	public void setB_photo(String b_photo) {
		this.b_photo = b_photo;
	}
	

}
