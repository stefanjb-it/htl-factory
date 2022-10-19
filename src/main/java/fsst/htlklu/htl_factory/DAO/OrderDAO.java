package fsst.htlklu.htl_factory.DAO;

import fsst.htlklu.htl_factory.DB.DB_Connection;
import fsst.htlklu.htl_factory.Objects.Category;
import fsst.htlklu.htl_factory.Objects.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

    private static final String getAllOrders = "select orders.id,student,class,project,comment,categories.id,name from orders, categories where orders.categories_id = categories.id";
    private static final String addOrder = "insert into orders(student,class,project,comment,categories_id) values(?,?,?,?,?)";
    private static final String deleteOrder = "delete from orders where orders.id = ?";
    private static final String getCategories = "select * from categories";

    public static ArrayList<Order> getAllOrders(){
        ArrayList<Order> out = new ArrayList<Order>();
        try {
            PreparedStatement stmt = DB_Connection.getConn().prepareStatement(getAllOrders);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()){
                out.add(new Order(rset.getInt("id"),rset.getString("student"),rset.getString("class"),rset.getString("project"),rset.getString("comment"),new Category(rset.getString("name"), rset.getInt(6))));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return out;
    }

    public static Order addOrder(Order in){
        Order out = in;
        try {
            PreparedStatement stmt = DB_Connection.getConn().prepareStatement(addOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1,in.getStudent());
            stmt.setString(2,in.getS_class());
            stmt.setString(3,in.getProject());
            stmt.setString(4,in.getComment());
            stmt.setInt(5, in.getCategory().getId());
            stmt.executeUpdate();
            ResultSet rset = stmt.getGeneratedKeys();
            if(rset.next()){
                out.setId(rset.getInt(1));
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
            return null;
        }
        return out;
    }

    public static Integer deleteOrder(Order in){
        int out = 0;
        try {
            PreparedStatement stmt = DB_Connection.getConn().prepareStatement(deleteOrder);
            stmt.setInt(1,in.getId());
            out = stmt.executeUpdate();
        } catch (SQLException throwables) {
            return null;
        }
        return out;
    }

    public static ArrayList<Category> getCategories(){
        ArrayList<Category> out = new ArrayList<Category>();
        try {
            PreparedStatement stmt = DB_Connection.getConn().prepareStatement(getCategories);
            ResultSet rset = stmt.executeQuery();
            while(rset.next()){
                out.add(new Category(rset.getString("name"), rset.getInt("id")));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return out;
    }
}
