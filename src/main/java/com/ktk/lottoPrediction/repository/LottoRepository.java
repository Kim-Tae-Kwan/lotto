package com.ktk.lottoPrediction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktk.lottoPrediction.domain.entity.Lotto;

@Repository
public interface LottoRepository extends JpaRepository<Lotto, Long> {
	@Query("SELECT MAX(L.roundNumber) FROM Lotto L")
	Integer findMaxRoundNumber();

	Lotto findByRoundNumber(Integer roundNumber);
}
