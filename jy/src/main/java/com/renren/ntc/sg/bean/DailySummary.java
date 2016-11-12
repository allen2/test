package com.renren.ntc.sg.bean;

import java.util.List;

public class DailySummary {
	private Settlement nosettlemet;
	private List<Settlement> settlemets;
	private int walletPrice;
	private boolean canTake;
	
	public List<Settlement> getSettlemets() {
		return settlemets;
	}
	public void setSettlemets(List<Settlement> settlemets) {
		this.settlemets = settlemets;
	}
	public DailySummary() {
		super();
	}
	public DailySummary(Settlement noSettlemet,
			List<Settlement> settlemets) {
		super();
		this.nosettlemet = noSettlemet;
		this.settlemets = settlemets;
	
	}
	public Settlement getNosettlemet() {
		return nosettlemet;
	}
	public void setNosettlemet(Settlement nosettlemet) {
		this.nosettlemet = nosettlemet;
	}
	public int getWalletPrice() {
		return walletPrice;
	}
	public void setWalletPrice(int walletPrice) {
		this.walletPrice = walletPrice;
	}
	public boolean isCanTake() {
		return canTake;
	}
	public void setCanTake(boolean canTake) {
		this.canTake = canTake;
	}
}
