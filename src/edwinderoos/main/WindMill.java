package edwinderoos.main;

public class WindMill {
	private float windspeed;
	private float power;
	
	public WindMill(float windspeed){
		this.windspeed = windspeed;
	}
	public float getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(float windspeed) {
		this.windspeed = windspeed;
	}
	public float getPower() {
		return power;
	}
	public void calculatePower(){
		if(windspeed>25||windspeed<0){
			power = 0;
		}
		else if (windspeed>10) {
			power = 3000;
		}
		else {
			power = (windspeed/10)* 3000;
		}
	}

}
