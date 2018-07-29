package com.soulstrk.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soulstrk.Dao.Dao;
import com.soulstrk.Dto.bDto;

public class BListService implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<bDto> blist = new ArrayList<>();
		Dao dao = new Dao();
		blist = dao.getListAll();
		
		request.setAttribute("list", blist);
	}

}
