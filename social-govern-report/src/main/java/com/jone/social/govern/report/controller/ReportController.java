package com.jone.social.govern.report.controller;

import com.jone.social.govern.report.domian.ReportTask;
import com.jone.social.govern.report.domian.ReportTaskVote;
import com.jone.social.govern.report.service.ReportTaskService;
import com.jone.social.govern.report.service.ReportTaskVoteService;
import com.jone.social.govern.reviewer.api.ReviewerService;
import com.jone.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zouzujiang
 */
@RestController
public class ReportController {

    /**
     * 举报任务Service组件
     */
    @Resource
    private ReportTaskService reportTaskService;
    /**
     * 举报任务投票Service组件
     */
    @Resource
    private ReportTaskVoteService reportTaskVoteService;

    /**
     * 评审员服务
     */
    @DubboReference
    private ReviewerService reviewerService;

    /**
     * 奖励服务
     */
    @DubboReference
    private RewardService rewardService;

    /**
     * 提交举报接口
     * @param reportTask 举报任务
     * @return
     */
    @GetMapping("/report")
    public String report(ReportTask reportTask) {
        // 在本地数据库增加一个举报任务
        reportTaskService.add(reportTask);

        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(
                reportTask.getId());
        // 在本地数据库初始化这批评审员对举报任务的投票状态
        reportTaskVoteService.initVotes(reviewerIds, reportTask.getId());

        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员.....");

        return "success";
    }

    /**
     * 查询举报任务
     * @param id 举报任务id
     * @return
     */
    @GetMapping("/report/query/{id}")
    public ReportTask queryReportTaskId(
            @PathVariable("id") Long id) {
        return reportTaskService.queryById(id);
    }

    /**
     * 对举报任务进行投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     * @param voteResult 投票结果
     * @return
     */
    @GetMapping("/report/vote")
    public String vote(
            Long reviewerId,
            Long reportTaskId,
            Integer voteResult) {
        // 本地数据库记录投票
        reportTaskVoteService.vote(reviewerId, reportTaskId, voteResult);
        // 调用评审员服务，标记本次投票结束
        reviewerService.finishVote(reviewerId, reportTaskId);

        // 对举报任务进行归票
        Boolean hasFinishedVote = reportTaskVoteService
                .calculateVotes(reportTaskId);

        // 如果举报任务得到归票结果
        if(hasFinishedVote) {
            // 发放奖励
            List<ReportTaskVote> reportTaskVotes = reportTaskVoteService
                    .queryByReportTaskId(reportTaskId);
            List<Long> reviewerIds = new ArrayList<>();

            for(ReportTaskVote reportTaskVote : reportTaskVotes) {
                reviewerIds.add(reportTaskVote.getReviewerId());
            }

            rewardService.giveReward(reviewerIds);

            // 推送消息到MQ，告知其他系统，本次评审结果
            System.out.println("推送消息到MQ，告知其他系统，本次评审结果");
        }

        return "success";
    }

}
