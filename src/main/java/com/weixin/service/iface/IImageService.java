package com.weixin.service.iface;

import com.weixin.entity.mongo.Image;
import com.weixin.vo.PaginationVo;

/**
 * Image service interface
 * @author 		Jay
 * @time		2015-6-4
 */
public interface IImageService {

	
	/**
	 * save image
	 * @param image	image
	 */
	void saveImage(Image image);
	
	/**
	 * find image by pagination
	 * @param page
	 * @param size
	 * @return PaginationVo 
	 */
	PaginationVo findImageByPagination(Integer page,Integer size);
	
	/**
	 * find image by id
	 * @param id
	 * @return	Image
	 */
	Image findImageById(String id);
	
	/**
	 * delete image by id
	 * @param id
	 */
	void deleteImageById(String id);
	
}

