package com.tutorialspoint;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnect {
	private static SessionFactory factory;
	public static SessionFactory getSessionFatoryObject() {
		if(factory == null) {
			Configuration cfg=new Configuration();
			cfg.configure("/com/tutorialspoint/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		}
		System.out.println("configured sessionfactor");
		return factory;
	}
}
