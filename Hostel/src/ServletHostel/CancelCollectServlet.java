package ServletHostel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;

@WebServlet("/CancelCollectServlet")
public class CancelCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "listcollect.jsp";
	private static final String thisJSP = "Hostel.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String user_email = (String)session.getAttribute("user");
		String hostel_id = request.getParameter("PNO");	
		DBcollect db = new DBcollect();
		try{
			if(request.getParameter("cancel")!=null){
				String hostelid = (String)session.getAttribute("hostel");
				response.sendRedirect(thisJSP);
				db.cancelcollect(user_email,hostelid);
			}
			else{
			    response.sendRedirect(nextJSP);
				db.cancelcollect(user_email,hostel_id);
			}
				
		  }catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
