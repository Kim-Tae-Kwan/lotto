package com.ktk.lottoPrediction.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
public class Lotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number1;
	private String number2;
	private String number3;
	private String number4;
	private String number5;
	private String number6;
	private String bonusNumber;
	private String roundNumber;
	private String firstAmount;
	private String totalAmount;
	private LocalDate date;
}
