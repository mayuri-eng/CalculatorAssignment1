package com.bnt.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bnt.dto.CalculatorResponse;
import com.bnt.dto.MinMaxRequest;
import com.bnt.dto.MinMaxResponse;
import com.bnt.repo.CalculatorDao;
import com.bnt.service.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

	@Mock
	private CalculatorService calculatorService;

	@Mock
	private CalculatorDao calculatorDao;

	@InjectMocks
	private CalculatorController calculatorController;

	@Test
	public void testGetAddition() {
		Mockito.when(calculatorService.addition(2, 3)).thenReturn(5);
		CalculatorResponse response = calculatorController.getAddition(2, 3);
		assertEquals(5, response.getAnswer());
		assertEquals("2+3=5", response.getDetail());
	}

	@Test
	public void testGetSubstraction() {
		Mockito.when(calculatorService.subtraction(3, 5)).thenReturn(2);
		CalculatorResponse response = calculatorController.getSubtraction(3, 5);
		assertEquals(2, response.getAnswer());
		assertEquals("3-5=2", response.getDetail());
	}

	@Test
	public void testGetMultiplication() {
		Mockito.when(calculatorService.multiplication(3, 5)).thenReturn(15);
		CalculatorResponse response = calculatorController.getMultiplication(3, 5);
		assertEquals(15, response.getAnswer());
		assertEquals("3*5=15", response.getDetail());
	}

	@Test
	public void testGetSquare() {
		Mockito.when(calculatorService.square(4)).thenReturn(16);
		CalculatorResponse response = calculatorController.getSquare(4);
		assertEquals(16, response.getAnswer());
		assertEquals("square of 4=16", response.getDetail());
	}

	@Test
	public void testGetSquareRoot() {
		Mockito.when(calculatorService.squareRoot(25)).thenReturn(5);
		CalculatorResponse response = calculatorController.getSquareRoot(25);
		assertEquals(5, response.getAnswer());
		assertEquals("square root of 25=5", response.getDetail());
	}

	@Test
	public void testGetFactorial() {
		Mockito.when(calculatorService.factorial(4)).thenReturn(24);
		CalculatorResponse response = calculatorController.getFactorial(4);
		assertEquals(24, response.getAnswer());
		assertEquals("4=24", response.getDetail());
	}

	@Test
	public void testMinMax() {
		MinMaxRequest request = new MinMaxRequest(new int[] { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 });
		Mockito.when(calculatorService.minMax(request.getNumbers())).thenReturn(new MinMaxResponse(1, 9));
		MinMaxResponse response = calculatorController.minMax(request);
		assertEquals(1, response.getMin());
		assertEquals(9, response.getMax());
	}

}