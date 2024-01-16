package com.tutorial.controller;

import bdUtil.InstructorDAO;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Instructor;

@WebServlet("/InstructorController")

@Controller()
@RequestMapping("/instructor")
public class InstructorController {
 
	@RequestMapping("/getAll")	
	//@ResponseBody()
	public String getAll(Model model) {
		
		InstructorDAO insdao = new InstructorDAO();
		List<Instructor> iList = insdao.getAll();
		model.addAttribute("instructors", iList);
		model.addAttribute("action", "getAll");
		
		return "Instructor/instructorDisplayInfo";

	}
	
	@RequestMapping("/getById")
	//@ResponseBody()
	public String getById(HttpServletRequest request, Model model) {
		
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            InstructorDAO insdao = new InstructorDAO();

            Instructor inst = insdao.findById(id);
            if (inst != null) {
                model.addAttribute("instructor", inst);
                model.addAttribute("action", "getById");
            } else {
                model.addAttribute("message", "No data found in the database for ID: " + id);
                model.addAttribute("action", "noData");
            }
        } catch (Exception e) {
            model.addAttribute("message", "Error occurred: " + e.getMessage());
            model.addAttribute("action", "error");
        }
        return "Instructor/instructorDisplayInfo";
	    
	}
	
	//http://localhost:8086/Database/instructor/add?name=Alvin&gender=Male&specialty=Mathematics
	@RequestMapping("/add")
	//@ResponseBody()
	public String add(HttpServletRequest request, Model model) {
		
	    Instructor i = new Instructor();
	    i.setName(request.getParameter("name"));
	    i.setGender(request.getParameter("gender"));
	    i.setSpecialty(request.getParameter("specialty"));

	    InstructorDAO insdao = new InstructorDAO();
	    int rw = insdao.add(i);
	    
	    model.addAttribute("effectedRow", rw);
	    model.addAttribute("action", "add");
	    
	    return "Instructor/instructorDisplayInfo";
	}
	
	//http://localhost:8086/Database/instructor/update?id=2&name=WChun&gender=Male&specialty=Programmer
	@RequestMapping("/update")
	//@ResponseBody()
	public String update(HttpServletRequest request, Model model) {
	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Instructor i = new Instructor();
	        i.setId(id);
	        i.setName(request.getParameter("name"));
	        i.setGender(request.getParameter("gender"));
	        i.setSpecialty(request.getParameter("specialty"));

	        InstructorDAO insdao = new InstructorDAO();
	        int rw = insdao.update(i);

	        if (rw == 0) {
	            model.addAttribute("message", "No data found in the database for ID: " + id);
	            model.addAttribute("action", "noData");
	        } else {
	            model.addAttribute("effectedRow", rw);
	            model.addAttribute("action", "update");
	        }
	    } catch (Exception e) {
	        model.addAttribute("message", "Error occurred: " + e.getMessage());
	        model.addAttribute("action", "error");
	    }

	    return "Instructor/instructorDisplayInfo";
	}

	//http://localhost:8086/Database/instructor/delete?id=2
	@RequestMapping("/delete")
	//@ResponseBody()
	public String delete(HttpServletRequest request, Model model) {
	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        InstructorDAO insdao = new InstructorDAO();
	        int rw = insdao.delete(id);

	        if (rw == 0) {
	            model.addAttribute("message", "No data found in the database for ID: " + id);
	            model.addAttribute("action", "noData");
	        } else {
	            model.addAttribute("effectedRow", rw);
	            model.addAttribute("action", "delete");
	        }
	    } catch (Exception e) {
	        model.addAttribute("message", "Error occurred: " + e.getMessage());
	        model.addAttribute("action", "error");
	    }

	    return "Instructor/instructorDisplayInfo";
	}
	
	@RequestMapping("/requestById")
	public String requestById(Model model) {
		
		model.addAttribute("action", "getById");
		
	    return "Instructor/instructorRequestPage";
	}
	
	@RequestMapping("/requestAdd")
	public String requestAdd(Model model) {
		
		model.addAttribute("action", "add");
		
	    return "Instructor/instructorRequestPage";
	}
	
	@RequestMapping("/requestUpdate")
	public String requestUpdate(Model model) {
		
		model.addAttribute("action", "update");
		
	    return "Instructor/instructorRequestPage";
	}
	
	@RequestMapping("/requestDelete")
	public String requestDelete(Model model) {
		
		model.addAttribute("action", "delete");
		
	    return "Instructor/instructorRequestPage";
	}
	
}
