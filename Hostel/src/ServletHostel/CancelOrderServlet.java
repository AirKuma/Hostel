package ServletHostel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;
import Hostel.Message;


@WebServlet("/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "orderlist.jsp";   
	private static final String nextJSP2 = "myhostel.jsp";
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order_group_id = request.getParameter("PNO");	
		String hostel_name = request.getParameter("PNO2");	
		String owner = request.getParameter("PNO3");
		String order_date = request.getParameter("PNO4");
		String room_name = request.getParameter("PNO5");
		String roomtype_peoplenum = request.getParameter("PNO6");
		HttpSession session = request.getSession(true);
		String from = (String)session.getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = sdf.format(new Date());	
		java.util.Date date1;
		 java.sql.Date sqlDate=null;
		try {
			date1 = sdf.parse(date);
			sqlDate = new java.sql.Date(date1.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 	 
		DBorder db = new DBorder();
		
		try{
			if(session.getAttribute("cus")==null){
				Message mes = new Message("0",from,owner,sqlDate,hostel_name+"取消預約",order_date+room_name+roomtype_peoplenum+"人房取消預約");
				Message mes1 = new Message("0","系統",from,sqlDate,hostel_name+"取消預約",order_date+room_name+roomtype_peoplenum+"人房已取消預約");
				DBmessage db1 = new DBmessage();
				db1.message(mes);
				db1.message(mes1);
				db.cancelorder(order_group_id);	
				session.removeAttribute("cus");
				response.sendRedirect(nextJSP);	
			}
			else{
				Message mes = new Message("0",from,owner,sqlDate,hostel_name+"取消預約",order_date+room_name+roomtype_peoplenum+"人房取消預約");
				DBmessage db1 = new DBmessage();
				db1.message(mes);
				db.cancelorder(order_group_id);	
				session.removeAttribute("cus");
				response.sendRedirect(nextJSP2);	
			}
		  }catch (Exception e) {
			e.printStackTrace();
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
