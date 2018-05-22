package ServletHostel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hostel.*;
import DBHostel.*;

@WebServlet("/CreateHostelServlet")
public class CreateHostelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "myhostel.jsp";
	private static final String thisJSP = "createhostel.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String error;
		String hostel_name = request.getParameter("hostel_name");
		String hostel_phone = request.getParameter("hostel_phone");
		String hostel_address = request.getParameter("hostel_address");
		String hostel_server = request.getParameter("hostel_server");
		String hostel_payway = request.getParameter("hostel_payway");
		String hostel_deposit = request.getParameter("hostel_deposit");
		String hostel_img = request.getParameter("hostel_img");
		HttpSession session = request.getSession(true);
		String user_email = (String)session.getAttribute("user");
		
		Hostel hos = new Hostel(0,hostel_name,hostel_phone,hostel_address,hostel_server,hostel_payway,user_email,hostel_deposit,hostel_img);
		DBhostel db = new DBhostel();
		try {
			if(db.isrehostel(hostel_address,hostel_name)){  
				error = "民宿已存在";
				session.setAttribute("error", error);
				session.setAttribute("createhostel",request.getParameter("createhostel"));
				response.sendRedirect(thisJSP);
			}
			else if(hostel_name.equals("")||hostel_phone.equals("")||hostel_address.equals("")||hostel_server.equals("")||hostel_payway.equals("")||hostel_deposit.equals("")){
				error = "民宿資料尚未填寫完成";
				session.setAttribute("error", error);
				session.setAttribute("createhostel",request.getParameter("createhostel"));
				response.sendRedirect(thisJSP);
			}
			else if(isNum(hostel_deposit)==false){
				error = "訂金比例錯誤";
				session.setAttribute("error", error);
				session.setAttribute("createhostel",request.getParameter("createhostel"));
				response.sendRedirect(thisJSP);
			}
			else{
				if(isNum(hostel_deposit)){
					if(Double.parseDouble(hostel_deposit)>1){
						error = "訂金比例錯誤";
						session.setAttribute("error", error);
						session.setAttribute("createhostel",request.getParameter("createhostel"));
						response.sendRedirect(thisJSP);
					}
					else {
						db.createhostel(hos);
						response.sendRedirect(nextJSP);
					}
				}
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
