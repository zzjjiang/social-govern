package com.jone.social.govern.report.service.impl;

import com.jone.social.govern.report.dao.ReportTaskDAO;
import com.jone.social.govern.report.domian.ReportTask;
import com.jone.social.govern.report.service.ReportTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zouzujiang
 */
@Service
public class ReportTaskServiceImpl implements ReportTaskService {

    /**
     * 举报任务DAO组件
     */
    @Resource
    private ReportTaskDAO reportTaskDAO;

    /**
     * 增加举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTask.setVoteResult(ReportTask.VOTE_RESULT_UNKNOWN);
        reportTaskDAO.add(reportTask);
    }

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    @Override
    public ReportTask queryById(Long id) {
        return reportTaskDAO.queryById(id);
    }
}
