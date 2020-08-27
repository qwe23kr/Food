package com.cl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cl.dao.ClInfoDAO;
import com.cl.servlet.InitServlet;
import com.cl.vo.ClInfoVO;

public class ClInfoDAOImpl implements ClInfoDAO {

	@Override
	public int insertUserInfo(ClInfoVO cl) {
		String sql = "insert into user_info(\r\n" + "num,id,pw,name,\r\n"
				+ "email,kind,phone,nickname,\r\n" + "admin)\r\n" + "values(\r\n"
				+ "?,?, ?, ?,\r\n" + "?,?,?,?,\r\n" + "?)";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cl.getNum());
			ps.setString(2, cl.getId());
			ps.setString(3, cl.getPw());
			ps.setString(4, cl.getName());
			ps.setString(5, cl.getEmail());
			ps.setString(6, cl.getKind());
			ps.setString(7, cl.getPhone());
			ps.setString(8, cl.getNickname());
			ps.setString(9, cl.getAdmin());
			
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}

	@Override
	public int updateUserInfo(ClInfoVO cl) {
		String sql = "update user_info\r\n" + 
				"set id=?,\r\n" + 
				"pw=?,\r\n" + 
				"name=?,\r\n" + 
				"email=?,\r\n" + 
				"kind=?,\r\n" + 
				"phone=?\r\n" + 
				"nickname=?\r\n" + 
				"where ui_num=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cl.getId());
			ps.setString(2, cl.getPw());
			ps.setString(3, cl.getName());
			ps.setString(4, cl.getEmail());
			ps.setString(5, cl.getKind());
			ps.setString(6, cl.getPhone());
			ps.setString(7, cl.getNickname());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}
	@Override
	public int deleteUserInfo(ClInfoVO cl) {
		String sql = "delete from food where num=?";
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cl.getNum());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}


	@Override
	public ClInfoVO selectUserInfo(ClInfoVO cl) {
		String sql = "select * from food where num=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cl.getNum());
			rs = ps.executeQuery();
			while(rs.next()) {
				ClInfoVO tCl = new ClInfoVO();
				tCl.setId(rs.getString("id"));
				tCl.setNum(rs.getInt("num"));
				tCl.setName(rs.getString("name"));
				tCl.setAdmin(rs.getString("admin"));
				tCl.setEmail(rs.getString("email"));
				tCl.setNickname(rs.getString("nickname"));
				tCl.setKind(rs.getString("kind"));
				tCl.setPhone(rs.getString("phone"));
				return tCl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return null;
	}

	@Override
	public List<ClInfoVO> selectUserInfoList(ClInfoVO cl) {
		List<ClInfoVO> clList = new ArrayList<>();
		String sql = "select * from food";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ClInfoVO tCl = new ClInfoVO();
				tCl.setId(rs.getString("id"));
				tCl.setNum(rs.getInt("num"));
				tCl.setName(rs.getString("name"));
				tCl.setAdmin(rs.getString("admin"));
				tCl.setEmail(rs.getString("email"));
				tCl.setNickname(rs.getString("nickname"));
				tCl.setKind(rs.getString("kind"));
				tCl.setPhone(rs.getString("phone"));
				clList.add(tCl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return clList;
	}

	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		ClInfoDAO uidao = new ClInfoDAOImpl();
		ClInfoVO ui = new ClInfoVO();
//		ui.setUiNum(54);
		System.out.println(uidao.selectUserInfoList(ui));
	}
}

