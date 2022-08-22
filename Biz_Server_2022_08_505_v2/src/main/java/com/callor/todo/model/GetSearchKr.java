package com.callor.todo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class GetSearchKr {

	@JsonProperty("list_total_count")
	public Header list_total_count;
	
	@JsonProperty("row")
	public List<SearchVO> row;
	
	@ToString
	public class Header {
		public String CODE;
		public String MESSAGE;
	}
}
