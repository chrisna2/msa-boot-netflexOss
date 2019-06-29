package com.multiDb.domain.harang;

public class PgMemberDTO {
	String pgm_regdate;
	String pgm_date;
	String pgm_timecode;
	String m_id;
	String pg_num;
	String pgm_num;
	String pg_type;
	String pg_name;
	String pgm_point;
	String pgm_content;
	String pgm_issue;
	int pg_point;
	int payoutpoint;
	int cnt;

	public int getCnt() {
		return cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String getPgm_issue() {
		return pgm_issue;
	}

	public void setPgm_issue(String pgm_issue) {
		this.pgm_issue = pgm_issue;
	}

	public int getPayoutpoint() {
		return payoutpoint;
	}

	public void setPayoutpoint(int payoutpoint) {
		this.payoutpoint = payoutpoint;
	}

	public int getPg_point() {
		return pg_point;
	}

	public void setPg_point(int pg_point) {
		this.pg_point = pg_point;
	}

	public String getPgm_point() {
		return pgm_point;
	}

	public void setPgm_point(String pgm_point) {
		this.pgm_point = pgm_point;
	}

	public String getPgm_content() {
		return pgm_content;
	}

	public void setPgm_content(String pgm_content) {
		this.pgm_content = pgm_content;
	}

	public String getPg_type() {
		return pg_type;
	}

	public void setPg_type(String pg_type) {
		this.pg_type = pg_type;
	}

	public String getPg_name() {
		return pg_name;
	}

	public void setPg_name(String pg_name) {
		this.pg_name = pg_name;
	}

	public String getPgm_num() {
		return pgm_num;
	}

	public void setPgm_num(String pgm_num) {
		this.pgm_num = pgm_num;
	}

	public String getPgm_regdate() {
		return pgm_regdate;
	}

	public void setPgm_regdate(String pgm_regdate) {
		this.pgm_regdate = pgm_regdate;
	}

	public String getPgm_date() {
		return pgm_date;
	}

	public void setPgm_date(String pgm_date) {
		this.pgm_date = pgm_date;
	}

	public String getPgm_timecode() {
		return pgm_timecode;
	}

	public void setPgm_timecode(String pgm_timecode) {
		this.pgm_timecode = pgm_timecode;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getPg_num() {
		return pg_num;
	}

	public void setPg_num(String pg_num) {
		this.pg_num = pg_num;
	}

}
