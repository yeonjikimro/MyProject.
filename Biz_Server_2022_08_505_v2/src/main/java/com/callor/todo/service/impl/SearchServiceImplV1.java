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


	// pagenation
		@Override
		public String queryString(String search) {

			String queryString = SearchConfig.API_FULL_URL;
			// 리턴되는 문자열의 형식 지정 %d
			queryString = String.format(queryString,1 ,10 );
			log.debug("qer {}", queryString);
			
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
			
			// Http 프로토콜에 부가적인 정보를 전송
			HttpHeaders headers = new HttpHeaders();
			
			// JSON 데이터 타입으로 받겠다
			headers.setAccept(
					Collections.singletonList(MediaType.APPLICATION_JSON)
			);
			
			// headers 에 추가된 정보를 Entity type 의 객체로 변환
			// HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
			HttpEntity<String> headerEntity 
				= new HttpEntity<String>("parameter",headers);
			
			// REST API 호출이후 응답을 받을 때까지 기다리는 동기 방식, json과 xml 응답을 모두 받을 수 있다.
			RestTemplate restTemp = new RestTemplate();
			
			// HttpRequest에 대한 응답 데이터를 포함하는 클래스
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
			
				
			// Api 에서 받은 데이터는 resFoodObject 의 body 에 담겨있다.
			// body 데이터를 get 하여 그 데이터 중에서 items 만 추출하여
			// Controller 로 return
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

		



