package com.multiDb.domain.harang;

import java.sql.Date;

public class BbreplyDTO {

	
		private String m_id;
		private String br_num;
		private String bb_num;
		private String br_coment;
		private String br_nickname;
		private Date br_regdate;
		public String getM_id() {
			return m_id;
		}
		public void setM_id(String m_id) {
			this.m_id = m_id;
		}
		public String getBr_num() {
			return br_num;
		}
		public void setBr_num(String br_num) {
			this.br_num = br_num;
		}
		public String getBb_num() {
			return bb_num;
		}
		public void setBb_num(String bb_num) {
			this.bb_num = bb_num;
		}
		public String getBr_coment() {
			return br_coment;
		}
		public void setBr_coment(String br_coment) {
			this.br_coment = br_coment;
		}
		public String getBr_nickname() {
			return br_nickname;
		}
		public void setBr_nickname(String br_nickname) {
			this.br_nickname = br_nickname;
		}
		public Date getBr_regdate() {
			return br_regdate;
		}
		public void setBr_regdate(Date br_regdate) {
			this.br_regdate = br_regdate;
		}

}
