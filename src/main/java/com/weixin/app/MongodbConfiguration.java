package com.weixin.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author jay
 * @since 2016.6.16
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.weixin.repository.mongo")
public class MongodbConfiguration extends AbstractMongoConfiguration {

	@Value("${mongo.host}")
	private String MONGO_DB_HOST;

	@Value("${mongo.port}")
	private int MONGO_DB_PORT;

	@Value("${mongo.db}")
	private String DB;
	
	@Value("${mongo.username}")
	private String username;
	
	@Value("${mongo.password}")
	private String password;
	
	@Value("${mongo.auth}")
	private Boolean auth;
	

	@Override
	protected String getDatabaseName() {
		return DB;
	}

	@Bean
	@Override
	public Mongo mongo() throws Exception {
		if(auth){
			ServerAddress serverAddress = new ServerAddress(MONGO_DB_HOST,MONGO_DB_PORT);  
	         List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
	         addrs.add(serverAddress);  
	           
	         //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
	         MongoCredential credential = MongoCredential.createScramSha1Credential(username, "admin", password.toCharArray());  
	         List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
	         credentials.add(credential);  
	           
	         //通过连接认证获取MongoDB连接  
	         MongoClient mongoClient = new MongoClient(addrs,credentials);  
	         return mongoClient;
		}else{
			return new MongoClient(MONGO_DB_HOST, MONGO_DB_PORT);
		}
	}
}