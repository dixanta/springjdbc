/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplate file, choose Tools | Templates
 * and open the jdbcTemplate in the editor.
 */
package com.lfa.core.dao.impl;

import com.lfa.core.builder.EnquiryBuilder;
import com.lfa.core.dao.EnquiryDAO;
import com.lfa.core.entity.Course;
import com.lfa.core.entity.Enquiry;
import com.lfa.core.entity.EnquiryStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository(value = "enquiryDAO")
public class EnquiryDAOImpl implements EnquiryDAO {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        String sql = "Select * from enquiries";
        return jdbcTemplate.query(sql, new RowMapper<Enquiry>() {
            
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                return EnquiryBuilder.create()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setEmail(rs.getString("email"))
                        .setContactNo(rs.getString("contact_no"))
                        .setMessage(rs.getString("message"))
                        .setCourse(new Course(rs.getInt("course_id")))
                        .setStatus(new EnquiryStatus(rs.getInt("status")))
                        .build();
                
            }
        });
    }
    
    @Override
    public Enquiry getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from enquiries where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Enquiry>() {
            
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                return EnquiryBuilder.create()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setEmail(rs.getString("email"))
                        .setContactNo(rs.getString("contact_no"))
                        .setMessage(rs.getString("message"))
                        .setCourse(new Course(rs.getInt("course_id")))
                        .setStatus(new EnquiryStatus(rs.getInt("status")))
                        .build();
            }
        });
    }
    
    @Override
    public int insert(Enquiry t) throws ClassNotFoundException, SQLException {
        String sql = "insert into enquiries(first_name,last_name,"
                + "email,contact_no,course_id,message,status)"
                + " values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            t.getFirstName(), t.getLastName(),
            t.getEmail(), t.getContactNo(),
            t.getCourse().getId(),t.getMessage(), t.getStatus().getId()
        });
    }
    
    @Override
    public int update(Enquiry t) throws ClassNotFoundException, SQLException {
        return 0;
    }
    
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from enquiries where id=?";
        return jdbcTemplate.update(sql, new Object[]{
            id
        });
    }
    
}
