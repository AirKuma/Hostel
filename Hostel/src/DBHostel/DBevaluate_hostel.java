package DBHostel;

import java.sql.*;
import java.util.*;

import Hostel.*;

public class DBevaluate_hostel extends DBcore{
	
	public static final String[] TITLES={"民宿名稱"};
	public static final String[] TITLES2={"","位置","服務","環境","餐飲","設施"};
	public static final String[] TITLES3={"客戶","位置","服務","環境","餐飲","設施","意見回饋"};
	
public void createhosteleva(Evaluate_hostel cushostelevaData,String hostel_name) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Evaluate_hostel(eva_hostel_server,eva_hostel_location,eva_hostel_environment,eva_hostel_food,eva_hostel_facility,eva_hostel_feedback,user_email,hostel_name) VALUES(?,?,?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setDouble(1,cushostelevaData.geteva_hostel_server());
	      st.setDouble(2,cushostelevaData.geteva_hostel_location());	      
	      st.setDouble(3,cushostelevaData.geteva_hostel_environment());	
	      st.setDouble(4,cushostelevaData.geteva_hostel_food());	
	      st.setDouble(5,cushostelevaData.geteva_hostel_facility());
	      st.setString(6,cushostelevaData.geteva_hostel_feedback());
	      st.setString(7,cushostelevaData.getuser_email());
	      st.setString(8,hostel_name);
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  }
	public boolean isEvaluateHostel(String hostel_name,String user_email) throws Exception{
		boolean status=true;  
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Evaluate_hostel where user_email=? and hostel_name=?");
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
	public List<Hostel> getEvaHostel(String user_email) throws Exception{
	  	
	  	List<Hostel> allEvaHostel = new ArrayList<Hostel>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT distinct hostel_name FROM BedandBreakfast,Booking,Room where Booking.user_email = ? and  BedandBreakfast.hostel_id=Room.hostel_id and Room.room_id = Booking.room_id");
	      st.setString(1,user_email);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allEvaHostel.add(getEvaHostel(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allEvaHostel;	
	  }
	public Hostel getEvaHostel(ResultSet rec) throws Exception {
		try {
		  String hostel_name = rec.getString("hostel_name");
		  return new Hostel (0,hostel_name,"","","","","","","");
		} 
		catch (Exception e) {
		  throw e;
			}
		}
	public List<Evaluate_hostel> getEvaluateHostel(String hostel_name) throws Exception{
	  	
	  	List<Evaluate_hostel> hosteleva = new ArrayList<Evaluate_hostel>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT Avg(eva_hostel_server)as A,AVG(eva_hostel_location) as B,Avg(eva_hostel_environment) as C, Avg(eva_hostel_food) as D,Avg(eva_hostel_facility)as E FROM Evaluate_hostel WHERE hostel_name = ?");
	      st.setString(1,hostel_name);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  hosteleva.add(geteva_hostel(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return hosteleva;		
	  }
	public Evaluate_hostel geteva_hostel(ResultSet rec) throws Exception {
		try {
		  double eva_hostel_server = rec.getDouble("A");
		  double eva_hostel_location = rec.getDouble("B");
		  double eva_hostel_environment = rec.getDouble("C");
		  double eva_hostel_food = rec.getDouble("D");
		  double eva_hostel_facility = rec.getDouble("E");
		  return new Evaluate_hostel (0,eva_hostel_server,eva_hostel_location,eva_hostel_environment,eva_hostel_food,eva_hostel_facility,"","");
		} 
		catch (Exception e) {
		  throw e;
			}
		}
public List<Evaluate_hostel> getAllEvaluateHostel(String hostel_name) throws Exception{
	  	
	  	List<Evaluate_hostel> allhosteleva = new ArrayList<Evaluate_hostel>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Evaluate_hostel WHERE hostel_name = ?");
	      st.setString(1,hostel_name);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allhosteleva.add(getalleva_hostel(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allhosteleva;		
	  }
	public Evaluate_hostel getalleva_hostel(ResultSet rec) throws Exception {
		try {
		  double eva_hostel_server = rec.getDouble("eva_hostel_server");
		  double eva_hostel_location = rec.getDouble("eva_hostel_location");
		  double eva_hostel_environment = rec.getDouble("eva_hostel_environment");
		  double eva_hostel_food = rec.getDouble("eva_hostel_food");
		  double eva_hostel_facility = rec.getDouble("eva_hostel_facility");
		  String eva_hostel_feedback = rec.getString("eva_hostel_feedback");
		  String user_email = rec.getString("user_email");
		  return new Evaluate_hostel (0,eva_hostel_server,eva_hostel_location,eva_hostel_environment,eva_hostel_food,eva_hostel_facility,eva_hostel_feedback,user_email);
		} 
		catch (Exception e) {
		  throw e;
			}
		}
}
