package DBHostel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Hostel.Collection;
import Hostel.Hostel;
//testtest
public class DBcollect extends DBcore{
	public static final String[] TITLES={"民宿編號","民宿名稱","民宿地址"};
public void collect(Collection colData) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Collection(user_email,hostel_id) VALUES(?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setString(1,colData.getuser_email());
	      st.setInt(2,colData.gethostel_id());	      
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
public void cancelcollect(String user_email,String hostel_id) throws Exception {
    
  	try {
      Connection conn = makeConnection();
      String SQL = "Delete from Collection where user_email = ? and hostel_id = ?";
      PreparedStatement st = conn.prepareStatement(SQL);
      st.setString(1,user_email);	     	
      st.setInt(2,Integer.parseInt(hostel_id));
      st.executeUpdate();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
} 
public boolean iscollect(String user_email,String hostel_id) throws Exception{
	boolean status=false;  
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Collection where user_email=? and hostel_id=?");
      st.setString(1,user_email);  
      st.setInt(2,Integer.parseInt(hostel_id));
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
public List<Hostel> getAllCollect(String user_email) throws Exception{
  	
  	List<Hostel> allCollect = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast,Collection WHERE Collection.user_email = ? and BedandBreakfast.hostel_id = Collection.hostel_id");
      st.setString(1,user_email);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  allCollect.add(getCollect(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return allCollect;
  }
public Hostel getCollect(ResultSet rec) throws Exception {
try {
  int hostel_id = rec.getInt("hostel_id");
  String hostel_name = rec.getString("hostel_name");
  String hostel_phone = rec.getString("hostel_phone");
  String hostel_address = rec.getString("hostel_address");
  String hostel_server = rec.getString("hostel_server");
  String hostel_payway = rec.getString("hostel_payway");
  String user_email = rec.getString("user_email");
  String hostel_deposit = rec.getString("hostel_deposit");
  String hostel_img = rec.getString("hostel_img");
  return new Hostel (hostel_id,hostel_name,hostel_phone,hostel_address,hostel_server,hostel_payway,user_email,hostel_deposit,hostel_img);
} 
catch (Exception e) {
  throw e;
	}
}
}
