package com.soulstrk.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soulstrk.Dao.Dao;
import com.soulstrk.Dto.bDto;
import com.sun.org.apache.xml.internal.dtm.DTMDOMException;

public class BContent_View implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId = request.getParameter("bId");
		
		Dao dao = new Dao();
		bDto dto = dao.getContent(bId);
		
		request.setAttribute("content", dto);
	}

}
