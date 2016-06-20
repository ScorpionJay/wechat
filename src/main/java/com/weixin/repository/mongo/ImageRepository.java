package com.weixin.repository.mongo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.weixin.entity.mongo.Image;

/**
 * Image repository
 * @author 		Jay
 * @time		2015-6-4
 */
public interface ImageRepository extends PagingAndSortingRepository<Image, String>{

}

