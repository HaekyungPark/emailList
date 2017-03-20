package com.bit2017.emailList.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.emailList.dao.EmailListDao;
import com.bit2017.emailList.vo.EmailListVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
	}

}
