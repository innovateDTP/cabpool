package com.carpooling.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carpooling.domain.RideDetails;

@Repository
public class RideDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<RideDetails> findAll() {
        return jdbcTemplate.query("select * from RideDetails", 
                new RideRowMapper());
    }

    @Transactional(readOnly=true)
    public RideDetails findUserById(int emp_id) {
        return jdbcTemplate.queryForObject(
            "select * from RideDetails where emp_id=?",
            new Object[]{emp_id}, new RideRowMapper());
    }

    public RideDetails bookRide(final RideDetails ride) 
    {
    	final String sql = "insert into RideDetails(emp_id,source_add,destination_add,journey_date,journey_time,user_role,vehicle_no,available_seat_count) values(?,?,?,?,?,?,?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, ride.getEmp_id());
                ps.setString(2, ride.getSource_add());
                ps.setString(3, ride.getDestination_add());
                ps.setDate(4, ride.getJourney_date());
                ps.setTime(5, ride.getJourney_time());
                ps.setString(6, ride.getUser_role());
                ps.setString(7,ride.getVehicle_no());
                ps.setInt(8,ride.getAvailable_seat_count());
                return ps;
            }
        }, holder);

        int rid = holder.getKey().intValue();
        ride.setRid(rid);
        return ride;
    }

}

class RideRowMapper implements RowMapper<RideDetails>
{
    @Override
    public RideDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	RideDetails ride = new RideDetails();
    	
    	ride.setRid(rs.getInt("rid"));
    	ride.setEmp_id(rs.getInt("emp_id"));
    	ride.setSource_add(rs.getString("source_add"));
    	ride.setDestination_add(rs.getString("destination_add"));
    	ride.setJourney_date(rs.getDate("journey_date"));
    	ride.setJourney_time(rs.getTime("journey_time"));
    	ride.setUser_role(rs.getString("user_role"));
    	ride.setVehicle_no(rs.getString("vehicle_no"));
    	ride.setAvailable_seat_count(rs.getInt("available_seat_count"));
        //user.setCont_no(rs.getLong("cont_no"));
        return ride;
    }
}
