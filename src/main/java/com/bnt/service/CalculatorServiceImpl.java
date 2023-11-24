package com.bnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bnt.dto.MinMaxResponse;
import com.bnt.repo.CalculatorDao;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	CalculatorDao calculatorDao;

	@Override

	@Cacheable(value = "CalculatorCache", key = "'addition:' + #num1 + ',' + #num2", unless = "#result == null")
	public Integer addition(Integer num1, Integer num2) {
		return num1 + num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'substration:' + #num1 + ',' + #num2", unless = "#result == null")
	public Integer subtraction(Integer num1, Integer num2) {
		return num1 - num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'multiplication:' + #num1 + ',' + #num2", unless = "#result == null")
	public Integer multiplication(Integer num1, Integer num2) {

		return num1 * num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'division:' + #num1 + ',' + #num2", unless = "#result == null")
	public double division(Integer num1, Integer num2) throws Exception {
		double answer = 0;
		try {
			answer = Double.valueOf(num1) / Double.valueOf(num2);
		} catch (Exception e) {
			throw e;
		}
		return answer;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'square:' + #num1 + ',' + #num2", unless = "#result == null")
	public Integer square(Integer num1) {
		return num1 * num1;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'squareRoot:' + #num1", unless = "#result == null")

	public Integer squareRoot(Integer num1) {
		return (int) Math.sqrt(num1);
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'factorial:' + #num1", unless = "#result == null")
	public Integer factorial(Integer num1) {
		int answer = 1;
		for (int i = 1; i <= num1; i++)
			answer *= i;
		return answer;

	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'minMax:' + #numbers", unless = "#result == null")
	public MinMaxResponse minMax(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException("Input array is empty");
		}

		int max = numbers[0];
		int min = numbers[0];

		for (int num : numbers) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}

		return new MinMaxResponse(min, max);

	}

}
