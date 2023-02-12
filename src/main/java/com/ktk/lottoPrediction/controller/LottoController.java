package com.ktk.lottoPrediction.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktk.lottoPrediction.domain.entity.Lotto;
import com.ktk.lottoPrediction.service.LottoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/lottos")
@RequiredArgsConstructor
public class LottoController {
	private final LottoService lottoService;
	
	@GetMapping
	public List<Lotto> getAll(){
		return lottoService.getAllLotto();
	}
	
	@GetMapping("/{roundNumber}")
	public Lotto getByRoundNumber(@PathVariable Integer roundNumber){
		return lottoService.getLotto(roundNumber);
	}
	
}
