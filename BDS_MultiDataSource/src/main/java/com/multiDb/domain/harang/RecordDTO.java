package com.multiDb.domain.harang;

public class RecordDTO {

	private String r_regdate;
	private long r_point;
	private String r_content;
	private String m_giver;
	private String m_givername;
	private String m_haver;
	private String m_havername;
	private String keyword;
	private String keyfield;
	private String m_id;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeyfield() {
		return keyfield;
	}
	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}
	public String getM_givername() {
		return m_givername;
	}
	public void setM_givername(String m_givername) {
		this.m_givername = m_givername;
	}
	public String getM_havername() {
		return m_havername;
	}
	public void setM_havername(String m_havername) {
		this.m_havername = m_havername;
	}
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}
	public long getR_point() {
		return r_point;
	}
	public void setR_point(long r_point) {
		this.r_point = r_point;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getM_giver() {
		return m_giver;
	}
	public void setM_giver(String m_giver) {
		this.m_giver = m_giver;
	}
	public String getM_haver() {
		return m_haver;
	}
	public void setM_haver(String m_haver) {
		this.m_haver = m_haver;
	}
	
	
	
}
