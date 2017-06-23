package edwinderoos.test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import edwinderoos.main.WindMill;

public class TestWindMill{
	private WindMill windMill;
	private float windspeed = 8.5f;
	
	public TestWindMill(){
		windMill = new WindMill(windspeed);	
	}
	@Test
	public void testGetWindspeed() {
		assertEquals(windspeed,windMill.getWindspeed(),0.01);
	}
	@Test
	public void testSetWindspeed() {
		float newValue = 7.1f;
		windMill.setWindspeed(newValue);
		assertEquals(newValue,windMill.getWindspeed(),0.01);
	}
	
	@Test
	public void testCalculatePower() {
		windMill.calculatePower();
		float power = (windspeed/10)* 3000;
		assertEquals(power,windMill.getPower(),0.01);
	}

}
