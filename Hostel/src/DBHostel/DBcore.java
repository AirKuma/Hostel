package DBHostel;

import DBHostel.DBConstants;
import java.sql.*;

public class DBcore implements DBConstants
{

  public Connection makeConnection() throws Exception{
    Connection conn;
    try{      
      Class.forName(DRIVER);
      conn = DriverManager.getConnection(
        URI, USERNAME, PASSWORD);
      return conn;
    } 
    catch (Exception e) {
      throw e;
    } 
  } 
}

