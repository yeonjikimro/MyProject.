package com.callor.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class SearchRoot {
	
	@JsonProperty("SeoulPhilPblprfr")
	public GetSearchKr SeoulPhilPblprfr;

}
