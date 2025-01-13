package com.revature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ItemTableAccessor {
    // select an item by id
    Item selectItemById(int id) {
        Item itemToReturn = new Item();

        try (Connection conn = ConnectionUtility.getConnection();){
            // excecute a statement
            Statement st = conn.createStatement();

            // process results
            String query = "SELECT * FROM item WHERE id = " + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                itemToReturn.setId(rs.getInt("id"));
                itemToReturn.setName(rs.getString("name"));
                itemToReturn.setPrice(rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemToReturn;
    }

    // add an item
    void addItem(Item itemToadd) {
    
        try(Connection conn = ConnectionUtility.getConnection()) {
            String sql = "INSERT INTO item(name, price) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, itemToadd.getName());
            pstmt.setDouble(2, itemToadd.getPrice());

            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
