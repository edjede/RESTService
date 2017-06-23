package edwinderoos.test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import edwinderoos.main.Average;

public class TestAverage {
	private Average averageObj;
	private float value1 = 10.5f;
	private float value2 = 30.5f;
	
	public TestAverage(){
		averageObj = new Average(value1,value2);	
	}
	@Test
	public void testGetValue1() {
		assertEquals(value1,averageObj.getValue1(),0.01);
	}
	@Test
	public void testSetValue1() {
		float newValue = 20.0f;
		averageObj.setValue1(newValue);
		assertEquals(newValue,averageObj.getValue1(),0.01);
	}
	@Test
	public void testGetValue2() {
		assertEquals(value2,averageObj.getValue2(),0.01);
	}
	@Test
	public void testSetValue2() {
		float newValue = 20.0f;
		averageObj.setValue2(newValue);
		assertEquals(newValue,averageObj.getValue2(),0.01);
	}
	
	@Test
	public void testcalculateAverage() {
		averageObj.calculateAverage();
		float average = ((value1+value2)/2);
		assertEquals(average,averageObj.getAverage(),0.01);
	}

}
