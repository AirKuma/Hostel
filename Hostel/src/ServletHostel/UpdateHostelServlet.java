package ServletHostel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;
import Hostel.*;

@WebServlet("/UpdateHostelServlet")
public class UpdateHostelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "updatehostel.jsp";
	private static final String thisJSP = "myhostel.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("updatehostel")== null)
		{
			String hostel_id = request.getParameter("PNO");		
			HttpSession session = request.getSession(true);
			session.setAttribute("hostel",hostel_id);
			response.sendRedirect(nextJSP);
		}
		else{
			request.setCharacterEncoding("utf-8");
			String error;
			String hostel_phone = request.getParameter("hostel_phone");
			String hostel_server = request.getParameter("hostel_server");
			String hostel_payway = request.getParameter("hostel_payway");
			String hostel_deposit = request.getParameter("hostel_deposit");
			HttpSession session = request.getSession(true);
			String user_email = (String)session.getAttribute("user");
			String hostel_id = (String)session.getAttribute("hostel");
			String hostel_img = request.getParameter("hostel_img");
			int hostelid =Integer.parseInt(hostel_id);
			
			Hostel hos = new Hostel(hostelid,"",hostel_phone,"",hostel_server,hostel_payway,user_email,hostel_deposit,hostel_img);
			DBhostel db = new DBhostel();
			try{
				if(hostel_phone.equals("")||hostel_server.equals("")||hostel_payway.equals("")){
					error = "民宿資料尚未填寫完成";
					session.setAttribute("error", error);
					session.setAttribute("updatehostel",request.getParameter("updatehostel"));
					response.sendRedirect(nextJSP);
				}
				else if(isNum(hostel_deposit)==false){
					error = "訂金比例錯誤";
					session.setAttribute("error", error);
					session.setAttribute("updatehostel",request.getParameter("updatehostel"));
					response.sendRedirect(nextJSP);
				}else
					if(isNum(hostel_deposit)){
						if(Double.parseDouble(hostel_deposit)>1){
							error = "訂金比例錯誤";
							session.setAttribute("error", error);
							session.setAttribute("updatehostel",request.getParameter("updatehostel"));
							response.sendRedirect(nextJSP);
						}
						else {
							db.updatehostel(hos,hostel_id);
							response.sendRedirect(thisJSP);
						}
					}					
			  }catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isNum(String msg){

		if(java.lang.Character.isDigit(msg.charAt(0))){
		return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
