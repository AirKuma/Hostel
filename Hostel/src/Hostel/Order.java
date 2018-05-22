package Hostel;

import java.sql.Date;

public class Order extends Room{
	private int order_id;
	private Date order_time ;
	private int room_id;
	private String user_email ;
	private String hostel_name;
	private String owner;
	private int order_group_id;
	private boolean order_paid;
	private boolean order_check_in;
	
public Order(String owner,int order_group_id,String hostel_name,String room_name ,int room_peoplenum,Date order_time){
	    this.owner = owner;
		this.order_group_id = order_group_id;
		this.hostel_name = hostel_name;	
		setroom_name(room_name);
		setroom_peoplenum(room_peoplenum);
		this.order_time = order_time;		
}
public Order(int order_id,Date order_time ,int order_group_id,boolean order_paid,boolean order_check_in,int room_id,String user_email){
	this.order_id = order_id;
	this.order_time = order_time;
	this.order_group_id = order_group_id;
	this.order_paid = order_paid;
	this.order_check_in = order_check_in;
	this.room_id = room_id;
	this.user_email = user_email;
}

		public int getorder_id(){
			return order_id;
		}
		public Date getorder_time(){
			return order_time;
		}
		public int getroom_id(){
			return room_id;
		}
		public String getuser_email(){
			return user_email;
		}
		public String getowner(){
			return owner;
		}
		public int getorder_group_id(){
			return order_group_id;
		}
		public Boolean getorder_paid(){
			return order_paid;
		}
		public Boolean getorder_check_in(){
			return order_check_in;
		}
		
		public Object get(int attr){
	    	switch(attr){
	    	case 0:
	    		return hostel_name;	
	    	case 1:
	    		return room_name;
	    	case 2:
	    		return room_peoplenum;
	    	case 3:
	    		return order_time;
	    	default:
	    		return "";
	    	}
	    }
		public Object get1(int attr){
	    	switch(attr){
	    	case 0:
	    		return order_group_id;	
	    	case 1:
	    		return room_id;
	    	case 2:
	    		return user_email;
	    	case 3:
	    		return order_paid;
	    	case 4:
	    		return order_check_in;	
	    	default:
	    		return "";
	    	}
	    }
}
