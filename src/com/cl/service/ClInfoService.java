package com.cl.service;

import java.util.List;

import com.cl.vo.ClInfoVO;

public interface ClInfoService {

	int insertUserInfo(ClInfoVO cl);
	int updateUserInfo(ClInfoVO cl);
	int deleteUserInfo(ClInfoVO cl);
	ClInfoVO selectUserInfo(ClInfoVO cl);
	List<ClInfoVO> selectUserInfoList(ClInfoVO cl);
}
