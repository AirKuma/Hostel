package Hostel;

public class Collection {
	private String col_id;
	private String user_email;
	private int hostel_id;
	
public Collection(String col_id,String user_email,int hostel_id){
	this.col_id = col_id;
	this.user_email = user_email;
	this.hostel_id = hostel_id;
}
	public String getcol_id(){
		return col_id;
	}
	public String getuser_email(){
		return user_email;
	}
	public int gethostel_id(){
		return hostel_id;
	}
	public Object get(int attr){
    	switch(attr){
    	case 0:
    		return col_id;
    	case 1:
    		return user_email;
    	case 2:
    		return hostel_id;
    	default:
    		return "";
    	}
    }
}
