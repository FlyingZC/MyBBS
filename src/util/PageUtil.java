package util;

import java.util.List;

public class PageUtil<T> {
	private Long currentPage;
	private Long totalRecords;
	private Long totalPages;
	private Long pageSize;
	private List<T> data;
	private Long start;//起始数据下标
	private Long end;
	private String url;
	
	public PageUtil(){
		
	}
	public PageUtil(Long currentPage, Long pageSize) {
		this.currentPage=currentPage;
		this.pageSize=pageSize;
	}
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Long getTotalPages() {
		return totalRecords%pageSize==0?(totalRecords/pageSize):(totalRecords/pageSize+1);
	}
	/*public void setTotalPages(Long totalPages) {
		this.totalPages = (totalRecords%pageSize==0?(totalRecords/pageSize):(totalRecords/pageSize+1));
	}*/
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Long getStart() {
		return (currentPage-1)*pageSize+1;
	}
	/*public void setStart(Long start) {
		this.start = start;
	}*/
	public Long getEnd() {
		return currentPage*pageSize;
	}
	/*public void setEnd(Long end) {
		this.end = end;
	}*/
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
