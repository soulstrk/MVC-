package com.soulstrk.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
