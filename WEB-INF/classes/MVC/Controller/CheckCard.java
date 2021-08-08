package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckCard extends HttpServlet //throws IOException,ServletException,Exception
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) //throws IOException //,Exception
	{
		/*HttpSession session = request.getSession(true);
*/
		String cardno_ = request.getParameter("cardNo");
		String name_ = request.getParameter("name");
		String pin_ = request.getParameter("pin");
		String user_ = request.getParameter("uname");
		String password_ = request.getParameter("password");
		/*String choices_ = request.getParameter("results");*/
		String n = request.getParameter("n");
		String[] c=new String[6];
		for(int i=0;i<Integer.parseInt(n);i++)
		{	
			c[i] = request.getParameter("c"+Integer.toString(i));
		}
		/*Cookie us = new Cookie("user~session",user_+"~"+session.getId()); 
		us.setMaxAge(60*60*24);

		response.addCookie(us);
		System.out.println("UserValidate "+us.getValue());*/

		UserCheck uc = new UserCheck();
		try{
		String result = uc.cardcheck(cardno_,name_,pin_);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(result.equals("Incorrect pin!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2 style=color:red;text-align:center>Enter Login Details to take Exam:</h2><section class=reg><form action=payment method=post><label for=name>Name:</label><br>");
  			/*out.println("<input type=text id=userName name=userName value=" + user_ +"><br><br><br>");
			out.println("<label for=name>Password:</label><br><input type=text id=password name=password><br>");*/
			out.println("<p>Incorrect password was entered.Make sure to enter correct password</p>");
			out.println("<br><br><br><input type=submit value=Next></form></section></body></html>");
		}
		else if(result.equals("Invalid card details!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2 style=color:red;text-align:center>Enter Login Details to take Exam:</h2><p>Invalid login.Enter valid username and password</p><section class=reg><form action=payment method=post><label for=name>Name:</label><br>");
  			/*out.println("<input type=text id=userName name=userName><br><br><br>");
			out.println("<label for=name>Password:</label><br><input type=text id=password name=password><br>");
			*/out.println("<br><br><br><input type=submit value=Next></form></section></body></html>");
		}
		else
		{
			//uc.addCurrUser(user_,session.getId());
			/*String[] arr = choices_.split("~", 6);*/
			for(int i=0;i<Integer.parseInt(n);i++)
			{
				uc.updateStatus(user_,c[i]);
			}
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br><h2>Registered successfully! "/*+user_*/+"!</h2>");
				out.println("<p>"+c[0]+"&ensp; Registered for Exam"+"</p>");
			out.println("<form action=dispuser method=post>");
			out.print("<input type='hidden' name='uname' value='"+user_+"'>");
			out.print("<input type='hidden' name='password' value='"+password_+"'>");
			out.println("<input type=submit value=\"Check account details\"></form></body></html>");
		}
		}
		catch(Exception E){System.out.println(E);}
	}
}		



