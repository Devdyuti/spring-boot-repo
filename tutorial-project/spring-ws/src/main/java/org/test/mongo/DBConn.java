package org.test.mongo;

import java.net.ConnectException;

import com.mongodb.MongoClient;
import com.mongodb.MongoSocketOpenException;

public class DBConn {
	
	public static MongoClient getConnection() throws ConnectException {
		try {
			return new MongoClient("localhost", 27017);
		}catch (MongoSocketOpenException e) {
			System.err.println("#Exception opening socket: "+e);
		}
		return null;
	}
}
