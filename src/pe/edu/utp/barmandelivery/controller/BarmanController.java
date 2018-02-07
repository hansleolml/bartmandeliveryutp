package pe.edu.utp.barmandelivery.controller;


import pe.edu.utp.barmandelivery.models.Barman;
import pe.edu.utp.barmandelivery.models.BdService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BarmanController", urlPatterns = "/barmans")
public class BarmanController extends HttpServlet {
    private Connection connection;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Post",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest( "Get",request,response);
    }

    private void processRequest(
            String method,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
        String action = request.getParameter("action");
        String url="index.jsp";

        if (method.equals("Get") && action==null){ action ="index"; }
        if (method.equals("Post") && action.equalsIgnoreCase("index")) return;
        if (method.equals("Get") &&  action.equalsIgnoreCase("create"))return;
        if (method.equals("Get") &&  action.equalsIgnoreCase("update"))return;

        BdService service= new BdService();
        service.setConnection(getConnection());

        // action = index, method = Get
        if (action.equalsIgnoreCase("index")){
            List<Barman> regions = service.findAllBarmans();
            request.setAttribute("regions",regions);
            url = "listBarmans.jsp";
        }

        // action = show, method = Get
        if (action.equalsIgnoreCase("show")){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("region",service.findBarmanById(id));
            url="showBarman.jsp";
        }
        // action = new, method = Get
        if (action.equalsIgnoreCase("new")){
            url="newBarman.jsp";
        }
        // action = create, method = Post
        if (action.equalsIgnoreCase("create")){
            String name = request.getParameter("name");
            Barman region = service.createBarman(name);
            request.setAttribute("regions",service.findAllBarmans());
            url="listBarmans.jsp";
        }
        // action = edit, method = Get
        if (action.equalsIgnoreCase("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("region",service.findBarmanById(id));
            url="editBarman.jsp";
        }
        // action = delete, method = Get
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = service.deleteBarman(id);
            request.setAttribute("region",service.findAllBarmans());
            url="listBarmans.jsp";
        }

        // action = update, method = Post
        if (action.equalsIgnoreCase("update")){
            int id= Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            boolean result = service.updateBarman(new Barman(id,name));
            request.setAttribute("region",service.findAllBarmans());
            url="listBarmans.jsp";
        }
        request.getRequestDispatcher(url).forward(request,response);

    }

    private Connection getConnection(){
        if (connection==null){
            try {
                InitialContext ctx= new InitialContext();
                DataSource dataSource = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
                connection = dataSource.getConnection();
            }
            catch (NamingException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
