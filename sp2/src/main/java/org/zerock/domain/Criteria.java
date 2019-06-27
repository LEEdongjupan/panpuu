package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Criteria {
	
	private Integer bno; //int 는값을 안주면 0이지만 인테져는 null값
	private int page;
	private int amount;
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page=1;
		this.amount=10;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public void setPage(int page) {
		this.page = page <= 0? 1: page;
	}

	public void setAmount(int amount) {
		this.amount = amount <= 0? 10: amount;
	}
	
	public int getSkip() {
		return (this.page-1)*this.amount;
	}
	public String getLink() {
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromPath("")
				.queryParam("page" , page)
				.queryParam("amount", amount);
		
		return builder.toUriString();				
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
}
