package com.bnt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.dto.Calculator;
import com.bnt.dto.MinMaxResponse;

public interface CalculatorDao extends JpaRepository<Calculator, Integer> {

	void save(MinMaxResponse minMaxResponse);

}
