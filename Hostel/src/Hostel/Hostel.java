package Hostel;

public class Hostel {
	private int hostel_id;
	private String hostel_name;
	private String hostel_phone;
	private String hostel_address;
	private String hostel_server;
	private String hostel_payway;
	private String user_email;
	private String hostel_img;
	private String hostel_deposit;

public Hostel(int hostel_id,String hostel_name,String hostel_phone,String hostel_address,String hostel_server,String hostel_payway,String user_email,String hostel_deposit,String hostel_img){
	this.hostel_id = hostel_id;
	this.hostel_name = hostel_name;
	this.hostel_phone = hostel_phone;
	this.hostel_address = hostel_address;
	this.hostel_server = hostel_server;
	this.hostel_payway = hostel_payway;
	this.user_email = user_email;
	this.hostel_deposit = hostel_deposit;
	this.hostel_img = hostel_img;
}
public Hostel(){
    this.hostel_id = 0;
    this.hostel_name = "NA";
    this.hostel_phone = "NA";
    this.hostel_address = "NA";
    this.hostel_server = "NA";
    this.hostel_payway = "NA";
    this.user_email = "NA";  
    this.hostel_deposit = "NA";
    this.hostel_img = "NA";
}
	public int gethostel_id(){
		return hostel_id;
	}
	public String gethostel_name(){
		return hostel_name;
	}
	public String gethostel_phone(){
		return hostel_phone;
	}
	public String gethostel_address(){
		return hostel_address;
	}
	public String gethostel_server(){
		return hostel_server;
	}
	public String gethostel_payway(){
		return hostel_payway;
	}
	public String getuser_email(){
		return user_email;
	}
	public String gethostel_deposit(){
		return hostel_deposit;
	}
	public String gethostel_img(){
		return hostel_img;
	}
	public Object get(int attr){
    	switch(attr){
    	case 0:
    		return hostel_id;
    	case 1:
    		return hostel_name;	
    	case 2:
    		return hostel_address;
    	case 3:
    		return hostel_phone;	
    	case 4:
    		return hostel_server;
    	case 5:
    		return hostel_payway;
    	case 6:
    		return user_email;
    	case 7:
    		return hostel_img;	
    	case 8:
    		return hostel_deposit;		
    	default:
    		return "";
    	}
    }
	public Object get1(int attr){
    	switch(attr){
    	case 0:
    		return hostel_name;
    	case 1:
    		return user_email;		
    	default:
    		return "";
    	}
    }
}
