package com.jone.social.govern.reward.api;

import java.util.List;

/**
 * @author zouzujiang
 */
public interface RewardService {

    /**
     * 发放奖励
     * @param reviewerIds 评审员id
     */
    void giveReward(List<Long> reviewerIds);
}
