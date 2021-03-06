package com.jone.social.govern.reward.mapper;

/**
 * @author zouzujiang
 */

import com.jone.social.govern.reward.domian.RewardCoin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 奖励金币记录Mapper组件
 */
@Mapper
public interface RewardCoinMapper {

    /**
     * 插入奖励金币记录
     *
     * @param rewardCoin 奖励金币记录
     */
    @Insert("INSERT INTO reward_coin(reviewer_id,coins) " +
            "VALUES(#{reviewerId},#{coins})")
    void insert(RewardCoin rewardCoin);
}
