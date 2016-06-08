package com.weixin.common;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author jay
 * @since 2016年6月8日
 */
public class TestMongodbConnect {
	public static void main(String args[]) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("test");
			DBCollection coll = db.getCollection("test");
			DBObject myDoc = coll.findOne();
			System.out.println(myDoc);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
