package ServletHostel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHostel.*;

@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "myhostel.jsp";
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String order_paid = request.getParameter("paid");
		boolean orderpaid = new Boolean(order_paid).booleanValue();
		String order_check_in = request.getParameter("check");
		boolean ordercheck_in = new Boolean(order_check_in).booleanValue();
		HttpSession session = request.getSession(true);
		String order_group_id = (String)session.getAttribute("ordergroupid");
		
		DBorder db = new DBorder();
		try{
			db.updateorder(orderpaid,ordercheck_in,order_group_id);
			
	  }catch (Exception e) {
		e.printStackTrace();
	}
	response.sendRedirect(nextJSP);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
