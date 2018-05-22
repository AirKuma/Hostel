package DBHostel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Hostel.*;


public class DBmessage extends DBcore
{
	public static final String[] TITLES={"寄信者","寄信日期","主旨","內容"};
	
public void message(Message meaData) throws Exception {
	    
	  	try {
	      Connection conn = makeConnection();
	      String SQL = "Insert into Message(message_from,message_to,message_time,message_subject,message_context) VALUES(?,?,?, ?, ?)";
	      PreparedStatement st = conn.prepareStatement(SQL);
	      st.setString(1,meaData.getmessage_from());
	      st.setString(2,meaData.getmessage_to());	      
	      st.setDate(3,meaData.getmessage_time());
	      st.setString(4,meaData.getmessage_subject());
	      st.setString(5,meaData.getmessage_context());
	      st.executeUpdate();
	      st.close();
	      conn.close();
	    } 
	    catch (Exception e) {
	      throw e;
	    } 
  } 
public List<Message> getAllMessage(String user_email) throws Exception{
  	
  	List<Message> allMessage = new ArrayList<Message>();
	try {
      Connection conn = makeConnection();
      PreparedStatement st = conn.prepareStatement("SELECT * FROM Message WHERE message_to = ? ORDER BY message_id DESC");
      st.setString(1,user_email);
      ResultSet rec = st.executeQuery();
      while(rec.next()) {
    	  allMessage.add(getMessage(rec));
      } 
      rec.close();
      st.close();
      conn.close();
    } 
    catch (Exception e) {
      throw e;
    } 
    return allMessage;
	
  }
public Message getMessage(ResultSet rec) throws Exception {
try {
  String message_id = ""+rec.getInt("message_id");
  String message_from = rec.getString("message_from");
  String message_to = rec.getString("message_to");
  Date message_time = rec.getDate("message_time");
  String message_subject = rec.getString("message_subject");
  String message_context = rec.getString("message_context");
  return new Message (message_id,message_from,message_to,message_time,message_subject,message_context);
} 
catch (Exception e) {
  throw e;
	}
}
}
