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
        String sql="SELECT p.id , p.name , p.description , p.amount,p.foto ,st.status_name as status , se.status_name as season\n" +
                "           \t, t.status_name as type ,k.status_name as kind\n" +
                "\tFROM products as p \n" +
                "\tLEFT OUTER JOIN status_of_product as st ON\n" +
                "   \t\tst.id=p.status\n" +
                "\tLEFT OUTER JOIN season_of_product as se ON\n" +
                "   \t\tse.id=p.season\n" +
                "\tLEFT OUTER JOIN type_of_product as t ON\n" +
                "   \t\tt.id=p.type        \n" +
                "\tLEFT OUTER JOIN kind_of_product as k ON\n" +
                "k.id=p.kind\n";
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
                    product.setFoto(rs.getString("foto"));
                return product;
            }
        });
    }

    public Product getProduct(int id){
        /*
        SELECT p.id , p.name , p.description , p.amount,p.foto ,st.status_name as status , se.status_name as season
		, t.status_name as type ,k.status_name as kind ,f.f1,f.f2,f.f3,f.f4,f.f4
                FROM products as p
                LEFT OUTER JOIN status_of_product as st ON
					st.id=p.status
                LEFT OUTER JOIN season_of_product as se ON
					se.id=p.season
                LEFT OUTER JOIN type_of_product as t ON
					t.id=p.type
                LEFT OUTER JOIN kind_of_product as k ON
					k.id=p.kind
				left outer join foto_of_product as f on
					f.id=p.id
				where p.id=1;
         */
        String sql = "SELECT p.id , p.name , p.description , p.amount,p.foto ,st.status_name as status , se.status_name as season\n" +
                "\t\t, t.status_name as type ,k.status_name as kind ,f.f1,f.f2,f.f3,f.f4,f.f5\n" +
                "                FROM products as p \n" +
                "                LEFT OUTER JOIN status_of_product as st ON\n" +
                "\t\t\t\t\tst.id=p.status\n" +
                "                LEFT OUTER JOIN season_of_product as se ON\n" +
                "\t\t\t\t\tse.id=p.season\n" +
                "                LEFT OUTER JOIN type_of_product as t ON\n" +
                "\t\t\t\t\tt.id=p.type        \n" +
                "                LEFT OUTER JOIN kind_of_product as k ON\n" +
                "\t\t\t\t\tk.id=p.kind\n" +
                "\t\t\t\tleft outer join foto_of_product as f on\n" +
                "\t\t\t\t\tf.id=p.id " +
                "where p.id=?";
        RowMapper<Product> rowMapper = new RowMapper<Product>() {
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
                product.setFoto(rs.getString("foto"));
                product.setF1(rs.getString("f1"));
                product.setF2(rs.getString("f2"));
                product.setF3(rs.getString("f3"));
                product.setF4(rs.getString("f4"));
                product.setF5(rs.getString("f5"));
                return product;
            }
        };
        Product p = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return p;
    }

    public List<Product> search(String s){
        String sql="select * from products where name like \"%"+s+"%\" or description like \"%"+s+"%\";";

        return jdbcTemplate.query(sql , new RowMapper<Product>(){
           @Override
           public Product mapRow(ResultSet rs , int rowNum) throws SQLException{
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
    