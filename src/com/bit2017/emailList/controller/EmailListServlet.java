package com.bit2017.emailList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.emailList.dao.EmailListDao;
import com.bit2017.emailList.vo.EmailListVo;
import com.bit2017.emailList.web.EmailListActionFactory;
import com.bit2017.web.Action;
import com.bit2017.web.ActionFactory;
import com.bit2017.web.util.WebUtil;


@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() called");
		super.service(arg0, arg1);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() called");
		super.init();
	}

	//get방식 el?이름=... ()=...
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() called");
		//post방식으로 넘어오는 문자열 데이터의 엔코딩 , get방식은 xml에서 엔코딩해줘야함
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a"); //요청을 분기함
		
		ActionFactory af = new EmailListActionFactory();
		Action a  = af.getAction(actionName);
		a.execute(request, response);
		
		/*if("form".equals(actionName)){
			WebUtil.forward("/WEB-INF/views/form.jsp", request, response);
		
		}else if("add".equals(actionName)){
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			EmailListVo vo = new  EmailListVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			EmailListDao dao = new EmailListDao();
			dao.insert(vo);
			
			WebUtil.redirect(request.getContextPath()+"/el", request, response);
			
		}else{
			default request = list
			EmailListDao dao = new EmailListDao();
			List<EmailListVo> list = dao.getList();
			
			//forward( request연장, request dispatch, forward )
			request.setAttribute("list", list);
			WebUtil.forward("/WEB-INF/views/list.jsp", request, response);
		}*/
		
		/*//getWriter하기 전에 contentType지정
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter printWriter = response.getWriter();
		
		printWriter.println("<h1>안녕!</h1>");*/
	}

	//post방식은 데이터 값이 안보임 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
