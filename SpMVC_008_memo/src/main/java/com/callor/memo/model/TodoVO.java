package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TodoVO {
	
	private long t_seq;
	private String t_username;
	private String p_date;
	private String p_time;
	private String t_context;
	private String c_date;
	private String c_time;
	
	private int t_menu;
	
	private Boolean complete;

}
