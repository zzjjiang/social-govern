package com.jone.social.govern.report.dao.impl;

import com.jone.social.govern.report.dao.ReportTaskDAO;
import com.jone.social.govern.report.domian.ReportTask;
import com.jone.social.govern.report.mapper.ReportTaskMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zouzujiang
 */
@Repository
public class ReportTaskDAOImpl implements ReportTaskDAO {

    /**
     * 举报任务Mapper组件
     */
    @Resource
    private ReportTaskMapper reportTaskMapper;

    /**
     * 增加举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTaskMapper.insert(reportTask);
    }

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    @Override
    public ReportTask queryById(Long id) {
        return reportTaskMapper.selectById(id);
    }

    /**
     * 更新举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void update(ReportTask reportTask) {
        reportTaskMapper.update(reportTask);
    }
}
