package com.xuguang.servlet.chat.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xuguang.servlet.chat.main.Counter;

public class CounterListener implements ServletContextListener {
	public static final String COUNTER_NAME = "counter";
	public static final String CHAT = "chatInfo";
	public static final String FILE = "WEB-INF/counter.dat";
	private StringBuilder chatInfo = new StringBuilder();

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String root = sce.getServletContext().getRealPath("/");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(root + FILE));
			oos.writeObject(sce.getServletContext().getAttribute(COUNTER_NAME));
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sce.getServletContext().removeAttribute(COUNTER_NAME);
		sce.getServletContext().removeAttribute(CHAT);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Counter c = new Counter();
		String root = sce.getServletContext().getRealPath("/");
		File f = new File(root + FILE);
		if (f.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(f));
				c = (Counter) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		sce.getServletContext().setAttribute(COUNTER_NAME, c);
		sce.getServletContext().setAttribute(CHAT, chatInfo);
	}

}
