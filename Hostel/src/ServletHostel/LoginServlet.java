package ServletHostel;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "index.jsp";
	private static final String thisJSP = "login.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String error;
		String user_email = request.getParameter("user_email");
		String user_password = md5(request.getParameter("user_password"));
		
		HttpSession session = request.getSession(true);
		DBlogin db = new DBlogin();
	
		try {
			if(db.Validlogin(user_email,user_password)!=true){ 
				error = "Invalid login";
				session.setAttribute("error", error);
				session.setAttribute("login",request.getParameter("login"));
				response.sendRedirect(thisJSP);			
			}  
			else if(user_password.equals("cfcd208495d565ef66e7dff9f98764da")){
				error = "無效會員";
				session.setAttribute("error", error);
				session.setAttribute("login",request.getParameter("login"));
				response.sendRedirect(thisJSP);
			}
			else{  
				session.setAttribute("user",user_email);
				response.sendRedirect(nextJSP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static String md5(String input) {
	        
	        String md5 = null;
	         
	        if(null == input) return null;
	         
	        try {
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	        
	        digest.update(input.getBytes(), 0, input.length());
	 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e) {
	 
	            e.printStackTrace();
	        }
	        return md5;
	}



}
