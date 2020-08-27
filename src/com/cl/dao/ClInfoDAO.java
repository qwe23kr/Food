package com.cl.dao;

import java.util.List;

import com.cl.vo.ClInfoVO;

public interface ClInfoDAO {

	int insertUserInfo(ClInfoVO cl);
	int updateUserInfo(ClInfoVO cl);
	int deleteUserInfo(ClInfoVO cl);
	ClInfoVO selectUserInfo(ClInfoVO cl);
	List<ClInfoVO> selectUserInfoList(ClInfoVO cl);
}
