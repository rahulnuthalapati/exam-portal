package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Payment extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try{

		/*Cookie ck[]=request.getCookies();  
		for(int li=0;li<ck.length;li++){
			if(ck[li].getName().equals("user~session")){
				response.addCookie(ck[li]);
				System.out.println("Payment "+ck[li].getValue());
			}
		}	*/

		String u = request.getParameter("uname");
		String p = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><style>");
		RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
		rd.include(request,response);
		out.println("</style><head></head><body><h1>Payment Screen</h1><p><Logged in User:<p>"+u+"<p>");
		int i;

		String[] results = request.getParameterValues("chkbx");
		for ( i = 0; i < results.length; i++) {
    		out.println(results[i]); 
		}


		/*if(request.getParameter("btn_submit")!=null)
		{
			String course[]=request.getParameterValues("chkbox");
			String courses= new String();
			for (i=0; i<course.length; i++)
			{
				out.println(course[i]+",");
				courses=courses+course[i]+"~";
			}
			String ch[]=courses.split("~",1);
			String choices=new String();
			for(i=0;i<ch.length;i++)
			{	
				choices=choices+ch[i].substring(0,7)+"~";
			}*/

			out.println("Amount to be paid: "+results.length+"*1000= "+(results.length*1000));
			out.println("<form action=valcard method=post>");
			out.println("<label for=cardNo>Card no:</label>");
  			out.println("<input type=text id=cardNo name=cardNo><br>");
  			out.println("<label for=name>Name:</label>");
  			out.println("<input type=text id=name name=name><br>");
  			out.println("<label for=pin>PIN:</label>");
  			out.println("<input type=text id=pin name=pin><br>");
  			/*out.print("<input type='hidden' name='results' value='"+results+"'>");*/
  			out.print("<input type='hidden' name='uname' value='"+u+"'>");
			out.print("<input type='hidden' name='password' value='"+p+"'>");

			for(i=0;i<results.length;i++)
				out.print("<input type='hidden' name='c"+i+"' value='"+results[i].substring(0,7)+"'>");/*
			out.print("<input type='hidden' name='c2' value='"+results[1]+"'>");
			out.print("<input type='hidden' name='c3' value='"+results[2]+"'>");
			out.print("<input type='hidden' name='c4' value='"+results[3]+"'>");
			out.print("<input type='hidden' name='c5' value='"+results[4]+"'>");
			out.print("<input type='hidden' name='c6' value='"+results[5]+"'>");*/
			out.print("<input type='hidden' name='n' value='"+results.length+"'>");
			out.println("<input type=submit value=\"Proceed to pay\">");
			out.println("</form></body></html>");
		/*}*/
		return;
		}
		catch(Exception E){System.out.println(E);return;}
	}	
}


