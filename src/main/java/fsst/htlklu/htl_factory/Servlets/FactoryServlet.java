package fsst.htlklu.htl_factory.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fsst.htlklu.htl_factory.DAO.OrderDAO;
import fsst.htlklu.htl_factory.Objects.Category;
import fsst.htlklu.htl_factory.Objects.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FactoryServlet", value = "/FactoryServlet/*")
public class FactoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] url = request.getRequestURL().toString().split("/");
        switch(url[(url.length-1)]){

            case "category":
                ArrayList<Category> out_1 = OrderDAO.getCategories();
                PrintWriter wr = response.getWriter();
                if(out_1 != null){
                    response.setStatus(200);
                    response.setContentType("application/json");
                    wr.print(new Gson().toJson(out_1));
                    wr.close();
                }else{
                    wr.close();
                    response.setStatus(500);
                }
                break;

            case "order":
                ArrayList<Order> out = OrderDAO.getAllOrders();
                PrintWriter wr_2 = response.getWriter();
                if(out != null){
                    response.setStatus(200);
                    response.setContentType("application/json");
                    wr_2.print(new Gson().toJson(out));
                    wr_2.close();
                }else{
                    wr_2.close();
                    response.setStatus(500);
                }
                break;

            default:
                response.setStatus(500);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] url = request.getRequestURL().toString().split("/");
        switch(url[(url.length-1)]){
            case "order":
                BufferedReader br = request.getReader();
                PrintWriter pr = response.getWriter();
                String in = "";
                String ini = "";
                while((in = br.readLine()) != null){
                    ini = ini + in;
                }
                JsonObject job = new Gson().fromJson(ini, JsonObject.class);
                Order or = OrderDAO.addOrder(new Order(job.get("s_name").getAsString(), job.get("s_class").getAsString(), job.get("project").getAsString(), job.get("comment").getAsString(), new Category(job.get("cat_id").getAsInt())));
                response.setStatus(201);
                response.setContentType("application/json");
                pr.println(new Gson().toJson(or));
                pr.close();
                break;

            default:
                response.setStatus(500);
                break;
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] url = request.getRequestURL().toString().split("/");
        switch(url[(url.length-1)]){
            case "order":
                BufferedReader br = request.getReader();
                PrintWriter pr = response.getWriter();
                String in = "";
                String ini = "";
                while((in = br.readLine()) != null){
                    ini = ini + in;
                }
                JsonObject job = new Gson().fromJson(ini, JsonObject.class);
                int ok = OrderDAO.deleteOrder(new Order(job.get("id").getAsInt(), job.get("s_name").getAsString(), job.get("s_class").getAsString(), job.get("project").getAsString(), job.get("comment").getAsString(), new Category(job.get("cat_name").getAsString(), job.get("cat_id").getAsInt())));
                response.setStatus(204);
                response.setContentType("application/json");
                pr.println(new JsonParser().parse("{\"ok\":"+Integer.toString(ok)+"}").getAsJsonObject().toString());
                pr.close();
                break;

            default:
                response.setStatus(500);
                break;
        }
    }
}
