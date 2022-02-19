package com.example.tut02.servlet;

import com.example.tut02.dao.FriendDAO;
import com.example.tut02.entity.Friend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/")
public class ServletFriend extends HttpServlet {
    private FriendDAO friendDAO;

    @Override
    public void init() throws ServletException {
//        super.init();
        friendDAO = new FriendDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        displayFriend(request,response);
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    addFriend(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/delete":
                    deleteFriend(request, response);
                    break;
                case "/update":
                    updateFriend(request, response);
                    break;
                default:
                    displayFriend(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void displayFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data from friend table
        List<Friend> friendList = friendDAO.selectFriend();

        //send this data to the front-end (JSP)
        request.setAttribute("friends", friendList);

        //render the webpage (JSP)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewfriend.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addfriend.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Friend existingFriend = friendDAO.getFriend(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addfriend.jsp");
        request.setAttribute("friend", existingFriend);
        dispatcher.forward(request, response);

    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String city = request.getParameter("city");

        Friend friend = new Friend(name, age, sex, city);
        friendDAO.addFriend(friend);
        response.sendRedirect("list");

//        //render the webpage (JSP)
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewfriend.jsp");
//        requestDispatcher.forward(request, response);
    }

    private void updateFriend(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String city = request.getParameter("city");

        Friend friend = new Friend(id, name, age,sex,city);
        friendDAO.updateFriend(friend);
        response.sendRedirect("list");

    }

    private void deleteFriend(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        Friend friend = new Friend(id);
        friendDAO.deleteFriend(friend);
        response.sendRedirect("list");
    }


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
