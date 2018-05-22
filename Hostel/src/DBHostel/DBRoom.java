package DBHostel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Hostel.*;

public class DBRoom extends DBcore{
	
	public static final String[] TITLES={"房間名稱","房間圖片","房間簡介","房間人數","平日價格","假日價格"};
	
public void createroom(Room roomData,String hostel_id) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Room(room_name,room_img,room_describe,room_peoplenum,room_weekdayprice,room_holidayprice,hostel_id) VALUES(?,?,?,?,?,?,?)";
	      PreparedStatement st = conn.prepareStatement(SQL);	
	      st.setString(1,roomData.getroom_name());
	      st.setString(2,roomData.getroom_img());	      
	      st.setString(3,roomData.getroom_describe());	
	      st.setInt(4,roomData.getroom_peoplenum());	
	      st.setInt(5,roomData.getroom_weekdayprice());
	      st.setInt(6,roomData.getroom_holidayprice());
	      st.setInt(7,Integer.parseInt(hostel_id));
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
	public List<Room> GetAllroom(String hostel_id) throws Exception{
	  	
	  	List<Room> thisroom = new ArrayList<Room>();
		try {
	      Connection conn = makeConnection();
	      PreparedStatement st = conn.prepareStatement("SELECT * FROM Room where hostel_id = ?");
	      st.setInt(1,Integer.parseInt(hostel_id));
	      ResultSet rec = st.executeQuery();
	      while(rec.next()) {
	    	  thisroom.add(getroom(rec));
	      } 
	      rec.close();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
	    return thisroom;	
	  }
public List<Room> Getthisroom(int room_id) throws Exception{    //實驗2
  	
  	List<Room> thisroom = new ArrayList<Room>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Room where room_id = ?");
      st.setInt(1,room_id);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  thisroom.add(getroom(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return thisroom;	
  }
public Room getroom(ResultSet rec) throws Exception {
	try {
	  int room_id = rec.getInt("room_id");
	  String room_name = rec.getString("room_name");
	  String room_img = rec.getString("room_img");
	  String room_describe = rec.getString("room_describe");
	  int room_weekdayprice = rec.getInt("room_weekdayprice");
	  int room_holidayprice = rec.getInt("room_holidayprice");
	  int room_peoplenum = rec.getInt("room_peoplenum");
	  return new Room(room_id,room_name,room_img,room_describe,room_peoplenum,room_weekdayprice,room_holidayprice);
	} 
	catch (Exception e) {
	  throw e;
		}
}
public boolean isbooking(Date date,int room_id) throws Exception{
	boolean status=true;  
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Booking where order_date=? and room_id=?");
      st.setDate(1,date);  
      st.setInt(2,room_id);  
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
