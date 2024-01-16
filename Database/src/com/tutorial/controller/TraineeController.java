package com.tutorial.controller;

import bdUtil.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Trainee;

@WebServlet("/TraineeController")

@Controller()
@RequestMapping("/trainee")
public class TraineeController {

	@RequestMapping("/getAll")
	//@ResponseBody()
	public String getAll(Model model) {
		
		String dbURL = "jdbc:mysql://localhost:3306/ip23db";
		String username = "root";
		String password = "";
		
		List<Trainee> trainees = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection( dbURL,username,password);
			System.out.println("connection successfully opened :" + conn.getMetaData());
			
			String sql = "Select * from trainee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Trainee trainee = new Trainee();
	            trainee.setId(rs.getInt("id"));
	            trainee.setName(rs.getString("name"));
	            trainee.setWeight(rs.getDouble("weight"));
	            trainee.setHeight(rs.getDouble("height"));
	            trainee.setBmi(rs.getDouble("bmi"));
	            trainees.add(trainee);
			}
			
			conn.close();
			
		}catch (SQLException ex) {
				ex.printStackTrace();
				
		}catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
		}
		
		model.addAttribute("trainees", trainees);
	    model.addAttribute("action", "getAll");
	    return "Trainee/traineeDisplayInfo";

	}
	
	@RequestMapping("/getById")
    //@ResponseBody()
    public String getById(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Trainee trainee = null;
        
        try {
            Connection conn = DBConnect.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from trainee where id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                trainee = new Trainee();
                trainee.setId(rs.getInt("id"));
                trainee.setName(rs.getString("name"));
                trainee.setWeight(rs.getDouble("weight"));
                trainee.setHeight(rs.getDouble("height"));
                trainee.setBmi(rs.getDouble("bmi"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (trainee != null) {
            model.addAttribute("trainee", trainee);
            model.addAttribute("action", "getById");
        } else {
            model.addAttribute("message", "No Trainee found with ID: " + id);
            model.addAttribute("action", "noData");
        }
        
        return "Trainee/traineeDisplayInfo";
    }
	
	@RequestMapping("/add")
	//@ResponseBody()
	public String add(HttpServletRequest request, Model model) {

	    String newName = request.getParameter("name");
	    double newWeight = Double.parseDouble(request.getParameter("weight"));
	    float newHeight = Float.parseFloat(request.getParameter("height"));
	    double newBmi = Double.parseDouble(request.getParameter("bmi"));
		
	    int rowAffected = 0;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DBConnect.openConnection();
	        System.out.println("connection successfully opened : " + conn.getMetaData());

	        // Hardcoded SQL Statement
	        
//	        String sql = "INSERT INTO trainee (name, weight, height, bmi) VALUES ('ali',77.7,1.77,21)";
//	        Statement stmt = conn.createStatement();
//	        
//	        rowAffected = stmt.executeUpdate(sql);
	        
	        // Prepared Statement 
	        
	        String sql = "INSERT INTO trainee (name, weight, height, bmi) VALUES (?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);

	        stmt.setString(1, newName);
	        stmt.setDouble(2, newWeight);
	        stmt.setFloat(3, (float) newHeight);
	        stmt.setDouble(4, newBmi);

	        rowAffected = stmt.executeUpdate();

	        model.addAttribute("effectedRow", rowAffected);
	        model.addAttribute("action", "add");
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return "Trainee/traineeDisplayInfo";
	}
	
	@RequestMapping("/delete")
	//@ResponseBody()
	public String delete(HttpServletRequest request, Model model) {
		
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    int rowAffected = 0;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DBConnect.openConnection();
	        System.out.println("Connection successfully opened: " + conn.getMetaData());
	        
	        //Hardcoded SQL Statement
	        
//	        String sql = "DELETE FROM trainee WHERE id = 3";
//	        Statement stmt = conn.createStatement();
//	        
//	        rowAffected = stmt.executeUpdate(sql);
	        
	        // Prepared Statement 
	        
	        String sql = "DELETE FROM trainee WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);

	        stmt.setInt(1, id);
	        
	        rowAffected = stmt.executeUpdate();
	        
	        if (rowAffected == 0) {
	            model.addAttribute("message", "No data found for ID: " + id);
	            model.addAttribute("action", "noData");
	        } else {
	            model.addAttribute("effectedRow", rowAffected);
	            model.addAttribute("action", "delete");
	        }
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return "Error in delete - Trainee: " + ex.getMessage();
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return "Driver class not found: " + ex.getMessage();
	    }
	    
	    return "Trainee/traineeDisplayInfo";
	}
	
	@RequestMapping("/update")
	//@ResponseBody()
	public String update(HttpServletRequest request, Model model) {
		
		int id = Integer.parseInt(request.getParameter("id"));
	    String newName = request.getParameter("name");
	    double newWeight = Double.parseDouble(request.getParameter("weight"));
	    float newHeight = Float.parseFloat(request.getParameter("height"));
	    double newBmi = Double.parseDouble(request.getParameter("bmi"));
	    
	    int rowAffected = 0;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DBConnect.openConnection();
	        System.out.println("Connection successfully opened: " + conn.getMetaData());

	        // Hardcoded SQL Statement
	        
//	        String sql = "UPDATE trainee SET name = 'WLong', weight = 75.0, height = 1.75, bmi = 24.5 WHERE id = 5";
//	        Statement stmt = conn.createStatement();
//	        
//	        rowAffected = stmt.executeUpdate(sql);
	        
	        // Prepared Statement 
	        
	        String sql = "UPDATE trainee SET name = ?, weight = ?, height = ?, bmi = ? WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	       
	        stmt.setString(1, newName);
	        stmt.setDouble(2, newWeight);
	        stmt.setFloat(3, (float) newHeight);
	        stmt.setDouble(4, newBmi);
	        stmt.setInt(5, id);
	        
	        rowAffected = stmt.executeUpdate();
	        
	        if (rowAffected == 0) {
	            model.addAttribute("message", "No data found for ID: " + id);
	            model.addAttribute("action", "noData");
	        } else {
	            model.addAttribute("effectedRow", rowAffected);
	            model.addAttribute("action", "update");
	        }
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return "Error in update - Trainee: " + ex.getMessage();
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return "Driver class not found: " + ex.getMessage();
	    }

	    return "Trainee/traineeDisplayInfo";
	}
	
	@RequestMapping("/requestById")
	public String requestById(Model model) {
		
		model.addAttribute("action", "getById");
		
	    return "Trainee/traineeRequestPage";
	}
	
	@RequestMapping("/requestAdd")
	public String requestAdd(Model model) {
		
		model.addAttribute("action", "add");
		
	    return "Trainee/traineeRequestPage";
	}
	
	@RequestMapping("/requestUpdate")
	public String requestUpdate(Model model) {
		
		model.addAttribute("action", "update");
		
	    return "Trainee/traineeRequestPage";
	}
	
	@RequestMapping("/requestDelete")
	public String requestDelete(Model model) {
		
		model.addAttribute("action", "delete");
		
	    return "Trainee/traineeRequestPage";
	}


}
