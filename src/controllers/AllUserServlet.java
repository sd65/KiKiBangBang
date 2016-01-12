package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NormalUser;
import dao.UserDao;

/**
 * Servlet implementation class AllUserServlet
 */
@WebServlet("/AllUserServlet")
public class AllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NormalUser> lnu = UserDao.findAll();
		request.setAttribute("userList", lnu);
        NormalUser unUser = UserDao.findUser(5);
        request.setAttribute("usr", unUser);
        // UPDATE OK
//        unUser.setEmail("monboule@zero");
//        UserDao.update(unUser);
        NormalUser deuxUser = UserDao.findUser(1);
        request.setAttribute("usr2", deuxUser);
        NormalUser troisUser = UserDao.findUserByEmail("alex.m@lol.com");
        request.setAttribute("usr3", troisUser);
        request.getRequestDispatcher("/allUserView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
