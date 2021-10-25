/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jagan
 */
public class ShoppingListServlet extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("action") != null) {
         String go = request.getParameter("action");
         if (go.equals("logout")) {
             session.invalidate();
             session = request.getSession();
         }
        }
         getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
         return;
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         ArrayList<String> itemarray;
        String go = request.getParameter("action");
        switch (go) {
                case "add": itemarray = (ArrayList<String>)session.getAttribute("itemarray"); 
                    itemarray.add((String)request.getParameter("item"));
                session.setAttribute("itemarray", itemarray);
                request.setAttribute("itemarray", itemarray);
                getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                break;
                case "delete":itemarray = (ArrayList<String>)session.getAttribute("itemarray"); 
                    itemarray.remove((String)request.getParameter("itemToDelete"));
                session.setAttribute("itemarray", itemarray);
                request.setAttribute("itemarray", itemarray);
                getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                
                break;
                case "register": itemarray = new ArrayList<String>();
                session.setAttribute("itemarray", itemarray);
                session.setAttribute("username",(String)request.getParameter("username"));
                getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                break;
            }
    }

   

}
