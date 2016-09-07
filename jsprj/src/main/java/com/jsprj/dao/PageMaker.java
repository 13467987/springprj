package com.jsprj.dao;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCnt;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 5; //보여질 페이징 개수
	
	private Criteria cri;
	
	public void setCri (Criteria cri){
		this.cri = cri;
	}
	
	public void setTotalCnt(int totalCnt){
		this.totalCnt =totalCnt;
		calData();
	}

	private void calData() {
		endPage = (int)(Math.ceil(cri.getPage() / (double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		
		int tempEndPage = (int)(Math.ceil(totalCnt / (double)cri.getBoardCnt()));
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		
		next = endPage *cri.getBoardCnt() >= totalCnt ? false:true;
		
	}
	
	public String makeQuery(int page){
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("boardCnt",cri.getBoardCnt())
				.build();
		return uriComponents.toUriString();
	}

	public String makeSearch(int page){
		UriComponents uricomponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("boardCnt",cri.getBoardCnt())
				.queryParam("searchType",(( SearchCriteria)cri).getSearchType())
				.queryParam("keyword",((SearchCriteria)cri).getKeyword())
				.build();
		System.out.println(((SearchCriteria)cri).getKeyword());
		return uricomponents.toUriString();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public Criteria getCri() {
		return cri;
	}
	
	
}
