package sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection connection = null;
		
		try {
			InitialContext iniCtx = new InitialContext();
			
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");
			
			connection = ds.getConnection();
			
			log("接続が開きました");
			
			List<Todo> resultList = select(connection);
			
			request.setAttriibute("list", resultList);
			
			request.getRequestDispatcher("/list.jsp").forward(request, response);
			
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
	}
	
	public List<Todo> select(Connection connection) throws Exception {
		String sql = "SELECT title , task , limitdate , lastupdate , useri , status " + "FROM todo_list WHERE useri like CONCAT('%',?,'%')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1,  "USER");
		
		ResultSet rs = statement.executeQuery();
		
		List<Todo> resultList = new ArrayList<Todo>();
		
		while (rs.next()) {
			Todo todo = new Todo();
			todo.setTitle(rs.getString("title"));
			todo.setTask(rs.getString("task"));
			todo.setLimitdate(rs.getString("limitdate"));
			todo.setLastupdate(rs.getString("lastupdate"));
			todo.setUseri(rs.getString("useri"));
			todo.setStatus(rs.getInt("status"));
			
			resultList.add(todo);
		}
		
		return resultList;
	}
}
			}
		}
		}
	}