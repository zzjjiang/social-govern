package com.jone.social.govern.reviewer.dao;

import com.jone.social.govern.reviewer.domain.ReviewerTaskStatus;

/**
 * 评审员处理任务状态DAO接口
 * @author zouzujiang
 */
public interface ReviewerTaskStatusDAO {

    /**
     * 增加评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    void add(ReviewerTaskStatus reviewerTaskStatus);

    /**
     * 更新评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    void update(ReviewerTaskStatus reviewerTaskStatus);
}
