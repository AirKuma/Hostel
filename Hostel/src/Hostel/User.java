package Hostel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class User {
	private String user_id;
	private String user_email;
	private String user_name;
	private String user_password;
	private String user_phone;
	private String user_address;
	private String user_IDnumber;
	private String user_gender;
	private Date user_birthday ;
	private String user_nationality;
	private String user_passport;
	
public User(String user_id,String user_email ,String user_name, String user_password, String user_phone, String user_address,String user_IDnumber,String user_gender,Date user_birthday,String user_nationality,String user_passport){
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_address = user_address;     
        this.user_IDnumber = user_IDnumber;     
        this.user_gender = user_gender;     
        this.user_birthday = user_birthday;     
        this.user_nationality = user_nationality;     
        this.user_passport = user_passport;     
}
public User(){
    this.user_id = "NA";
    this.user_email = "NA";
    this.user_name = "NA";
    this.user_password = "NA";
    this.user_phone = "NA";
    this.user_address = "NA";
    this.user_IDnumber = "NA"; 
    this.user_gender = "NA";   
    this.user_birthday = null;   
    this.user_nationality = "NA";   
    this.user_passport = "NA";   
}
	public String getuser_id(){
		return user_id;
	}
	public String getuser_email(){
		return user_email;
	}
	public String getuser_name(){
		return user_name;
	}
	public String getuser_password(){
		return md5(user_password);
	}
	public String getuser_phone(){
		return user_phone;
	}
	public String getuser_address(){
		return user_address;
	}
	public String getuser_IDnumber(){
		return user_IDnumber;
	}
	public String getuser_gender(){
		return user_gender;
	}
	public Date user_birthday(){
		return user_birthday;
	}
	public String getuser_nationality(){
		return user_nationality;
	}
	public String getuser_passport(){
		return user_passport;
	}
	public static String md5(String input) {
	        
	        String md5 = null;
	         
	        if(null == input) return null;
	         
	        try {
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	        
	        digest.update(input.getBytes(), 0, input.length());
	 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e) {
	 
	            e.printStackTrace();
	        }
	        return md5;
	}
	
}
