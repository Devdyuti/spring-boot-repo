package org.tutorial.jcr.data.migration.test;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

public class SecondHop {
	public static void main(String[] args) throws Exception{
		Repository repository=JcrUtils.getRepository();
		Session session=repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
		
		try {
			
			//Store Content
			Node root=session.getRootNode();
			
//			Node hello=root.addNode("hello");
//			Node world=hello.addNode("world");
//			world.setProperty("messgae", "Hello World!");
//			session.save();
			
			//Retrieve Content
			Node node=root.getNode("hello");
			System.out.println("PATH: "+node.getPath());
			//System.out.println("PROPERTY: "+node.getProperty("message").getString());
			
			//Remove Content
			//root.getNode("hello").remove();
			session.save();
		}finally {
			session.logout();
		}
	}
}
