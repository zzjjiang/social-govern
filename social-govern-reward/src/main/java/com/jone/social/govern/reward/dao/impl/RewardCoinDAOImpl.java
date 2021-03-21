package com.jone.social.govern.reward.dao.impl;

import com.jone.social.govern.reward.dao.RewardCoinDAO;
import com.jone.social.govern.reward.domian.RewardCoin;
import com.jone.social.govern.reward.mapper.RewardCoinMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zouzujiang
 */
@Repository
public class RewardCoinDAOImpl implements RewardCoinDAO {

    /**
     * 奖励金币Mapper组件
     */
    @Resource
    private RewardCoinMapper rewardCoinMapper;

    /**
     * 增加奖励金币记录
     * @param rewardCoin 奖励金币记录
     */
    @Override
    public void add(RewardCoin rewardCoin) {
        rewardCoinMapper.insert(rewardCoin);
    }

}
