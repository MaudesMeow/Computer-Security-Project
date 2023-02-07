package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Project.LoginBean;
import Project.LoginDao;
import Project.VerifyRecaptcha;

/**
 * @email Ramesh Fadatare                             ***Change????***
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    
    public void init() {
        loginDao = new LoginDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
     

        try {
            if (loginDao.validate(loginBean) && verify) {

                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("role", loginBean.getRole());
                session.setAttribute("id", loginBean.getID());
                session.setAttribute("address", loginBean.getAddress());
                session.setAttribute("phonenum", loginBean.getPhonenum());
                session.setAttribute("gpa", loginBean.getGpa());
                session.setAttribute("studentCredit", loginBean.getStudentCredits());
                session.setAttribute("accountBalance", loginBean.getAccountBalance());
                
                String role = loginBean.getRole();

                if(role.equals("Student")) {
                	response.sendRedirect("student.jsp");
                }
                else if(role.equals("Faculty")) {
                	response.sendRedirect("faculty.jsp");
                }
                
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("loginfailed.jsp");
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}