package com.callor.memo.model;

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
public class FaqVO {

	private int notice_seq;
	private String notice_title;
	private String notice_name;
	private String notice_content;
	private String date;
}
