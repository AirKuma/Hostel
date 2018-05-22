package DBHostel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Hostel.*;

public class DBorder extends DBcore{
	
	public static final String[] TITLES={"民宿民稱","房間名稱","房間人數","訂房日期"};
	public static final String[] TITLES2={"訂單群組編號","房間編號","客戶","是否已付款","是否已入住"};
	public static final String[] TITLES3={"房間名稱","房間人數","訂房日期","遊客"};
	
public void order(Date order_time,int order_group_id,boolean order_paid,boolean order_check_in,int room_id,String user_email) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Booking(order_time,order_date,order_group_id,order_paid,order_check_in,room_id,user_email) VALUES(Date(),?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setDate(1,order_time);
	      st.setInt(2,order_group_id);
	      st.setBoolean(3,order_paid);
	      st.setBoolean(4,order_check_in);
	      st.setInt(5,room_id);	
	      st.setString(6,user_email);	
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
public void cancelorder(String order_group_id) throws Exception {
    
  	try {
      Connection conn = makeConnection();
      String SQL = "Delete from Booking where order_group_id = ?";
      PreparedStatement st = conn.prepareStatement(SQL);	     	
      st.setInt(1,Integer.parseInt(order_group_id));
      st.executeUpdate();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
} 
public void updateorder(Boolean order_paid,Boolean order_check_in,String order_group_id) throws Exception {
    
  	try {
      Connection conn = makeConnection();
      String SQL = "UPDATE Booking SET order_paid = ?,order_check_in = ? WHERE order_group_id = ?";
      PreparedStatement st = conn.prepareStatement(SQL);
      st.setBoolean(1,order_paid);
      st.setBoolean(2,order_check_in);	      	
      st.setInt(3,Integer.parseInt(order_group_id));
      st.executeUpdate();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
} 
public Boolean getcheckin(String hostel_name,String user_email) throws Exception{
	Boolean checkin = false;
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Booking,Room,BedandBreakfast where hostel_name=? and Booking.user_email=? and BedandBreakfast.hostel_id = Room.hostel_id and Room.room_id = Booking.room_id");
      st.setString(1,hostel_name);  
      st.setString(2,user_email);  
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  checkin=rec.getBoolean("order_check_in");
      } 

      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 		
	return checkin;  
  }
	public List<Order> getAllOrder(String user_email) throws Exception{
	  	
	  	List<Order> allOrder = new ArrayList<Order>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT distinct order_group_id,BedandBreakfast.user_email,hostel_name,room_name,room_peoplenum,order_date FROM BedandBreakfast,Booking,Room WHERE Booking.user_email = ? and Room.room_id = Booking.room_id and BedandBreakfast.hostel_id = Room.hostel_id");
	      st.setString(1,user_email);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allOrder.add(getOrder(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allOrder;
	  }
public List<Order> getAllCusOrder(String hostel_id) throws Exception{
	  	
	  	List<Order> allcusOrder = new ArrayList<Order>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT distinct order_group_id,Booking.user_email,hostel_name,room_name,room_peoplenum,order_date FROM BedandBreakfast,Booking,Room,User WHERE User.user_email = Booking.user_email and Room.room_id = Booking.room_id and BedandBreakfast.hostel_id = Room.hostel_id and BedandBreakfast.hostel_id = ?");
	      st.setInt(1,Integer.parseInt(hostel_id));
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allcusOrder.add(getOrder(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allcusOrder;
	  }
public List<Integer> getOrderId() throws Exception{
	  	
	  	List<Integer> Orderid = new ArrayList<Integer>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Booking");
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  Orderid.add(rec.getInt("order_group_id"));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return Orderid;
	  }
	public Order getOrder(ResultSet rec) throws Exception {
	try {
	  String owner = rec.getString("user_email");	
	  int order_group_id = rec.getInt("order_group_id");
	  String hostel_name = rec.getString("hostel_name");	
	  String room_name = rec.getString("room_name");
	  int room_peoplenum = rec.getInt("room_peoplenum");
	  Date order_date = rec.getDate("order_date");
	  return new Order (owner,order_group_id,hostel_name,room_name,room_peoplenum,order_date);
	} 
	catch (Exception e) {
	  throw e;
		}
	}
public List<Order> getAllOrderstatus(String hostel_id) throws Exception{
	  	
	  	List<Order> allOrderstatus = new ArrayList<Order>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT distinct order_group_id,Room.room_id,Booking.user_email,order_paid,order_check_in FROM BedandBreakfast,Booking,Room WHERE BedandBreakfast.hostel_id = ? and Room.room_id = Booking.room_id and BedandBreakfast.hostel_id = Room.hostel_id");
	      st.setString(1,hostel_id);
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  allOrderstatus.add(getOrderstatus(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return allOrderstatus;
	  }
public List<Order> getAllOrderstatus2(String hostel_id,String order_group_id) throws Exception{
  	
  	List<Order> allOrderstatus = new ArrayList<Order>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT distinct order_group_id,Room.room_id,Booking.user_email,order_paid,order_check_in FROM BedandBreakfast,Booking,Room WHERE BedandBreakfast.hostel_id = ? and order_group_id = ? and Room.room_id = Booking.room_id and BedandBreakfast.hostel_id = Room.hostel_id");
      st.setString(1,hostel_id);
      st.setInt(2,Integer.parseInt(order_group_id));
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  allOrderstatus.add(getOrderstatus(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return allOrderstatus;
  }
public Order getOrderstatus(ResultSet rec) throws Exception {
	try {	
	  int order_group_id = rec.getInt("order_group_id");
	  Boolean order_paid = rec.getBoolean("order_paid");
	  Boolean order_check_in = rec.getBoolean("order_check_in");	
	  int room_id = rec.getInt("room_id");
	  String user_email = rec.getString("user_email");
	  
	  return new Order (0,null,order_group_id,order_paid,order_check_in,room_id,user_email);
	} 
	catch (Exception e) {
	  throw e;
		}
	}
}
