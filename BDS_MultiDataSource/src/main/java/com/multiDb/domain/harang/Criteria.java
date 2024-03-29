package com.multiDb.domain.harang;

public class Criteria {
	
	private int page;
	private int perPageNum;

	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {

		if (page <= 0) {
			page = 1;
			return;
		}
		this.page = page;

	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			perPageNum = 10;
		}

		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		return (page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [ page=" + page + "perPageNum=" + perPageNum + "]";
	}
}
