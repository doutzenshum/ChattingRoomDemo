package com.xuguang.servlet.chat.main;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xuguang.servlet.chat.listener.CounterInitListener;
import com.xuguang.servlet.chat.listener.CounterListener;

public class ChatServlet extends HttpServlet {

	private static final long serialVersionUID = 988382573735896073L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String chat = req.getParameter("chat");
		ServletContext sc = this.getServletContext();
		HttpSession session = req.getSession();
		String name = session.getAttribute(CounterInitListener.ONLINE_NAME)
				.toString();
		StringBuilder sb = (StringBuilder) sc
				.getAttribute(CounterListener.CHAT);
		sb.append(String.format("%s说：%s%n", name, chat));
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

}
