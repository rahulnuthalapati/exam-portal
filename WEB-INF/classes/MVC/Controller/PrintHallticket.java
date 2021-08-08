package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class PrintHallticket extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
			String u=request.getParameter("uname");
			String p=request.getParameter("password");
			UserCheck uc = new UserCheck();
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><head><style>table,th,td {border: 1px solid black;border-collapse:collapse;} table.center {margin-left: auto;margin-right: auto;} * {text-align:center;}</style></head><body><br><br><br>");
			List result = uc.returnRegistered(u);
			int i = 1;
			Iterator<String> it = result.iterator();
			out.println("<h1>Username: " + u + "</h1>");
			out.println("<div style='margin-left:15%'><table><tr><th>CourseID</th><th>Course Name</th><th>Date</th></tr>");
			while(it.hasNext()) {
				String[] arr = it.next().split("~", 6);
				out.println("<tr><td>"+arr[0]+"</td><td>"+arr[1]+"</td><td>"+ i + "-May-2020</td></tr>");
				i++;
			}
			out.println("</table></div></body></html>");
			/*uc.delCurrUser(u); */
			return;
		}
		catch(Exception E){System.out.println(E);return;}
	}
}			