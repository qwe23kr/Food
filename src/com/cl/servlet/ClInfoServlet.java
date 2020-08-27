package com.cl.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.service.ClInfoService;
import com.cl.service.impl.ClInfoServiceImpl;
import com.cl.vo.ClInfoVO;
import com.google.gson.Gson;

@WebServlet("/ajax/user")
public class ClInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClInfoService clService = new ClInfoServiceImpl();   
    private Gson gs = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		String json = "";
		PrintWriter pw = response.getWriter();
		if("list".equals(cmd)) {
			json = gs.toJson(clService.selectUserInfoList(null));
		}else if("view".equals(cmd)) {
			if(request.getParameter("Num")==null) {
				throw new ServletException("유저번호를 확인하세요");
			}else {
				int Num = Integer.parseInt(request.getParameter("uiNum"));
				ClInfoVO cl = new ClInfoVO();
				cl.setNum(Num);
				json = gs.toJson(clService.selectUserInfo(cl));
			}
		}else {
			throw new ServletException("잘못된 접근입니다.");
		}
		pw.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		BufferedReader br = request.getReader();
		String str;
		StringBuffer sb = new StringBuffer();
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		ClInfoVO cl = gs.fromJson(sb.toString(), ClInfoVO.class);
		Map<String,Integer> rMap = new HashMap<>();
		if("insert".equals(cl.getCmd())) {
			rMap.put("result", clService.insertUserInfo(cl));
		}else if("update".equals(cl.getCmd())) {
			rMap.put("result", clService.updateUserInfo(cl));
		}else if("delete".equals(cl.getCmd())) {
			rMap.put("result", clService.deleteUserInfo(cl));
		}
		String json = gs.toJson(rMap);
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}

}
