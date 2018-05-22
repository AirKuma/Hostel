package Hostel;

import java.sql.Date;

public class Message {
	private String message_id;
    private String message_from;
    private String message_to;
    private Date message_time;
    private String message_subject;
    private String message_context;
    
    public Message(String message_id,String message_from,String message_to,Date message_time,String message_subject,String message_context){
        this.message_id = message_id;
        this.message_from = message_from;
        this.message_to = message_to;
        this.message_time = message_time;
        this.message_subject = message_subject;
        this.message_context = message_context;  
    }
    public Message(){
        this.message_id = "NA";
        this.message_from = "NA";
        this.message_to = "NA";
        this.message_time = null;
        this.message_subject = "NA";
        this.message_context = "NA";   
    }
	public String getmessage_id(){
        return message_id;
    }
    public String getmessage_from(){
        return message_from;
    }
    public String getmessage_to(){
    	return message_to;
    }
    public Date getmessage_time(){
		return message_time;
    }
    public String getmessage_subject(){
		return message_subject;
    }
    public String getmessage_context(){
		return message_context;
    }
    public Object get(int attr){
    	switch(attr){
    	case 0:
    		return message_from; 
    	case 1:
    		return message_time;
    	case 2:
    		return message_subject;
    	case 3:
    		return message_context;
    	default:
    		return "";
    	}
    }
}
