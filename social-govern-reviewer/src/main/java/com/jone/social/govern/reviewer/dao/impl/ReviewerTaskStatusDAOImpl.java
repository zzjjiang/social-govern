package com.jone.social.govern.reviewer.dao.impl;

import com.jone.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.jone.social.govern.reviewer.domain.ReviewerTaskStatus;
import com.jone.social.govern.reviewer.mapper.ReviewerTaskStatusMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zouzujiang
 */
@Repository
public class ReviewerTaskStatusDAOImpl implements ReviewerTaskStatusDAO {

    /**
     * 评审员处理任务Mapper组件
     */
    @Resource
    private ReviewerTaskStatusMapper reviewerTaskStatusMapper;

    /**
     * 增加评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    @Override
    public void add(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.insert(reviewerTaskStatus);
    }

    /**
     * 更新评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    @Override
    public void update(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.update(reviewerTaskStatus);
    }
}
