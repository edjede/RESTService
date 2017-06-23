package edwinderoos.main;

public class Average {
	private float value1;
	private float value2;
	private float average;
	
	public Average(float value1,float value2){
		this.value1 = value1;
		this.value2 = value2;
		
	}
	public void calculateAverage(){
		average = (value1+value2)/2;
	}
	
	public float getValue1() {
		return value1;
	}
	public void setValue1(float value1) {
		this.value1 = value1;
	}
	public float getValue2() {
		return value2;
	}
	public void setValue2(float value2) {
		this.value2 = value2;
	}
	public float getAverage() {
		return average;
	}


}
