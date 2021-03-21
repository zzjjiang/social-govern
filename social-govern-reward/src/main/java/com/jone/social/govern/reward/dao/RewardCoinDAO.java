package com.jone.social.govern.reward.dao;
import com.jone.social.govern.reward.domian.RewardCoin;

/**
 * 奖励金币DAO接口
 * @author zouzujiang
 */
public interface RewardCoinDAO {

    /**
     * 增加奖励金币记录
     * @param rewardCoin 奖励金币记录
     */
    void add(RewardCoin rewardCoin);

}
