package com.jone.social.govern.report.dao;

import com.jone.social.govern.report.domian.ReportTask;

/**
 * 举报任务DAO接口
 * @author zouzujiang
 */
public interface ReportTaskDAO {

    /**
     * 增加一个举报任务
     * @param reportTask 举报任务
     */
    void add(ReportTask reportTask);

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    ReportTask queryById(Long id);

    /**
     * 更新举报任务
     * @param reportTask 举报任务
     */
    void update(ReportTask reportTask);

}
