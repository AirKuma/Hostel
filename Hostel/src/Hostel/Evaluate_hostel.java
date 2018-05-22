package Hostel;

public class Evaluate_hostel {
	private int eva_hostel_id;
	private double eva_hostel_server;
	private double eva_hostel_location;
	private double eva_hostel_environment;
	private double eva_hostel_food;
	private double eva_hostel_facility;
	private String eva_hostel_feedback;
	private String user_email;

public Evaluate_hostel(int eva_hostel_id,double eva_hostel_server,double eva_hostel_location,double eva_hostel_environment,double eva_hostel_food,double eva_hostel_facility,String eva_hostel_feedback,String user_email){
	this.eva_hostel_id = eva_hostel_id;
	this.eva_hostel_server = eva_hostel_server;
	this.eva_hostel_location = eva_hostel_location;
	this.eva_hostel_environment = eva_hostel_environment;
	this.eva_hostel_food = eva_hostel_food;
	this.eva_hostel_facility = eva_hostel_facility;
	this.eva_hostel_feedback = eva_hostel_feedback;
	this.user_email = user_email;
}
	public int geteva_hostel_id(){
		return eva_hostel_id;
	}
	public double geteva_hostel_server(){
		return eva_hostel_server;
	}
	public double geteva_hostel_location(){
		return eva_hostel_location;
	}
	public double geteva_hostel_environment(){
		return eva_hostel_environment;
	}
	public double geteva_hostel_food(){
		return eva_hostel_food;
	}
	public double geteva_hostel_facility(){
		return eva_hostel_facility;
	}
	public String geteva_hostel_feedback(){
		return eva_hostel_feedback;
	}
	public String getuser_email(){
		return user_email;
	}
	public Object get(int attr){
	    switch(attr){
	    	case 0:
	    		return user_email; 
	    	case 1:
	    		return eva_hostel_server; 
	    	case 2:
	    		return eva_hostel_location;
	    	case 3:
	    		return eva_hostel_environment;
	    	case 4:
	    		return eva_hostel_food;
	    	case 5:
	    		return eva_hostel_facility;
	    	case 6:
	    		return eva_hostel_feedback;	
	    	default:
	    		return "";
	    	}
	    }
}
