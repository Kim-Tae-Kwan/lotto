package com.ktk.lottoPrediction.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktk.lottoPrediction.domain.dto.LottoResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LottoBatch {
	
	private final String LOTTO_URL  = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
	private final ObjectMapper mapper;
	
	//second, minute, hour, day of month, month, day of week
	@Scheduled(cron = "50 58 * * * *")
	public void getLottoData() throws Exception {
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
}
