package com.xuguang.servlet.chat.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xuguang.servlet.chat.main.Counter;

public class CounterInitListener implements HttpSessionListener {
	public static final String ONLINE_NAME = "onLineName";
	private int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext sc = session.getServletContext();
		Counter c = (Counter) sc.getAttribute(CounterListener.COUNTER_NAME);
		String name = "游客" + count;
		while (!c.addOnLine(name)) {
			count++;
			name = "游客" + count;
		}
		session.setAttribute(ONLINE_NAME, name);
		StringBuilder chatInfo = (StringBuilder) sc
				.getAttribute(CounterListener.CHAT);
		chatInfo.append(String.format("%s加入了！%n", name));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		ServletContext sc = session.getServletContext();
		Counter c = (Counter) sc.getAttribute(CounterListener.COUNTER_NAME);
		String name = session.getAttribute(ONLINE_NAME).toString();
		c.removeOnLine(name);
		StringBuilder chatInfo = (StringBuilder) sc
				.getAttribute(CounterListener.CHAT);
		chatInfo.append(String.format("%s离开了！%n", name));
	}

}
