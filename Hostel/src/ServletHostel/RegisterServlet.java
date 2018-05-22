package ServletHostel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;
import Hostel.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "login.jsp";
	private static final String thisJSP = "register.jsp";
	private static final String thisJSP2 = "customerdata.jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String error,user_password="0",reuser_password="0";
		String user_email = "GUEST_"+request.getParameter("user_email");
		if(request.getParameter("customer")==null){
			user_email = request.getParameter("user_email");
			user_password = request.getParameter("user_password");
			reuser_password = request.getParameter("reuser_password");
		}
		String user_name = request.getParameter("user_name");
		String user_gender = request.getParameter("user_gender");
		String user_birthday = request.getParameter("user_birthday");
		String user_phone = request.getParameter("user_phone");
		String user_address = request.getParameter("user_address");
		String user_IDnumber = request.getParameter("user_IDnumber");
		String user_nationality = request.getParameter("user_nationality");
		String user_passport = request.getParameter("user_passport");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1;
		 java.sql.Date userbirthday=null;
		 try {
			date1 = sdf.parse(user_birthday);
			userbirthday = new java.sql.Date(date1.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}			    
		
		HttpSession session = request.getSession(true);
		User use = new User("0",user_email,user_name,user_password,user_phone,user_address,user_IDnumber,user_gender,userbirthday,user_nationality,user_passport);
		DBregister db = new DBregister();
		try {
			if(db.isInvalidUseremail(user_email)){  
				error = "E-mail已存在";
				session.setAttribute("error", error);
				if(request.getParameter("customer")!=null)
				{
					session.setAttribute("customer",request.getParameter("customer"));
					response.sendRedirect(thisJSP2);
				}	
				else
				{	
					session.setAttribute("register",request.getParameter("register"));
					response.sendRedirect(thisJSP);
				}	
			}
			else if(user_password.equals(reuser_password)!=true){  
				error = "確認密碼錯誤";
				session.setAttribute("error", error);
				session.setAttribute("register",request.getParameter("register"));
				response.sendRedirect(thisJSP);
			} 
			else if(user_email.equals("")||user_password.equals("")||user_name.equals("")||user_gender.equals("")||user_birthday.equals("")||user_phone.equals("")||user_address.equals("")||user_IDnumber.equals("")||user_nationality.equals("")){
				error = "資料未填寫完成";
				session.setAttribute("error", error);
				if(request.getParameter("customer")!=null)
				{	
					session.setAttribute("customer",request.getParameter("customer"));
					response.sendRedirect(thisJSP2);
				}	
				else
				{	
					session.setAttribute("register",request.getParameter("register"));
					response.sendRedirect(thisJSP);
				}	
			}
			else if(isInvalidEmail(user_email)){  
				error = "E-mail格式不符";
				session.setAttribute("error", error);
				if(request.getParameter("customer")!=null)
				{	
					session.setAttribute("customer",request.getParameter("customer"));
					response.sendRedirect(thisJSP2);
				}	
				else
				{	
					session.setAttribute("register",request.getParameter("register"));
					response.sendRedirect(thisJSP);
				}	
			}  
			else if(user_email.equals("")||user_password.equals("")||user_name.equals("")||user_gender.equals("")||user_birthday.equals("")||user_phone.equals("")||user_address.equals("")||user_IDnumber.equals("")||user_nationality.equals("")){
				error = "資料未填寫完成";
				session.setAttribute("error", error);
				if(request.getParameter("customer")!=null)
				{	
					session.setAttribute("customer",request.getParameter("customer"));
					response.sendRedirect(thisJSP2);
				}	
				else
				{	
					session.setAttribute("register",request.getParameter("register"));
					response.sendRedirect(thisJSP);
				}	
			}
			else{
				if(request.getParameter("customer")!=null){
					response.sendRedirect("order.jsp?PNO="+user_email);
					db.user(use);
				}
				else{
					if(user_password.equals("0")){  
						error = "密碼不能為零";
						session.setAttribute("error", error);
						session.setAttribute("register",request.getParameter("register"));
						response.sendRedirect(thisJSP);
					} 
					else{
						db.user(use);
						response.sendRedirect(nextJSP);
					}	
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean isInvalidEmail(String email) {
        return email.indexOf('@')==-1;
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
