package com.ktk.lottoPrediction.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktk.lottoPrediction.domain.entity.Lotto;
import com.ktk.lottoPrediction.service.LottoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	private final LottoService lottoService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Lotto> lottos = lottoService.getAllLotto();
		model.addAttribute("lottos", lottos);
		
		return "index";
		
	}
}
