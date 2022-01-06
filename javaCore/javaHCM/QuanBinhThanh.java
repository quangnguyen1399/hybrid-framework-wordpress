package javaHCM;

public class QuanBinhThanh {
	
	private String street = "D2";
	
	
	// Phuong thuc (Ham/ method) -> setter(gán dữ liệu)
	private void setStreet(String newStreet) {
		street = newStreet;
	}
	
	// Phuong thuc (Ham/ method) -> getter(lấy dữ liệu)
	private String getStreet() {
		return street;
	}
	
	String school = "Hutech";
	void setSchool(String school) {
		this.school = school;
	}
	String getSchool() {
		return this.school;
	}
	
	protected String food = "Chân gà";
	protected void setFood(String food) {
		this.food = food;
	}
	protected String getfood() {
		return this.food;
	}
	public String drinks = "coca";
	public void setDrinks(String drinks) {
		this.drinks = drinks;
	}
	public String getDrinks() {
		return this.drinks;
	}

}
