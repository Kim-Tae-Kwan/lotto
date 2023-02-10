package com.ktk.lottoPrediction;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktk.lottoPrediction.domain.dto.LottoResponseDto;

class LottoPredictionApplicationTests {
	
	@Test
	public void lottoApi() throws JsonMappingException, JsonProcessingException {
		final String LOTTO_URL  = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
		
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		
		int i = 1;
		while(true) {
			String res = restTemplate.getForObject(LOTTO_URL + i, String.class);
			LottoResponseDto lottoResponseDto = mapper.readValue(res, LottoResponseDto.class);
			
			if(lottoResponseDto.getReturnValue().equals("fail")) break;
			
			System.out.println(lottoResponseDto);
			i++;
		}
		
	}
	
	public void localDate() {
		LocalDate date = LocalDate.parse("2003-11-15");
		System.out.println(date.toString());
	}
}
