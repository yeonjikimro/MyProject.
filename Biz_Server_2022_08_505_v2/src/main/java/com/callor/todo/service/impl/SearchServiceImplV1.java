package com.callor.todo.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.todo.api.QualifierConfig;
import com.callor.todo.api.SearchConfig;
import com.callor.todo.model.SearchRoot;
import com.callor.todo.model.SearchVO;
import com.callor.todo.service.SearchService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service(QualifierConfig.SERVICE.SEARCH_V1)
public class SearchServiceImplV1 implements SearchService{
	
		@Autowired
		public SearchService searchService;

		@Override
		public String queryString(String search) {

			String queryString = SearchConfig.API_FULL_URL;
			String encodeParams = null;
			
			try {
				encodeParams = "?" + URLEncoder.encode("serviceKey","UTF-8");
				
				encodeParams += "&" + URLEncoder.encode("pageNo","UTF-8");
				encodeParams += "=1";
				
				encodeParams += "&" + URLEncoder.encode("numOfRows","UTF-8");
				encodeParams += "=10";
				
				encodeParams += "&" + URLEncoder.encode("resultType","UTF-8");
				encodeParams += "=json";
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			queryString += encodeParams;
			log.debug("쿼리 문자열 {}", queryString);
			return queryString;
		}



		@Override
		public List<SearchVO> getSearchVOs(String queryString) {
			// TODO Auto-generated method stub

			URI foodRestURI = null;
			try {
				foodRestURI = new URI(queryString);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// API 에 JSON type 으로 데이터를 요청하기 위한 헤더 생성
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(
					Collections.singletonList(MediaType.APPLICATION_JSON)
			);
			HttpEntity<String> headerEntity 
				= new HttpEntity<String>("parameter",headers);
			
			// 데이터를 수신하여 VO 로 변환하기 위한 객체 선언
			RestTemplate restTemp = new RestTemplate();
			
			// String type 으로 데이터를 수신하여 어떤 형태로
			// 데이터가 수신되는지 확인하는 절차
			ResponseEntity<String> resString = null;
			resString = restTemp.exchange(foodRestURI, 
					HttpMethod.GET,headerEntity,String.class);
			
			log.debug("=".repeat(100));
			log.debug("{}",resString.getBody());
			log.debug("=".repeat(100));
			
			// 수신된 데이터를 VO 로 변환하기
			ResponseEntity<SearchRoot> resFoodObject = null;
			resFoodObject = restTemp.exchange(
					foodRestURI, HttpMethod.GET,
					headerEntity, 
					SearchRoot.class);
			
					resFoodObject.getBody();
			
		return resFoodObject.getBody().SeoulPhilPblprfr.row;
		}



		@Override
		public SearchVO findById(Long PERF_NO) {
			// TODO Auto-generated method stub
			return searchService.findById(PERF_NO);
		}
		
		}



