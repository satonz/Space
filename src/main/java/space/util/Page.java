package space.util;

public class Page {
	// 当前表中总条目数量
	private int totalNumber;
	// 当前页的位置
	private int currentPage;
	// 总页数
	private int totalPage;
	// 页面大小
	private int pageSize;
	// 检索的起始位置
	private int startIndex;

	// 检索的总数目
	private int totalSelect;

	public Page() {
		super();
	}

	// 传入一个总条目数 和页面大小，计算page
	public void count(int totalNumber, int pageSize, int currentPage) {
		this.totalNumber = totalNumber;
		this.pageSize = pageSize;

		// 计算总页数
		int totalPageTemp = this.totalNumber / this.pageSize;
		int plus = (this.totalNumber % this.pageSize) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;

		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}

		this.totalPage = totalPageTemp;// 总页数

		// 计算当前页数
		this.currentPage = currentPage;

		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}

		// 计算索引位置
		this.startIndex = (this.currentPage - 1) * this.pageSize;// 起始位置等于之前所有页面输乘以页面大小
		this.totalSelect = this.pageSize;// 检索数量等于页面大小
		System.out.println("计算接结果：" + this.toString());
	}

	@Override
	public String toString() {
		return "Page [totalNumber=" + totalNumber + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", pageSize=" + pageSize + ", startIndex=" + startIndex + ", totalSelect=" + totalSelect + "]";
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getTotalSelect() {
		return totalSelect;
	}

}
