package com.callor.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchVO {
	
	// 공연일련번호
	@JsonProperty("PERF_NO")
	private long PERF_NO;
	// 장르
	@JsonProperty("GUBUN2")
	private String GUBUN2;
	// 공연명
	@JsonProperty("TITLE_KOR")
	private String TITLE_KOR;
	
	// 공연장소
	@JsonProperty("PLACE_KOR")
	private String PLACE_KOR;
	// 공연 일시
	@JsonProperty("PERFORM_DATE")
	private String PERFORM_DATE;
	// 티켓 가격
	@JsonProperty("TICKET_KOR")
	private String TICKET_KOR;
	// 곡명
	@JsonProperty("SONG_TITLE_KOR")
	private String SONG_TITLE_KOR;
	// 프로그램 소개
	@JsonProperty("PROGRAM_KOR")
	private String PROGRAM_KOR;
	// 이미지
	@JsonProperty("IMGSRC")
	private String IMGSRC;


}
