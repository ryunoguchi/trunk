package banksystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class UserLoginCheck
 */
@WebServlet("/UserLoginCheck")
public class UserLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected Connection conn = null;

    public class ReturnValue{
    	public boolean check;
    	public String name;
    }


    /**
     *
     */
    public void init() throws ServletException{
        DataSource datasource = null;

        try {
        	Context ctx = new InitialContext();
        	datasource = (DataSource)ctx.lookup("jdbc/credentials");
        } catch (NamingException e) {
        	e.printStackTrace();
        }

        try {
        	conn = datasource.getConnection();
        }
        catch(SQLException e){
        	e.printStackTrace();
        }

    }

    public void destroy() {
    	try {
    		if(conn != null) {
    			conn.close();
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();

		String userid = request.getParameter("user");
		String password = request.getParameter("pass");

		HttpSession session = request.getSession(true);

		ReturnValue rv = authUser(userid,password);

		if(rv.check){
			session.setAttribute("login", "OK");

			session.setAttribute("userid", userid);
			session.setAttribute("username",rv.name);
//			String target = (String)session.getAttribute("target");

			response.sendRedirect("./KouzaSentaku");
//			ServletContext context = request.getServletContext();
//			RequestDispatcher rd = context.getRequestDispatcher("/KouzaSentaku");
//			rd.forward(request, response);

		}else{
			session.setAttribute("status", "Not Auth");
			response.sendRedirect("./UserLogin");
//			ServletContext context = request.getServletContext();
//			RequestDispatcher rd = context.getRequestDispatcher("/UserLogin");
//			rd.forward(request, response);

		}
	}

	protected ReturnValue authUser(String userid, String password){
		ReturnValue rv = new ReturnValue();

		if(userid == null || userid.length() == 0 || password == null || password.length() == 0){
			rv.check = false;
			return rv;
		}

		try {
			String sql = "SELECT USERNAME FROM USERINFO WHERE USERID = ? AND USERPASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
//			log(pstmt.);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				rv.name = rs.getString(1);
				rv.check = true;
				return rv;
			}else{
				rv.check = false;
				return rv;
			}
		}catch(SQLException e){
			e.printStackTrace();
			rv.check = false;
			return rv;
		}
	}
}
