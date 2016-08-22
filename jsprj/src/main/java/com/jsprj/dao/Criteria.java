package com.jsprj.dao;

public class Criteria {

		private int page;
		private int boardCnt; // 보여질 페이지 개수
		
		public Criteria() {
			this.page=1;
			this.boardCnt=10;
		}
		
		
		//페이지와 페이지에 보여질 게시글 수의 setter, getter 작업
		public void setPage(int page){
			if(page <=0){
				page=1;
				return;
			}
			this.page=page;
		}
		public int getPage(){
			return page;
		}
		
		//mapper에서 쓸꺼
		public int getPageStart(){
			return (this.page - 1)*boardCnt;
		}
		
		public void setBoardCnt(int boardCnt){
			if(boardCnt <= 0 || boardCnt >100){
				this.boardCnt =10;
				return;
			}
			this.boardCnt=boardCnt;
		}
		public int getBoardCnt(){
			return boardCnt;
		}
		

		public String toString(){
			return "Criteria [page="+page+",boardCnt="+boardCnt+"]";
		}
		
		
		
}
