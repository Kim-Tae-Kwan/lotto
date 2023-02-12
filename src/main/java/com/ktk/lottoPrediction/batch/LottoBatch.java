package com.ktk.lottoPrediction.batch;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktk.lottoPrediction.domain.dto.LottoResponseDto;
import com.ktk.lottoPrediction.repository.LottoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LottoBatch implements CommandLineRunner{
	private final ObjectMapper mapper;
	private final LottoRepository lottoRepository;
	private final String LOTTO_URL  = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";

	@Override
	public void run(String... args) throws Exception {
		if(lottoRepository.count() == 0L) {
			getAllLottoData();
		}
		System.out.println();
	}
	
	//second, minute, hour, day of month, month, day of week
	@Scheduled(cron = "10 52 * * * *")
	public void getLottoData() throws Exception {
		System.out.println("Batch start ...");
		
		// 1. 이전 회차 찾기
		Integer preRoundNumber = lottoRepository.findMaxRoundNumber();
		
		// 2. 다음 회차 조회	
		RestTemplate restTemplate = new RestTemplate();
		
		String res = restTemplate.getForObject(LOTTO_URL + (preRoundNumber + 1), String.class);
		LottoResponseDto lottoResponseDto = mapper.readValue(res, LottoResponseDto.class);
		
		// 3. 다음 회차 로또 입력
		lottoRepository.save(lottoResponseDto.toEntity());
		
		System.out.println("Batch end ...");
	}
	
	private void getAllLottoData() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		int i = 1;
		while(true) {
			String res = restTemplate.getForObject(LOTTO_URL + i, String.class);
			LottoResponseDto lottoResponseDto = mapper.readValue(res, LottoResponseDto.class);
			
			if(lottoResponseDto.getReturnValue().equals("fail")) break;
			
			lottoRepository.save(lottoResponseDto.toEntity());
			
			System.out.println(lottoResponseDto);
			i++;
		}
	}
}
