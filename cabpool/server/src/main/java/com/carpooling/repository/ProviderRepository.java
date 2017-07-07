package com.carpooling.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carpooling.domain.ProviderDetail;
import com.carpooling.domain.RegisterUser;


@Repository
public class ProviderRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<ProviderDetail> findAll() {
        return jdbcTemplate.query("select * from ProviderDetails", 
                new ProviderRowMapper());
    }

    @Transactional(readOnly=true)
    public ProviderDetail findUserById(int emp_id) {
        return jdbcTemplate.queryForObject(
            "select * from ProviderDetails where empId=?",
            new Object[]{emp_id}, new ProviderRowMapper());
    }

    @Transactional(readOnly=true)
    public List<ProviderDetail> findUserByRouteAndDate(String route, String date) {
    	//System.out.println("provider.getDate().substring(0, 13) " +provider.getDate().substring(0, 14));
        return jdbcTemplate.query(
            "select * from ProviderDetails where route=? and pdate like ?",
            new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, route);
					ps.setString(2, date.substring(0, 11) +"%");
					
				}
			}, new ProviderRowMapper());
    }
    
    public ProviderDetail provide(final ProviderDetail provider) 
    {
    	
        final String sql = "insert into ProviderDetails(empId,route,fromAdd,toAdd,pdate,contact,altContact,email,vehicleNo,vehType,noOfSeats) values(?,?,?,?,?,?,?,?,?,?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,provider.getEmpId());
                ps.setString(2, provider.getRoute());
                ps.setString(3, provider.getFrom());
                ps.setString(4, provider.getTo());
                ps.setString(5, provider.getDate());
                ps.setString(6, provider.getContact());
                ps.setString(7, provider.getAltContact());
                ps.setString(8, provider.getEmail());
                ps.setString(9, provider.getVehicleNo());
                ps.setString(10, provider.getVehType());
                ps.setString(11,provider.getNoOfSeats());
                return ps;
            }
        }, holder);
        
        int pid = holder.getKey().intValue();
        provider.setPid(pid);
        return provider;

    }
}


class ProviderRowMapper implements RowMapper<ProviderDetail>
{
    @Override
    public ProviderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
    	ProviderDetail provider = new ProviderDetail();
    	provider.setAltContact(rs.getString("altContact"));
    	provider.setContact(rs.getString("contact"));
    	provider.setDate(rs.getString("pdate"));
    	provider.setEmail(rs.getString("email"));
    	provider.setEmpId(rs.getString("empId"));
    	provider.setFrom(rs.getString("fromAdd"));
    	provider.setNoOfSeats(rs.getString("noOfSeats"));
    	provider.setPid(rs.getInt("pid"));
    	provider.setRoute(rs.getString("route"));
    	provider.setTo(rs.getString("toAdd"));
    	provider.setVehicleNo(rs.getString("vehicleNo"));
    	provider.setVehType(rs.getString("vehType"));
        //user.setCont_no(rs.getLong("cont_no"));
        return provider;
    }
}