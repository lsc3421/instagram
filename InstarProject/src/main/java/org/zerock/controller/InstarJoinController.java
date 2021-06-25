package org.zerock.controller;


import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.spi.LoggerFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.zerock.domain.InstarVO;
import org.zerock.service.InstarService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping
@AllArgsConstructor
public class InstarJoinController {
	
	private InstarService service;
	
	

	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return"/auth/joinForm";
	}
	
	@PostMapping("/auth/joinForm")
	public String joinForm(InstarVO instarvo,RedirectAttributes redirectAttributes) {
		String hashedPw = BCrypt.hashpw(instarvo.getPassword(), BCrypt.gensalt()); 
		instarvo.setPassword(hashedPw); 
		service.register(instarvo); 
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/auth/loginForm";
	}
	
	@PostMapping("/auth/loginForm")
	public String loginForm(HttpSession session, InstarVO instarvo, Model model ) throws Exception {
		InstarVO user = service.Login(instarvo);
		if(user!=null&&BCrypt.checkpw(instarvo.getPassword(), user.getPassword())) {
			session.setAttribute("user", user);
			
			return "redirect:/image/feed";
		}
		else {
			
			
			return "redirect:/auth/loginForm";
		}
	}

	
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String userID = request.getParameter("userID");
		int result=service.idCheck(userID);
		return Integer.toString(result);
	}
	
	@GetMapping("/image/feed")
	public String feed() {
		return "/image/feed";
	}
	
	@GetMapping("/user/user")
	public String user() {
		return "/user/user";
	}
	@GetMapping("/user/profile")
	public String profile() {
		return "/user/profile";
	}
	
	@GetMapping("/image/explore")
	public String explore() {
		return "/image/explore";
	}
	
	@GetMapping("/upload/imageUpload")
	public String imageUpload() {
		return "/upload/imageUpload";
	}
	

}
