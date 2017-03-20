package com.bit2017.emailList.dao.test;

import com.bit2017.emailList.dao.EmailListDao;
import com.bit2017.emailList.vo.EmailListVo;

public class EmailListDaoTest {
	public static void main(String[] args) {
		insertTest();
	}

	private static void insertTest() {
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("둘");
		vo.setLastName("리");
		vo.setEmail("asd@gmail.com");
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
	}
	
}
