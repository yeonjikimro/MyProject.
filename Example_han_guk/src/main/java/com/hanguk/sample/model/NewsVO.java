package com.hanguk.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsVO {
	
	
	private long seq;
	private String title;
	private String context;
	private String date;
	private String writer;
	
	private String images;

}
