package banksystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import banksystem.bean.KouzaBean;

/**
 * Servlet implementation class KouzaSentaku
 */
@WebServlet("/KouzaSentaku")
public class KouzaSentaku extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected Connection conn = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KouzaSentaku() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
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

	/**
	 * @see Servlet#destroy()
	 */
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

//		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String userid = (String)session.getAttribute("userid");
//		String username = (String)session.getAttribute("username");

//		KouzaBean bean = null;
//		String userid = (String)session.getAttribute("user");

		KouzaBean bean = null;
		@SuppressWarnings("unchecked")
		List<KouzaBean> list = (List<KouzaBean>)request.getAttribute("sesObject");

//		list = (ArrayList<KouzaBean>)request.getAttribute("sesObject");
		if(list == null || list.isEmpty()) {
			list = new ArrayList<KouzaBean>();
			request.setAttribute("sesObject", list);
		}

		try {
			String sql = "SELECT userid, kouzasyubetsu, kouzanumber, kouzazandaka FROM KOUZAINFO WHERE userid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next())
			{
				bean = new KouzaBean();
				bean.setUserId(rs.getString(1));
				bean.setKouzaSyubetsu(rs.getString(2));
				bean.setKouzaNumber(rs.getString(3));
				bean.setKouzaZandaka(rs.getString(4));
				list.add(bean);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}


		ServletContext context = request.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/kouzasentaku.jsp");
		rd.forward(request, response);

//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>口座選択画面</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>口座選択画面</h1>");

//		out.println("</body>");
//		out.println("</html>");

	}

}
