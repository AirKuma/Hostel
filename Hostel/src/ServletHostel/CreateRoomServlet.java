package ServletHostel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.DBRoom;
import Hostel.Room;

@WebServlet("/CreateRoomServlet")
public class CreateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "myhostel.jsp";
	private static final String thisJSP = "createroom.jsp";
	
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String error;
		String room_name = request.getParameter("room_name");
		String room_peoplenum = request.getParameter("room_peoplenum");
		String room_weekdayprice = request.getParameter("room_weekdayprice");		
		String room_holidayprice = request.getParameter("room_holidayprice");	
		String room_describe = request.getParameter("room_describe");
		String room_img = request.getParameter("room_img");
		HttpSession session = request.getSession(true);
		String hostel_id = (String)session.getAttribute("hostel");
			
		
		DBRoom db = new DBRoom();
		
		try{
			if(room_name.equals("")||room_peoplenum.equals("")||room_weekdayprice.equals("")||room_holidayprice.equals("")||room_describe.equals("")){
					error = "房間資料尚未填寫完成";
					session.setAttribute("error", error);
					session.setAttribute("createroom",request.getParameter("createroom"));
					response.sendRedirect(thisJSP);
			}
			else if(isNum(room_peoplenum)==false||isNum(room_weekdayprice)==false||isNum(room_holidayprice)==false){
				error = "房間人數或價格非數值";
				session.setAttribute("error", error);
				session.setAttribute("createroom",request.getParameter("createroom"));
				response.sendRedirect(thisJSP);
			}
			else{
				int roompeoplenum = Integer.parseInt(room_peoplenum);
				int roomweekdayprice = Integer.parseInt(room_weekdayprice);
				int roomholidayprice = Integer.parseInt(room_holidayprice);
				Room room = new Room(0,room_name,room_img,room_describe,roompeoplenum,roomweekdayprice,roomholidayprice);
				db.createroom(room,hostel_id);
				response.sendRedirect(nextJSP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isNum(String msg){

		int len = msg.length();
		for(int i =0;i <len;i++){
			if(java.lang.Character.isDigit(msg.charAt(i))){
				return true;
			}
		}
		return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}