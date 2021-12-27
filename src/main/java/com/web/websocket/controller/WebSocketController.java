package com.web.websocket.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.websocket.vo.RoomListVO;

@Controller
public class WebSocketController {
	
	private static RoomListVO roomVO = new RoomListVO();
	
	// 채팅방 입장
//	@RequestMapping(value = "/echo", method = RequestMethod.GET)
//	public String view_chat(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//
//		return "echo";
//	}
	
	public String roomList(RoomListVO roomListVO) {
		System.out.println(roomListVO.getRoomList());
		if(roomListVO.getRoomList()!=null) {
			roomVO.setRoomList(roomListVO.getRoomList());
			return "redirect:/home/roomList";
		}
		System.out.println(roomVO.getRoomList());
		return "roomList";
	}
	
	@RequestMapping(value = "/home/roomList", method = RequestMethod.GET)
	public String roomList(HttpSession session) {
		session.setAttribute("roomList",roomVO.getRoomList());
		System.out.println(session.getAttribute("roomList"));
		return "roomList";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/webSocket2", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
				
		return "webSocket2";
	}


}