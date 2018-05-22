package DBHostel;

import java.sql.*;
import java.util.*;

import Hostel.*;

public class DBevaluate_cus extends DBcore{
	
	public static final String[] TITLES={"民宿名稱","客戶"};
	public static final String[] TITLES2={"客戶","住房頻率","品性行為","衛生習慣","信用程度","住客回流率","顧客行為"};
	
public void createcuseva(Evaluate_cus cusevaData,String hostel_name) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Evaluate_cus(eva_cus_cusrequency,eva_cus_behavior,eva_cus_sanitation,eva_cus_credence,eva_cus_reflux,eva_cus_customer,user_email,hostel_name) VALUES(?,?,?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setInt(1,cusevaData.geteva_cus_cusrequency());
	      st.setInt(2,cusevaData.geteva_cus_behavior());	      
	      st.setInt(3,cusevaData.geteva_cus_sanitation());	
	      st.setInt(4,cusevaData.geteva_cus_credence());	
	      st.setInt(5,cusevaData.eva_cus_reflux());
	      st.setString(6,cusevaData.geteva_cus_customer());
	      st.setString(7,cusevaData.getuser_email());
	      st.setString(8,hostel_name);
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
	public boolean isEvaluateCus(String hostel_name,String user_email) throws Exception{
		boolean status=true;  
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Evaluate_cus where user_email=? and hostel_name=?");
	      st.setString(1,user_email);  
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
	public List<Hostel> getEvaCus(String user_email) throws Exception{
	  	
	  	List<Hostel> allEvaCus = new ArrayList<Hostel>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT distinct Booking.user_email,hostel_name FROM BedandBreakfast,Booking,Room where BedandBreakfast.user_email = ? and BedandBreakfast.hostel_id=Room.hostel_id and Room.room_id = Booking.room_id");
	      st.setString(1,user_email);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allEvaCus.add(getEvaCus(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allEvaCus;	
	  }
	public Hostel getEvaCus(ResultSet rec) throws Exception {
		try {
		  String hostel_name = rec.getString("hostel_name");
		  String user_email = rec.getString("user_email");
		  return new Hostel (0,hostel_name,"","","","",user_email,"","");
		} 
		catch (Exception e) {
		  throw e;
			}
		}
public List<Evaluate_cus> getAllEvaluateCus(String hostel_name) throws Exception{
	  	
	  	List<Evaluate_cus> allcuseva = new ArrayList<Evaluate_cus>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Evaluate_cus WHERE hostel_name = ?");
	      st.setString(1,hostel_name);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allcuseva.add(getalleva_cus(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allcuseva;		
	  }
	public Evaluate_cus getalleva_cus(ResultSet rec) throws Exception {
		try {
		  int eva_cus_cusrequency = rec.getInt("eva_cus_cusrequency");
		  int eva_cus_behavior = rec.getInt("eva_cus_behavior");
		  int eva_cus_sanitation = rec.getInt("eva_cus_sanitation");
		  int eva_cus_credence = rec.getInt("eva_cus_credence");
		  int eva_cus_reflux = rec.getInt("eva_cus_reflux");
		  String eva_cus_customer = rec.getString("eva_cus_customer");
		  String user_email = rec.getString("user_email");
		  return new Evaluate_cus (0,eva_cus_cusrequency,eva_cus_behavior,eva_cus_sanitation,eva_cus_credence,eva_cus_reflux,eva_cus_customer,user_email);
		} 
		catch (Exception e) {
		  throw e;
			}
		}

}
