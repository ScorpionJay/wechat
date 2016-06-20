package com.weixin.service.iface;

import java.util.Date;
import java.util.List;

import com.weixin.vo.ArticleVo;
import com.weixin.vo.PaginationVo;

/**
 * Created by Jay on 2015/5/26.
 */
public interface ArticleService {

	/**
	 * 新增文章
	 * @param articleVo	文章vo
	 */
    void saveArticle(ArticleVo articleVo);
    
    
    /**
	 * 删除文章
	 * @param articleId	文章id
	 */
    void deleteArticleByArticleId(String articleId);
	
    /**
     * 根据文章id获取文章
     * @param articleId     文章id
     * @return
     */
    ArticleVo findArticleByArticleId(String articleId);

    /**
     * 获取根据时间排序后的文章
     * @param date      时间
     * @return
     */
    List<ArticleVo> findAritcleBySortWithDate(Date date);

    /**
     * 根据分页页码和每页显示数量获取文章
     * @param pageNumber    页码
     * @param pageSize      每页显示数量
     * @return PaginationVo 分页对象
     */
    PaginationVo findAritcleByPagination(Integer pageNumber,Integer pageSize);

}
