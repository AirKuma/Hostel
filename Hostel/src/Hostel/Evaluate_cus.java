package Hostel;

public class Evaluate_cus {
	private int eva_cus_id;
	private int eva_cus_cusrequency;
	private int eva_cus_behavior;
	private int eva_cus_sanitation;
	private int eva_cus_credence;
	private int eva_cus_reflux;
	private String eva_cus_customer;
	private String user_email;

public Evaluate_cus(int eva_cus_id,int eva_cus_cusrequency,int eva_cus_behavior,int eva_cus_sanitation,int eva_cus_credence,int eva_cus_reflux,String eva_cus_customer,String user_email){
	this.eva_cus_id = eva_cus_id;
	this.eva_cus_cusrequency = eva_cus_cusrequency;
	this.eva_cus_behavior = eva_cus_behavior;
	this.eva_cus_sanitation = eva_cus_sanitation;
	this.eva_cus_credence = eva_cus_credence;
	this.eva_cus_reflux = eva_cus_reflux;
	this.eva_cus_customer = eva_cus_customer;
	this.user_email = user_email;
}
	public int geteva_cus_id(){
		return eva_cus_id;
	}
	public int geteva_cus_cusrequency(){
		return eva_cus_cusrequency;
	}
	public int geteva_cus_behavior(){
		return eva_cus_behavior;
	}
	public int geteva_cus_sanitation(){
		return eva_cus_sanitation;
	}
	public int geteva_cus_credence(){
		return eva_cus_credence;
	}
	public int eva_cus_reflux(){
		return eva_cus_reflux;
	}
	public String geteva_cus_customer(){
		return eva_cus_customer;
	}
	public String getuser_email(){
		return user_email;
	}
	public Object get(int attr){
	    switch(attr){
	    	case 0:
	    		return user_email; 
	    	case 1:
	    		return eva_cus_cusrequency; 
	    	case 2:
	    		return eva_cus_behavior;
	    	case 3:
	    		return eva_cus_sanitation;
	    	case 4:
	    		return eva_cus_credence;
	    	case 5:
	    		return eva_cus_reflux;
	    	case 6:
	    		return eva_cus_customer;	
	    	default:
	    		return "";
	    	}
	    }
}
