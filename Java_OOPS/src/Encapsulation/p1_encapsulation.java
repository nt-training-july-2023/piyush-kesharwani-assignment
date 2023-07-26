package Encapsulation;

// Encapsulation - Encapsulation in Java is a process of wrapping code 
//                and data together into a single unit

class Car{
	private int carNo;
	private String car_model;
	
    // getter for carNo	
	public int getCarNo() {
		return carNo;
	}
	
	// setter for carNo 
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	
	//getter for car_Model
	public String getCar_model() {
		return car_model;
	}
	
	// setter for car_model
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	
}

public class p1_encapsulation {
	public static void main(String[] args) {
	  Car c1 = new Car();
	  c1.setCarNo(3124);
	  c1.setCar_model("BMW x6");
	  
	  System.out.println("The car model is " + c1.getCar_model());
	  System.out.println("The car number is " +  c1.getCarNo());
	}

}
