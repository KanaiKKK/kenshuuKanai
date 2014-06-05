package sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class Insert_Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		Connection connection = null;

		try{
			InitialContext context = new InitialContext();

			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/dbtest");

			connection = ds.getConnection();

			log("接続を開きました");

			insert(connection);

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				connection.close();
				log("接続を閉じました");
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		request.getRequestDispatcher("/complete.html").forward(request,response);
	}

	private void insert(Connection connection) throws Exception {
		String sql = "INSERT INTO lecture.book(nam,sex,old,enter,memo " + ") VALUES (?,?,?,?,?);";

		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, "あ");
		statement.setString(2, "い");
		statement.setInt(3, 16);
		statement.setString(4, "え");
		statement.setString(5, "お");

		int count = statement.executeUpdate();
		log("1つ目の追加:" + count);
	}
}
