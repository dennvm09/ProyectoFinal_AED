package model;

public class Neighborhood {

	private String name;
	private String code;
	private double x;
	private double y;
	
	public Neighborhood(String name, String  code) {
		
		this.name = name;
		this.code = code;
		x = 0;
		y = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
