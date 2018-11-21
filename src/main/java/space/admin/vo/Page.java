package space.admin.vo;

public class Page {

	private int totalNumber;// 按特定要求检索之后的记录总数
	private int currentPage;// 当前页数
	private int totalPage;// 按特定要求检索总共页数
	private int pageSize;
	private int startIndex;
	private int totalSelect;

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalSelect() {
		return totalSelect;
	}

	public void setTotalSelect(int totalSelect) {
		this.totalSelect = totalSelect;
	}

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(int totalNumber, int currentPage, int pageSize) {
		this.totalNumber = totalNumber;
		this.pageSize = pageSize;
		int totalPageTemp = this.totalNumber / this.pageSize;
		int plus = (this.totalNumber % this.pageSize) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;
		this.currentPage = currentPage;
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		this.startIndex = (this.currentPage - 1) * this.pageSize;
		this.totalSelect = this.pageSize;
	}

}
