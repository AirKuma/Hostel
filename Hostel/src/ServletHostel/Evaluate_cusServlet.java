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

@WebServlet("/Evaluate_cusServlet")
public class Evaluate_cusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "Eva_cus.jsp";
	private static final String thisJSP = "Evaluate_cus.jsp";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error;
		String eva_cus_cusrequency = request.getParameter("eva_cus_cusrequency");
		String eva_cus_behavior = request.getParameter("eva_cus_behavior");
		String eva_cus_sanitation = request.getParameter("eva_cus_sanitation");
		String eva_cus_credence = request.getParameter("eva_cus_credence");
		String eva_cus_reflux = request.getParameter("eva_cus_reflux");
		String eva_cus_customer = request.getParameter("eva_cus_customer");
		
		HttpSession session = request.getSession(true);
		String user_email = (String)session.getAttribute("customer");
		String hostel_name = (String)session.getAttribute("hostel_name");
		
		DBevaluate_cus db = new DBevaluate_cus();
		
		try {
			if(eva_cus_cusrequency==null||eva_cus_behavior==null||eva_cus_sanitation==null||eva_cus_credence==null||eva_cus_reflux==null||eva_cus_customer.equals("")){
				error = "表單尚未填寫完成";
				session.setAttribute("error", error);
				session.setAttribute("eva_cus",request.getParameter("eva_cus"));
				response.sendRedirect(thisJSP);
			}
			else{
				int evacuscusrequency = Integer.parseInt(eva_cus_cusrequency);
				int evacusbehavior = Integer.parseInt(eva_cus_behavior);
				int evacussanitation= Integer.parseInt(eva_cus_sanitation);
				int evacuscredence = Integer.parseInt(eva_cus_credence);
				int evacusreflux = Integer.parseInt(eva_cus_reflux);
				Evaluate_cus evacus = new Evaluate_cus(0,evacuscusrequency,evacusbehavior,evacussanitation,evacuscredence,evacusreflux,eva_cus_customer,user_email);
				db.createcuseva(evacus,hostel_name);
				response.sendRedirect(nextJSP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
