package com.kh.model.vo;

public class Lotto {
	private String userId;
	private String lottoNo;
	private String resultNo;
	private int rank;
	
	public Lotto() {
		super();
	}

	public Lotto(String userId, String lottoNo, String resultNo, int rank) {
		super();
		this.userId = userId;
		this.lottoNo = lottoNo;
		this.resultNo = resultNo;
		this.rank = rank;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLottoNo() {
		return lottoNo;
	}

	public void setLottoNo(String lottoNo) {
		this.lottoNo = lottoNo;
	}

	public String getResultNo() {
		return resultNo;
	}

	public void setResultNo(String resultNo) {
		this.resultNo = resultNo;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Lotto [userId=" + userId + ", lottoNo=" + lottoNo + ", resultNo=" + resultNo + ", rank=" + rank + "]";
	}
}
