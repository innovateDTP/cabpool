package com.carpooling.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carpooling.domain.RegisterUser;


@Repository
public class RegisterRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<RegisterUser> findAll() {
        return jdbcTemplate.query("select * from RegisterUser", 
                new UserRowMapper());
    }

    @Transactional(readOnly=true)
    public RegisterUser findUserById(int emp_id) {
        return jdbcTemplate.queryForObject(
            "select * from RegisterUser where emp_id=?",
            new Object[]{emp_id}, new UserRowMapper());
    }

    public RegisterUser registerUser(final RegisterUser user) 
    {
        final String sql = "insert into RegisterUser(emp_id,emp_name,cont_no,alt_cont_no,email_id,created_at,update_at) values(?,?,?,?,?,?,?)";

        //KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, user.getEmp_id());
                ps.setString(2, user.getEmp_name());
                ps.setLong(3, user.getCont_no());
                ps.setLong(4, user.getAlt_cont_no());
                ps.setString(5, user.getEmail_id());
                ps.setString(6, new Date().toString());
                ps.setString(7, new Date().toString());
                
                return ps;
            }
        });

        //int newUserId = holder.getKey().intValue();
        //user.setId(newUserId);
        return user;
    }
}

class UserRowMapper implements RowMapper<RegisterUser>
{
    @Override
    public RegisterUser mapRow(ResultSet rs, int rowNum) throws SQLException {
    	RegisterUser user = new RegisterUser();
        user.setEmp_id(rs.getInt("emp_id"));
        user.setEmp_name(rs.getString("emp_name"));
        user.setCont_no(rs.getLong("cont_no"));
        user.setAlt_cont_no(rs.getLong("alt_cont_no"));
        user.setEmail_id(rs.getString("email_id"));
        user.setCreated_at(rs.getString("created_at"));
        user.setUpdate_at(rs.getString("update_at"));
        //user.setCont_no(rs.getLong("cont_no"));
        return user;
    }
}