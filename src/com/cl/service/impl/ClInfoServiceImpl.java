package com.cl.service.impl;

import java.util.List;

import com.cl.dao.ClInfoDAO;
import com.cl.dao.impl.ClInfoDAOImpl;
import com.cl.service.ClInfoService;
import com.cl.vo.ClInfoVO;

public class ClInfoServiceImpl implements ClInfoService {
	private ClInfoDAO cldao = new ClInfoDAOImpl();
	@Override
	public int insertUserInfo(ClInfoVO cl) {
		return cldao.insertUserInfo(cl);
		}


	@Override
	public int updateUserInfo(ClInfoVO cl) {
		return cldao.updateUserInfo(cl);
		}


	@Override
	public int deleteUserInfo(ClInfoVO cl) {
		return cldao.deleteUserInfo(cl);
		}


	@Override
	public ClInfoVO selectUserInfo(ClInfoVO cl) {
		return cldao.selectUserInfo(cl);
		}

	@Override
	public List<ClInfoVO> selectUserInfoList(ClInfoVO cl) {
		return cldao.selectUserInfoList(cl);
	}

}