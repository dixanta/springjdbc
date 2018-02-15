/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.webapp.controller;

import com.lfa.core.dao.CourseDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private CourseDAO courseDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        try{
        model.addAttribute("courses", courseDAO.getAll());
        }catch(ClassNotFoundException | SQLException se){
            System.out.println(se.getMessage());
        }
        return "index";
    }
}
