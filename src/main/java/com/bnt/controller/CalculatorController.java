package com.bnt.controller;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.dto.Calculator;
import com.bnt.dto.CalculatorResponse;
import com.bnt.dto.MinMaxRequest;
import com.bnt.dto.MinMaxResponse;
import com.bnt.repo.CalculatorDao;
import com.bnt.service.CalculatorService;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("calculatorapi/v1/")
@Api(value="calculator")
public class CalculatorController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	private CalculatorService calculatorService;

	@Autowired
	private CalculatorDao calculatorDao;

	@GetMapping("addition")
	public CalculatorResponse getAddition(@RequestParam(name = "number1") Integer num1,
			@RequestParam(name = "number2") Integer num2) {
		CalculatorResponse response = new CalculatorResponse();
		try {
			Integer addition = calculatorService.addition(num1, num2);
			String details = num1 + "+" + num2 + "=" + addition;
			response.setAnswer(addition);
			response.setDetail(details);
			save(num1 + "," + num2, response.toString());
			log.info("CalculatorController addition Request:{}, Response:{}", addition, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());

		}
		return response;
	}

	@GetMapping("subtraction")
	public CalculatorResponse getSubtraction(@RequestParam(name = "number1") Integer num1,
			@RequestParam(name = "number2") Integer num2) {
		CalculatorResponse response = new CalculatorResponse();
		try {
			Integer substraction = calculatorService.subtraction(num1, num2);
			String details = num1 + "-" + num2 + "=" + substraction;
			response.setAnswer(substraction);
			response.setDetail(details);
			// save to the database
			save(num1 + "," + num2, response.toString());
			log.info("CalculatorController substraction Request:{}, Response:{}", substraction, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@GetMapping("multiplication")
	public CalculatorResponse getMultiplication(@RequestParam(name = "number1") Integer num1,
			@RequestParam(name = "number2") Integer num2) {
		CalculatorResponse response = new CalculatorResponse();

		try {
			Integer multiplication = calculatorService.multiplication(num1, num2);
			String details = num1 + "*" + num2 + "=" + multiplication;
			response.setAnswer(multiplication);
			response.setDetail(details);
			// save to the database
			save(num1 + "," + num2, response.toString());
			log.info("CalculatorController multiplication Request:{}, Response:{}", multiplication, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@GetMapping("division")
	public CalculatorResponse getDivision(@RequestParam(name = "number1") Integer num1,
			@RequestParam(name = "number2") Integer num2) {

		CalculatorResponse response = new CalculatorResponse();
		try {
			Integer division = calculatorService.multiplication(num1, num2);
			String details = num1 + "/" + num2 + "=" + division;
			response.setAnswer(division);
			response.setDetail(details);
			// save to the database
			save(num1 + "," + num2, response.toString());
			log.info("CalculatorController division Request:{}, Response:{}", division, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@GetMapping("square/{num}")
	public CalculatorResponse getSquare(@PathVariable(name = "num") Integer num1) {

		CalculatorResponse response = new CalculatorResponse();

		try {
			Integer square = calculatorService.square(num1);
			String details = "square of " + num1 + "=" + square;
			response.setAnswer(square);
			response.setDetail(details);
			// save to the database
			save("num", response.toString());
			log.info("CalculatorController square Request:{}, Response:{}", square, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@GetMapping("squareroot/{num}")
	public CalculatorResponse getSquareRoot(@PathVariable(name = "num") Integer num1) {
		CalculatorResponse response = new CalculatorResponse();
		try {
			Integer squareRoot = calculatorService.squareRoot(num1);
			String details = "square root of " + num1 + "=" + squareRoot;
			response.setAnswer(squareRoot);
			response.setDetail(details);
			// save to the database
			save("num", response.toString());
			log.info("CalculatorController squareRoot Request:{}, Response:{}", squareRoot, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@GetMapping("factorial/{num}")
	public CalculatorResponse getFactorial(@PathVariable(name = "num") Integer num1) {
		CalculatorResponse response = new CalculatorResponse();

		try {
			Integer factorial = calculatorService.factorial(num1);
			String details = num1 + "=" + factorial;
			response.setAnswer(factorial);
			response.setDetail(details);
			// save to the database
			save("num", response.toString());
			log.info("CalculatorController factorial Request:{}, Response:{}", factorial, details);
		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	@PostMapping("minmax")
	public MinMaxResponse minMax(@RequestBody MinMaxRequest request) {
		int[] numbers = request.getNumbers();
		MinMaxResponse response = new MinMaxResponse();
		try {
			response = calculatorService.minMax(numbers);
			log.info("Request: MaxMin, Numbers: {}. Response:{}", Arrays.toString(numbers), response);
			save(Arrays.toString(numbers), response.toString());

		} catch (Exception e) {
			log.info("Exception in CalculatorController" + e.getMessage());
		}
		return response;

	}

	private void save(String request, String response) {
		Calculator calculator = new Calculator();
		calculator.setRequest(request);
		calculator.setResponse(response);
		calculator.setTimestamp(new java.util.Date());
		calculatorDao.save(calculator);
	}

}
