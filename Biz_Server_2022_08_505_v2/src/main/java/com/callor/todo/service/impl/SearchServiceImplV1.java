package com.callor.todo.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

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


		@Override
		public String queryString(String search) {

			String queryString = SearchConfig.API_FULL_URL;
			queryString = String.format(queryString,1 ,10 );
			log.debug("쿼리 스트링 {}", queryString);
			
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
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(
					Collections.singletonList(MediaType.APPLICATION_JSON)
			);
			HttpEntity<String> headerEntity 
				= new HttpEntity<String>("parameter",headers);
			
			
			RestTemplate restTemp = new RestTemplate();
			
			
			ResponseEntity<String> resString = null;
			resString = restTemp.exchange(foodRestURI, 
					HttpMethod.GET,headerEntity,String.class);
			
			log.debug("=".repeat(100));
			log.debug("{}",resString.getBody());
			log.debug("=".repeat(100));
			
			
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

			return null;
		}



		@Override
		public String queryString(int pageno) {
			
			String queryString = SearchConfig.API_FULL_URL;
			
			int startIndex = (pageno-1) * 10 +1;
			int endIndex = startIndex + 10;
			queryString = String.format(queryString,startIndex ,endIndex );
			log.debug("페이지 쿼리 {}", queryString);
			return queryString;
		}

		
}

		



