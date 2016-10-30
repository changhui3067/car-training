package com.car.training.service;

import com.car.training.domain.AutobotsComment;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface AutobotsCommentService {

    /**
     * 新增汽车人评论信息
     */
    void save(AutobotsComment autobotsComment);

    /**
     * 更新汽车人评论信息
     */
    void update(AutobotsComment autobotsComment);

    /**
     * 删除汽车人评论信息
     */
    void delete(String id);

    /**
     * 获取汽车人评论信息
     **/
    AutobotsComment findById(String id);

    /**
     * 获取汽车人评论列表
     */
    ResultPage<AutobotsComment> findPageByAutobotsComment(AutobotsComment autobotsComment, Integer pageSize, Integer pageNo);

    /**
     * 获取汽车人评论列表
     */
    List<AutobotsComment> findListByAutobotsComment(AutobotsComment autobotsComment);

}
