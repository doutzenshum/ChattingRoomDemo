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

public class RenameServlet extends HttpServlet {

	private static final long serialVersionUID = 988382573735896073L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name != null && !name.trim().equals("")) {
			ServletContext sc = this.getServletContext();
			HttpSession session = req.getSession();
			Counter c = (Counter) sc.getAttribute(CounterListener.COUNTER_NAME);
			String oldName = session.getAttribute(
					CounterInitListener.ONLINE_NAME).toString();

			boolean r = c.renameOnLine(oldName, name);
			if (r) {
				StringBuilder sb = (StringBuilder) sc
						.getAttribute(CounterListener.CHAT);
				sb.append(String.format("%s更名成了%s%n", oldName, name));
				session.setAttribute(CounterInitListener.ONLINE_NAME, name);
			}
		}
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

}
