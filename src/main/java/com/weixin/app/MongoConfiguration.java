//package com.weixin.app;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//
///**
//* @author	jay
//* @since	2016年6月8日
//*/
//@Configuration
//@EnableMongoRepositories
//public class MongoConfiguration extends AbstractMongoConfiguration{
//
//	@Override
//	protected String getDatabaseName() {
//		return "test";
//	}
//
//	@Override
//	public Mongo mongo() throws Exception {
//		return new MongoClient();
//	}
//	
//	@Override
//    protected String getMappingBasePackage()
//    {
//        return "com.weixin.repository.mongo";
//    }
//
//}
