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

@WebServlet("/Evaluate_hostelServlet")
public class Evaluate_hostelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "Eva_hostel.jsp";
	private static final String thisJSP = "Evaluate_hostel.jsp";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error;
		String eva_hostel_server = request.getParameter("eva_hostel_server");
		String eva_hostel_location = request.getParameter("eva_hostel_location");
		String eva_hostel_environment = request.getParameter("eva_hostel_environment");
		String eva_hostel_food = request.getParameter("eva_hostel_food");
		String eva_hostel_facility = request.getParameter("eva_hostel_facility");
		String eva_hostel_feedback = request.getParameter("eva_hostel_feedback");
		
		HttpSession session = request.getSession(true);
		String user_email = (String)session.getAttribute("user");
		String hostel_name = (String)session.getAttribute("hostel_name");
		
		DBevaluate_hostel db = new DBevaluate_hostel();
		
		try {
			if(eva_hostel_server==null||eva_hostel_location==null||eva_hostel_environment==null||eva_hostel_food==null||eva_hostel_facility==null||eva_hostel_feedback.equals("")){
				error = "表單尚未填寫完成";
				session.setAttribute("error", error);
				session.setAttribute("eva_hostel",request.getParameter("eva_hostel"));
				response.sendRedirect(thisJSP);
			}
			else{
				int evahostelserver = Integer.parseInt(eva_hostel_server);
				int evahostellocation = Integer.parseInt(eva_hostel_location);
				int evahostelenvironment = Integer.parseInt(eva_hostel_environment);
				int evahostelfood = Integer.parseInt(eva_hostel_food);
				int evahostelfacility = Integer.parseInt(eva_hostel_facility);
				Evaluate_hostel evahostel = new Evaluate_hostel(0,evahostelserver,evahostellocation,evahostelenvironment,evahostelfood,evahostelfacility,eva_hostel_feedback,user_email);
				db.createhosteleva(evahostel,hostel_name);
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
