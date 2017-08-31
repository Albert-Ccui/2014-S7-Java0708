package com.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class MysqlServlet
 */
@WebServlet("/MysqlServlet")
public class MysqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MysqlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//连接操作MySql数据库
		//----------------------------------------------------------------
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/hibernate1";
		String name="root";
		String password="albert";
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, name, password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement st=con.createStatement();
			String sql="select * from users";
			ResultSet rs=st.executeQuery(sql);
			System.out.println("name"+"\t"+"password");
			String uname=null;
			String ps=null;
			while(rs.next()) {
				uname=rs.getString("name");
				ps=rs.getString("password");
				System.out.println(uname+"\t"+ps);
			}
			//删除数据
			/*PreparedStatement ps;
			ps=con.prepareStatement("delete from users where id=?");
			ps.setInt(1, 5);
			ps.executeUpdate();
			ps.close();*/
			//更新数据
			/*PreparedStatement pStatement;
			pStatement=con.prepareStatement("update users set name=?where id=?");
			pStatement.setString(1, "Rose");
			pStatement.setInt(2, 1);
			pStatement.executeUpdate();
			pStatement.close();*/
			//增加数据		
		/*	PreparedStatement pps;
			ResultSet rs;
			pps=con.prepareStatement("insert users(name,password)"+"values(?,?)");
			pps.setString(1, "Albert");
			pps.setString(2, "9099");
			pps.executeUpdate();
			pps.close();*/
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry!can't find the Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed...");
				}catch(Exception e){
					e.printStackTrace();
				}
			System.out.println("数据库数据成功获取！");
		}
		}
		
	
		
		//----------------------------------------------------------------
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
