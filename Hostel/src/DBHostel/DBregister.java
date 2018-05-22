package DBHostel;

import java.sql.*;

import Hostel.*;


public class DBregister extends DBcore{
	public void user(User userData) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into User(user_email,user_name,user_password,user_phone,user_address,user_IDnumber,user_gender,user_birthday,user_nationality,user_passport) VALUES(?,?,?,?,?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setString(1,userData.getuser_email());
	      st.setString(2,userData.getuser_name());	      
	      st.setString(3,userData.getuser_password());	
	      st.setString(4,userData.getuser_phone());	
	      st.setString(5,userData.getuser_address());	
	      st.setString(6,userData.getuser_IDnumber());	
	      st.setString(7,userData.getuser_gender());	
	      st.setDate(8,userData.user_birthday());	
	      st.setString(9,userData.getuser_nationality());	
	      st.setString(10,userData.getuser_passport());	
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
	public boolean isInvalidUseremail(String user_email) throws Exception{
		boolean status=true;  
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM User where user_email=? ");
	      st.setString(1,user_email);   
	      ResultSet rec = st.executeQuery();
	      status=rec.next();  
	
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 		
		return status;  
	  }
}
