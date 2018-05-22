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
import Hostel.*;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "message.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String from = (String)session.getAttribute("user");
		String recever = request.getParameter("recever");
		String subject = request.getParameter("subject");
		String context = request.getParameter("context");
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
		
		
		Message mes = new Message("0",from,recever,sqlDate,subject,context);
		DBmessage db = new DBmessage();
		try {
			db.message(mes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(nextJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
