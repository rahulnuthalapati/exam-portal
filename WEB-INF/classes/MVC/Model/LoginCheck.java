package MVC.Model;
import java.util.*;
import java.sql.*;
import java.io.*;

public class LoginCheck
{
	public String logincheck(String userName,String password)
	{
	try{
	String url = "jdbc:mysql://localhost:3306/model_db";
	String _user = "root";
	String _password = "9108";
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/model_db?autoReconnect=true&useSSL=false",_user,_password);
	System.out.println("con--->"+con);
	Statement st = con.createStatement();
	String s = "select * from user where id = \'" + userName + "\'";
	ResultSet rs = st.executeQuery(s);
	if(rs.next())
	{
		if(rs.getString(2).equals(password))
			{st.close();con.close();return rs.getString(1);}
		else
			{st.close();con.close();return "Password Incorrect!";}
	}

	else
	{
		st.close();
		con.close();
		return "Invalid login!";
	}	
	}
	catch(Exception E)
	{
	System.out.println(E);
	return "None";
	}
	}

	public String cardcheck(String cardNo,String name,String pin)
	{
	try{
	String url = "jdbc:mysql://localhost:3306/miniproj_db";
	String _user = "root";
	String _password = "9108";
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
	System.out.println("con--->"+con);
	Statement st = con.createStatement();
	String s = "select pin from card where cardno =\'" + cardNo +"\' and name = \'"+ name +"\'";
	ResultSet rs = st.executeQuery(s);
	if(rs.next())
	{
		if(rs.getString(1).equals(pin))
			{st.close();con.close();return "Authorized";}
		else
			{st.close();con.close();return "Incorrect pin!";}
	}

	else
	{
		st.close();
		con.close();
		return "Invalid card details!";
	}	

	}
	catch(Exception E)
	{
	System.out.println(E);
	return "None";
	}
	}

	public List returnUserDetails(String userName) throws Exception
	{
			String url = "jdbc:mysql://localhost:3306/miniproj_db";
			String _user = "root";
			String _password = "9108";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
			System.out.println("con_Quiz--->"+con);
			Statement st = con.createStatement();
			String s = "select s.email,s.phone,c.id,c.name,i.attendance,i.marks,i.status from student s, users u, course c, internal i where u.id=s.id and u.id= \'" + userName + "\' and s.id=i.sid and c.id=i.cid";
			ResultSet rs = st.executeQuery(s);
			List res = new ArrayList();
			while(rs.next())
			{
				res.add(rs.getString(1)+ "~" + rs.getString(2) + "~" + rs.getString(3) + "~" + rs.getString(4) + "~" + rs.getString(5) + "~" + rs.getString(6)+"~"+rs.getString(7));
			}	
			st.close();
			con.close();
			return res;
	}

	public List returnAllUserDetails() throws Exception
	{
			String url = "jdbc:mysql://localhost:3306/miniproj_db";
			String _user = "root";
			String _password = "9108";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
			System.out.println("con_Quiz--->"+con);
			Statement st = con.createStatement();
			String s = "select s.email,s.phone,c.id,c.name,i.attendance,i.marks,i.status from student s, users u, course c, internal i where u.id=s.id and s.id=i.sid and c.id=i.cid";
			ResultSet rs = st.executeQuery(s);
			List res = new ArrayList();
			while(rs.next())
			{
				res.add(rs.getString(1)+ "~" + rs.getString(2) + "~" + rs.getString(3) + "~" + rs.getString(4) + "~" + rs.getString(5) + "~" + rs.getString(6) + "~" + rs.getString(7));
			}	
			st.close();
			con.close();
			return res;
	}

	public List returnRegistered(String userName) throws Exception
	{
			String url = "jdbc:mysql://localhost:3306/miniproj_db";
			String _user = "root";
			String _password = "9108";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
			System.out.println("con_Quiz--->"+con);
			Statement st = con.createStatement();
			String s = "select s.email,s.phone,c.id,c.name,i.attendance,i.marks from student s, users u, course c, internal i where u.id=s.id and u.id= \'" + userName + "\' and s.id=i.sid and c.id=i.cid and i.status=1";
			ResultSet rs = st.executeQuery(s);
			List res = new ArrayList();
			while(rs.next())
			{
				res.add(rs.getString(3) + "~" + rs.getString(4));
			}	
			st.close();
			con.close();
			return res;
	}

	public void updateStatus(String userName,String choice) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproj_db";
		String _user = "root";
		String _password = "9108";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
		System.out.println("con_Quiz--->"+con);
		Statement st = con.createStatement();
		String s = "update internal set status=1 where sid = \'" + userName + "\' and cid = \'" + choice + "\'";	
		st.executeUpdate(s);
		st.close();
		con.close();
		return;
	} 

	public void resetStatus(String userName) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproj_db";
		String _user = "root";
		String _password = "9108";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
		System.out.println("con_Quiz--->"+con);
		Statement st = con.createStatement();
		String s = "update internal set status=0 where sid = \'" + userName + "\'";	
		st.executeUpdate(s);
		st.close();
		con.close();
		return;
	} 

	
	public void updateDetails(String userName,String details) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproj_db";
		String _user = "root";
		String _password = "9108";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
		System.out.println("con_Quiz--->"+con);
		Statement st = con.createStatement();
		String[] arr = details.split("~",4);
		for(int i=0;(i<arr.length/4);i=i+4) 
		{
			String s = "insert into internal values (\'" + arr[i] + "\',\'" + arr[i+1] + "\',\'" + arr[i+2] + "\',\'" + arr[i+3] + "\')";	
			st.execute(s);
		}
		st.close();
		con.close();
		return;
	} 

	public String addInternals(String userName,String ci, String att, String m) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproj_db";
		String _user = "root";
		String _password = "9108";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
		System.out.println("con_Quiz--->"+con);
		Statement st = con.createStatement();
	
		int at=Integer.parseInt(att);
		int mk=Integer.parseInt(m);
		String s = "insert into internal values (\'" + userName + "\',\'" + ci + "\',\'" + att + "\',\'" + m + "\',0)";	
		st.execute(s);
		st.close();
		con.close();
		return " ";
	} 



	public String admincheck(String userName,String password)
	{
	try{
	String url = "jdbc:mysql://localhost:3306/miniproj_db";
	String _user = "root";
	String _password = "9108";
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
	Statement st = con.createStatement();
	String s = "select * from admin where user = \'" + userName + "\'";
	ResultSet rs = st.executeQuery(s);
	if(rs.next())
	{
		if(rs.getString(2).equals(password))
			{st.close();con.close();return "Logged in";}
		else
			{st.close();con.close();return "Password Incorrect!";}
	}

	else
	{
		st.close();
		con.close();
		return "Invalid login!";
	}	
	}
	catch(Exception E)
	{
	System.out.println(E);
	return "None";
	}
	}


	public String createuser(String userName,String password)
	{
	try{
	String url = "jdbc:mysql://localhost:3306/miniproj_db";
	String _user = "root";
	String _password = "9108";
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj_db?autoReconnect=true&useSSL=false",_user,_password);
	System.out.println("con--->"+con);
	Statement st = con.createStatement();
	String s = "select * from users where id = \'" + userName + "\'";
	String s2 = "insert into users values (\'"+userName+"\',\'"+password+"\')";
	ResultSet rs = st.executeQuery(s);
	if(rs.next())
	{
		{st.close();con.close();return "Already taken";}
	}

	else
	{
		st.executeUpdate(s2);
		st.close();
		con.close();
		return "User created";
	}	
	}
	catch(Exception E)
	{
	System.out.println(E);
	return "None";
	}
	}
}
