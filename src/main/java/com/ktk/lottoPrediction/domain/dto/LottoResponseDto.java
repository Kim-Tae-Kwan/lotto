package com.ktk.lottoPrediction.domain.dto;

import java.time.LocalDate;

import com.ktk.lottoPrediction.domain.entity.Lotto;

import lombok.Data;

@Data
public class LottoResponseDto {
	private Integer drwtNo1; // 로또번호 1
	private Integer drwtNo2; // 로또번호 2
	private Integer drwtNo3; // 로또번호 3
	private Integer drwtNo4; // 로또번호 4
	private Integer drwtNo5; // 로또번호 5
	private Integer drwtNo6; // 로또번호 6
	private Integer bnusNo;  // 보너스
	private Integer drwNo;   // 로또 회차
	private Integer firstPrzwnerCo; // 1 등 당첨인원
	private Long firstAccumamnt; // 
	private Long totSellamnt; // 총상금액
	private Long firstWinamnt; //1등 상금액
	private String returnValue; // 요청결과, "success"
	private String drwNoDate;   // 날짜, "2003-11-15"
	
	public Lotto toEntity() {
		return Lotto.builder()
				.number1(drwtNo1)
				.number2(drwtNo2)
				.number3(drwtNo3)
				.number4(drwtNo4)
				.number5(drwtNo5)
				.number6(drwtNo6)
				.bonusNumber(bnusNo)
				.roundNumber(drwNo)
				.firstAmount(String.valueOf(firstWinamnt))
				.totalAmount(String.valueOf(totSellamnt))
				.date(LocalDate.parse(drwNoDate))
				.build();
	}
}
