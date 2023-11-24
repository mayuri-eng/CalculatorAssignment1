package com.bnt.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {

	@Test
	public void getId() {
		Calculator calculator = new Calculator();
		Long id = 1L;
		calculator.setId(id);

		assertEquals(id, calculator.getId());
	}

	@Test
	public void getRequest() {
		Calculator calculator = new Calculator();
		String s = "10,20";
		calculator.setRequest("10,20");
		assertEquals("10,20", calculator.getRequest());
	}

	
	@Test
	public void getResponse() {
		Calculator calculator = new Calculator();
		String s = "5";
		calculator.setResponse("5");
		assertEquals("5", calculator.getResponse());
	}

	@Test
	public void additionTest() {
		Calculator calculator = new Calculator(1L, "addition 5 from 10", "5", new Date());
		String s = "Calculator [id=1, request=addition 5 from 10, response=5, timestamp=" + calculator.getTimestamp()
				+ "]";
		assertEquals(s, calculator.toString());
	}

	@Test
	public void substractionTest() {
		Calculator calculator = new Calculator(1L, "Subtract 5 from 10", "5", new Date());
		String s = "Calculator [id=1, request=Subtract 5 from 10, response=5, timestamp=" + calculator.getTimestamp()
				+ "]";
		assertEquals(s, calculator.toString());
	}

	@Test
	public void multiplicationTest() {
		Calculator calculator = new Calculator(1L, "Multiplication 5 from 10", "5", new Date());
		String s = "Calculator [id=1, request=Multiplication 5 from 10, response=5, timestamp="
				+ calculator.getTimestamp() + "]";
		assertEquals(s, calculator.toString());
	}
}
