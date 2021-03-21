package com.jone.social.govern.reward.service;

import com.jone.social.govern.reward.api.RewardService;
import com.jone.social.govern.reward.dao.RewardCoinDAO;
import com.jone.social.govern.reward.domian.RewardCoin;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zouzujiang
 */
@DubboService
public class RewardServiceImpl implements RewardService {

    /**
     * 奖励金币DAO组件
     */
    @Autowired
    private RewardCoinDAO rewardCoinDAO;

    /**
     * 发放奖励
     * @param reviewerIds 评审员id
     */
    @Override
    public void giveReward(List<Long> reviewerIds) {
        for(Long reviewerId : reviewerIds) {
            RewardCoin rewardCoin = new RewardCoin();
            rewardCoin.setReviewerId(reviewerId);
            rewardCoin.setCoins(10L);
            rewardCoinDAO.add(rewardCoin);
        }
    }

}
