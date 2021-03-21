package com.jone.social.govern.report.dao;

import com.jone.social.govern.report.domian.ReportTaskVote;

import java.util.List;

/**
 * 举报任务投票DAO接口
 * @author zouzujiang
 */
public interface ReportTaskVoteDAO {

    /**
     * 增加举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    void add(ReportTaskVote reportTaskVote);

    /**
     * 更新举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    void update(ReportTaskVote reportTaskVote);

    /**
     * 查询举报任务的所有投票
     * @param reportTaskId 举报任务id
     * @return 举报任务投票
     */
    List<ReportTaskVote> queryByReportTaskId(Long reportTaskId);
}
