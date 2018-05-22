package DBHostel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Hostel.*;

public class DBhostel extends DBcore{
	
	public static final String[] TITLES={"民宿編號","民宿名稱","民宿地址"};
	
public void createhostel(Hostel hosData) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into BedandBreakfast(hostel_name,hostel_phone,hostel_address,hostel_server,hostel_payway,hostel_img,hostel_deposit,user_email) VALUES(?,?,?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setString(1,hosData.gethostel_name());
	      st.setString(2,hosData.gethostel_phone());	      
	      st.setString(3,hosData.gethostel_address());	
	      st.setString(4,hosData.gethostel_server());	
	      st.setString(5,hosData.gethostel_payway());
	      st.setString(6,hosData.gethostel_img());
	      st.setString(7,hosData.gethostel_deposit());
	      st.setString(8,hosData.getuser_email());
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
public void updatehostel(Hostel hosData,String hostel_id) throws Exception {
    
  	try {
      Connection conn = makeConnection();
      String SQL = "UPDATE BedandBreakfast SET hostel_phone = ?,hostel_server = ? ,hostel_payway = ? ,hostel_deposit = ? ,hostel_img = ? WHERE hostel_id = ?";
      PreparedStatement st = conn.prepareStatement(SQL);
      st.setString(1,hosData.gethostel_phone());	      	
      st.setString(2,hosData.gethostel_server());	
      st.setString(3,hosData.gethostel_payway());	
      st.setString(4,hosData.gethostel_deposit());
      st.setString(5,hosData.gethostel_img());
      st.setInt(6,Integer.parseInt(hostel_id));
      st.executeUpdate();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
} 
public boolean isAvailable(Date date,int hostel_id) throws Exception{
	boolean status=true;  
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Booking,Room,BedandBreakfast where order_date=? and BedandBreakfast.hostel_id=? and Booking.room_id = Room.room_id and Room.hostel_id = BedandBreakfast.hostel_id");
      st.setDate(1,date);  
      st.setInt(2,hostel_id);  
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
public boolean isowner(String user_email) throws Exception{
	boolean status=true;  
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where user_email = ?");
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
public String getHostelDeposit(String hostel_id) throws Exception{  
  	
  	String deposit = "";
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_id = ?");
      st.setString(1,hostel_id);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  deposit = rec.getString("hostel_deposit");
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return deposit;
  }
public List<Hostel> getAllHostel() throws Exception{
  	
  	List<Hostel> allHostel = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast");
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  allHostel.add(getHostel(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return allHostel;	
  }
public List<Hostel> getLocalHostel(String hostel_adderss) throws Exception{
  	
  	List<Hostel> localHostel = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_address like ?");
      st.setString(1, "%"+hostel_adderss+"%");
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  localHostel.add(getHostel(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return localHostel;	
  }
public List<Hostel> getKeyHostel(String hostel_key) throws Exception{
  	
  	List<Hostel> keyHostel = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_address like ? or hostel_name like ?");
      st.setString(1, "%"+hostel_key+"%");
      st.setString(2, "%"+hostel_key+"%");
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  keyHostel.add(getHostel(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return keyHostel;	
  }
public List<Hostel> getHostel(String hostel_id) throws Exception{
  	
  	List<Hostel> hostel = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_id = ?");
      st.setString(1,hostel_id);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  hostel.add(getHostel(rec));
      }
   
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return hostel;	
  }
public List<Hostel> getMyHostel(String user_email) throws Exception{
  	
  	List<Hostel> hostel = new ArrayList<Hostel>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where user_email = ?");
      st.setString(1,user_email);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  hostel.add(getHostel(rec));
      }
   
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return hostel;	
  }

public Hostel getHostel(ResultSet rec) throws Exception {
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
public boolean isrehostel(String hostel_adderss,String hostel_name) throws Exception{
	boolean status=true;  
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_address = ? or hostel_name = ?");
      st.setString(1,hostel_adderss);   
      st.setString(2,hostel_name);
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
