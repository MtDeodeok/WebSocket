package com.web.websocket.util;

import com.web.websocket.vo.RoomListVO;

public class CheckRoom {
	RoomListVO roomVO = new RoomListVO();
	public void test(RoomListVO roomListVO) {
		System.out.println(roomListVO.getRoomList());
		roomVO.setRoomList(roomListVO.getRoomList());
		System.out.println("roomVO test : "+roomVO.getRoomList());
	}
}
