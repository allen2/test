package com.renren.ntc.sg.bean;
/**
 * 代金券规则json对象
 * @author chunhai.li
 *
 */
public class CounponRule {
	private boolean useRule;
	private NewUser newUser;
	private String canUse;
	private String categoryId;
	private FullCut fullCut;
	
	public static class NewUser{
		private String create_time;
		private String deadline;

		public String getCreate_time() {
			return create_time;
		}

		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		public String getDeadline() {
			return deadline;
		}

		public void setDeadline(String deadline) {
			this.deadline = deadline;
		}

	
	}
	public static class FullCut{
		private int price;

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	}

	public NewUser getNewUser() {
		return newUser;
	}
	public void setNewUser(NewUser newUser) {
		this.newUser = newUser;
	}
	public String getCanUse() {
		return canUse;
	}
	public void setCanUse(String canUse) {
		this.canUse = canUse;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public FullCut getFullCut() {
		return fullCut;
	}
	public void setFullCut(FullCut fullCut) {
		this.fullCut = fullCut;
	}
	public boolean isUseRule() {
		return useRule;
	}
	public void setUseRule(boolean useRule) {
		this.useRule = useRule;
	}
}
