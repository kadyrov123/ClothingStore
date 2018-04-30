package com.clothingstore.demo.Dao;

import com.clothingstore.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts(){
        String sql="SELECT p.id , p.name , p.description , p.amount ,st.status_name as status , se.status_name as season\n" +
                "           \t, t.status_name as type ,k.status_name as kind\n" +
                "\tFROM products as p \n" +
                "\tLEFT OUTER JOIN status_of_product as st ON\n" +
                "   \t\tst.id=p.status\n" +
                "\tLEFT OUTER JOIN season_of_product as se ON\n" +
                "   \t\tse.id=p.season\n" +
                "\tLEFT OUTER JOIN type_of_product as t ON\n" +
                "   \t\tt.id=p.type        \n" +
                "\tLEFT OUTER JOIN kind_of_product as k ON\n" +
                "   \t\tk.id=p.kind\n" +
                "        ";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setDescription(rs.getString("description"));
                    product.setAmount(rs.getInt("amount"));
                    product.setStatus(rs.getString("status"));
                    product.setSeason(rs.getString("season"));
                    product.setType(rs.getString("type"));
                    product.setKind(rs.getString("kind"));
                return product;
            }
        });
    }




}
    