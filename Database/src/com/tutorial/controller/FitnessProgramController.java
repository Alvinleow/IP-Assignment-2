package com.tutorial.controller;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.Program;
import bdUtil.HibernateCF;

@WebServlet("/FitnessProgramController")

@Controller()
@RequestMapping("/program")
public class FitnessProgramController{

	@RequestMapping("/getAll")
	//@ResponseBody()
	public String getAll(Model model) {

	    Session session=HibernateCF.getSessionFactory().openSession();

	    @SuppressWarnings("unchecked")
	    List<Program> pList = session.createQuery("from Program").list();
	    
	    model.addAttribute("programs", pList);
	    model.addAttribute("action", "getAll");
	    
	    session.close();
	    
	    return "FitnessProgram/programDisplayInfo";
	}
	
	@RequestMapping("/getById")
	//@ResponseBody()
	public String getById(HttpServletRequest request, Model model) {
		
		Session session=HibernateCF.getSessionFactory().openSession();
		
		try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Program p = session.get(Program.class, id);

	        if (p != null) {
	            model.addAttribute("program", p);
	            model.addAttribute("action", "getById");
	        } else {
	            model.addAttribute("message", "No data found in the database for ID: " + id);
	            model.addAttribute("action", "noData");
	        }
	    } catch (Exception e) {
	        // Handle exceptions such as NumberFormatException for invalid ID input
	        model.addAttribute("message", "Error occurred: " + e.getMessage());
	        model.addAttribute("action", "error");
	    } finally {
	        session.close();
	    }
	    
	    return "FitnessProgram/programDisplayInfo";
	    
	    //return "this is from getById - program :" + p.toString();
	    
	}
	
	//http://localhost:8086/Database/program/add?name=Alvin&note=Hello World
	
	@RequestMapping("/add")
	//@ResponseBody()
	public String add(HttpServletRequest request, Model model) {

	    Session session=HibernateCF.getSessionFactory().openSession();

	    try {
	        Program prog = new Program();
	        prog.setName(request.getParameter("name"));
	        prog.setNote(request.getParameter("note"));

	        session.beginTransaction();
	        session.save(prog);
	        session.getTransaction().commit();
	        
	        model.addAttribute("program", prog);
	        model.addAttribute("action", "add");
	    } finally {
	        session.close();
	    }

	    return "FitnessProgram/programDisplayInfo";
	}
	
	//http://localhost:8086/Database/program/update?id=2&note=HelloWorld
	
	@RequestMapping("/update")
	//@ResponseBody()
	public String update(HttpServletRequest request, Model model) {

	    Session session=HibernateCF.getSessionFactory().openSession();

	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Program p2u = session.get(Program.class, id);

	        if (p2u != null) {
	            p2u.setName(request.getParameter("name"));
	            p2u.setNote(request.getParameter("note"));

	            session.beginTransaction();
	            session.update(p2u);
	            session.getTransaction().commit();

	            model.addAttribute("program", p2u);
	            model.addAttribute("action", "update");
	        } else {
	            model.addAttribute("message", "No data found in the database for ID: " + id);
	            model.addAttribute("action", "noData");
	        }
	    } catch (Exception e) {
	        model.addAttribute("message", "Error occurred: " + e.getMessage());
	        model.addAttribute("action", "error");
	    } finally {
	        session.close();
	    }
	    
	    return "FitnessProgram/programDisplayInfo";
	}
	
	//http://localhost:8086/Database/program/delete?id=2
	
	@RequestMapping("/delete")
	//@ResponseBody()
	public String delete(HttpServletRequest request, Model model) {

	    Session session=HibernateCF.getSessionFactory().openSession();

	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Program p2d = session.get(Program.class, id);

	        if (p2d != null) {
	            session.beginTransaction();
	            session.delete(p2d);
	            session.getTransaction().commit();

	            model.addAttribute("deletedProgramId", id);
	            model.addAttribute("action", "delete");
	        } else {
	            model.addAttribute("message", "No data found in the database for ID: " + id);
	            model.addAttribute("action", "noData");
	        }
	    } catch (Exception e) {
	        model.addAttribute("message", "Error occurred: " + e.getMessage());
	        model.addAttribute("action", "error");
	    } finally {
	        session.close();
	    }
	    
		return "FitnessProgram/programDisplayInfo";
	}
	
	@RequestMapping("/requestById")
	public String requestById(Model model) {
		
		model.addAttribute("action", "getById");
		
	    return "FitnessProgram/programRequestPage";
	}
	
	@RequestMapping("/requestAdd")
	public String requestAdd(Model model) {
		
		model.addAttribute("action", "add");
		
	    return "FitnessProgram/programRequestPage";
	}
	
	@RequestMapping("/requestUpdate")
	public String requestUpdate(Model model) {
		
		model.addAttribute("action", "update");
		
	    return "FitnessProgram/programRequestPage";
	}
	
	@RequestMapping("/requestDelete")
	public String requestDelete(Model model) {
		
		model.addAttribute("action", "delete");
		
	    return "FitnessProgram/programRequestPage";
	}

}
