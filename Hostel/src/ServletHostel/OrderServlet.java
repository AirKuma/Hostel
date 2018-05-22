package ServletHostel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import DBHostel.*;
import Hostel.*;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String room_id = request.getParameter("room");
		int roomid = Integer.parseInt(room_id);
		String order_day = (String)session.getAttribute("order_day");
		int orderday = Integer.parseInt(order_day);
		
		String user_email = (String)session.getAttribute("user");
		String begin_time = (String)session.getAttribute("begin_time");
		java.sql.Date orderdate=java.sql.Date.valueOf(begin_time);
			
		DBRoom db2 = new DBRoom();
		SimpleDateFormat week = new SimpleDateFormat( "u" );
		int price = 0;		
		
		DBorder db = new DBorder();
		String order_group = (String)session.getAttribute("order_group");
		Calendar cal = Calendar.getInstance(); 
		try {
			List<Room> room = db2.Getthisroom(roomid);
			for(int i = 0;i < orderday;i++){
				for (Room rom: room){
					if(week.format(orderdate).equals("6")||week.format(orderdate).equals("5"))
						price+=rom.getroom_holidayprice();
					else
						price+=rom.getroom_weekdayprice();
				}
				if(session.getAttribute("customerorder")==null)
					db.order(orderdate,Integer.parseInt(order_group),false,false,roomid,user_email);
				else
					db.order(orderdate,Integer.parseInt(order_group),false,false,roomid,(String)session.getAttribute("customerorder"));
				cal.setTime(orderdate);
				cal.add(Calendar.DATE,1);
				orderdate = new java.sql.Date(cal.getTime().getTime());			
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(session.getAttribute("customerorder")!=null){
			session.removeAttribute("customerorder");
			response.sendRedirect("myhostel.jsp");
		}else	
			response.sendRedirect("orderdata.jsp?PNO="+price+"&PNO2="+roomid);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
