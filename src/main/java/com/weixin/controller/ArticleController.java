package com.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weixin.service.iface.ArticleService;
import com.weixin.vo.ArticleVo;
import com.weixin.vo.PaginationVo;

/**
 * @author       Jay
 * @time         2015年5月27日
 */
@RestController
@RequestMapping("api/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value="getArticles",method=RequestMethod.GET)
	public PaginationVo getArtilces(@RequestParam(value="page" ,defaultValue = "1") Integer page,@RequestParam(value="size",defaultValue="6") Integer size){
		PaginationVo paginationVo =  articleService.findAritcleByPagination(page, size);
		return paginationVo;
	}
	
	@RequestMapping("getArticleById")
	public ArticleVo getArticleById(@RequestParam(value="id" ,defaultValue = "1") String id){
		ArticleVo articleVo =  articleService.findArticleByArticleId(id);
		return articleVo;
	}
	
	@RequestMapping(value="saveArticle",method=RequestMethod.POST)
	public ArticleVo saveArticle(@RequestBody ArticleVo articleVo){
		articleService.saveArticle(articleVo);
		return articleVo;
	}
}
