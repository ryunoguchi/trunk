package banksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
   }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>ユーザLogin画面</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>ユーザLoginページ</h1>");
		out.println("<p>ユーザIDとパスワードを入力して下さい。</p>");

		HttpSession session = request.getSession(true);

		Object status = session.getAttribute("status");

		if(status != null){
			out.println("<p>認証に失敗いたしました。</p>");
			out.println("<p>再度認証を行ってください。</p>");

			session.setAttribute("status", null);
		}

	    out.println("<form method=\"POST\" action=\"./UserLoginCheck\" name=\"loginform\">");
	    out.println("<table>");
	    out.println("<tr>");
	    out.println("<td>ユーザーID</td>");
	    out.println("<td><input type=\"text\" name=\"user\" size=\"32\"></td>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<td>パスワード</td>");
	    out.println("<td><input type=\"password\" name=\"pass\" size=\"32\"></td>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<td><input type=\"submit\" value=\"login\"></td>");
	    out.println("<td><input type=\"reset\" value=\"reset\"></td>");
	    out.println("</tr>");
	    out.println("</table>");
	    out.println("</form>");

	    out.println("</body>");
	    out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
