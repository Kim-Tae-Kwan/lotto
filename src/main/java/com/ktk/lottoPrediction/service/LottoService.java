package com.ktk.lottoPrediction.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ktk.lottoPrediction.domain.entity.Lotto;
import com.ktk.lottoPrediction.repository.LottoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LottoService {
	private final LottoRepository lottoRepository;
	
	public List<Lotto> getAllLotto() {
		return lottoRepository.findAll();
	}
	
	public Lotto getLotto(Integer roundNumber) {
		return lottoRepository.findByRoundNumber(roundNumber);
	}
}
