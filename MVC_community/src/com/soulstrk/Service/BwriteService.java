package com.soulstrk.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soulstrk.Dao.Dao;

public class BwriteService implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Dao dao = new Dao();
		int w = dao.writeContent(name, title, content);
		if(w != -1) {
			System.out.println("입력 완료");
		}
	}

}
