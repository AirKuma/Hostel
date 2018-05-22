package DBHostel;

import java.sql.*;

public class DBlogin extends DBcore{
	
	public boolean Validlogin(String user_email,String user_password) throws Exception{
		boolean status=false;  
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM User where user_email=? and user_password=?");
	      st.setString(1,user_email);  
	      st.setString(2,user_password);  
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
	public String getpassword(String user_email) throws Exception{
		String password = "";  
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM User where user_email = ?");
	      st.setString(1,user_email);   
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  password=rec.getString("user_password");
	      }
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 		
		return password;  
	  }
}
