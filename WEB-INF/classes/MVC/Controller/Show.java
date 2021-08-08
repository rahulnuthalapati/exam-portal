package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Show extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
			UserCheck uc = new UserCheck();
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><head><style>table,th,td {border: 1px solid black;border-collapse:collapse;} table.center {margin-left: auto;margin-right: auto;} * {text-align:center;}</style></head><body><h1><h1><br><br><br><br>");
			List result = uc.returnAllUserDetails();
			String e = new String();
			String ph = new String();
			Iterator<String> it = result.iterator();
			out.println("<table");
			out.println("<tr><th>email</th><th>phone</th><th>Course Id</th><th>Course Name</th><th>Attendance</th><th>Marks</th><th>Registered</th></tr>");
			while(it.hasNext()) {
				String[] arr = it.next().split("~", 7);
				out.println("<tr><td>" + arr[0] + "</td><td>" + arr[1] + "</td><td>" + arr[2] + "</td><td>" + arr[3] + "</td><td>" + arr[4] + "</td><td>" + arr[5] + "</td><td>" + arr[6] +"</td></tr>");
			}
			/*uc.delCurrUser(u); */
			return;
		}
		catch(Exception E){System.out.println(E);return;}
	}
}			