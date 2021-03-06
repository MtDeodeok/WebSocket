package com.web.websocket.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.web.websocket.controller.WebSocketController;
import com.web.websocket.vo.RoomListVO;


public class RoomList {
	RoomListVO roomListVO = new RoomListVO();
	WebSocketController controller = new WebSocketController();
	// WebSocketHandler2를 통해 받아온 sessionList 분해
	/* sessionList의 size 만큼 반복해서
	 * index의 key값 bang_id의 value 값을 bangID에 저장
	 * index의 key값 session의 값을 joiner에 저장
	 * 두개의 값을 roomMap에 넣고, 그걸 resultList에 넣음.
	 * 그 값 중 bang_id에 해당하는 것만 list에 넣어서
	 * RoomListVO에 저장함.
	 * 저장한 값을 controller의 메소드 roomList로 보냄
	*/
	public void roomListDecomposition(List<Map<String, Object>> sessionList) {
		List<Map> resultList = new LinkedList<Map>();
		String bangID = "";
		String joiner = "";
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, String> roomMap = new HashMap<String, String>();
			if (bangID.indexOf(sessionList.get(i).get("bang_id").toString()) == -1) {
				bangID += bangID.equals("") ? sessionList.get(i).get("bang_id").toString()
						: "," + sessionList.get(i).get("bang_id").toString();

				roomMap.put("bang_id", sessionList.get(i).get("bang_id").toString());
				joiner = sessionList.get(i).get("session").toString();
				for (int j = i + 1; j < sessionList.size(); j++) {
					if (sessionList.get(i).get("bang_id").equals(sessionList.get(j).get("bang_id"))) {
						joiner += joiner.equals("") ? sessionList.get(j).get("session").toString()
								: "," + sessionList.get(j).get("session").toString();
					}
				}

				roomMap.put("session", joiner);
				resultList.add(roomMap);
				System.out.println("resultList : " + resultList);
			}
			
			List<String> list = new ArrayList<String>();
			for (int n = 0; n < resultList.size(); n++) {
				String bang_id = (String) resultList.get(n).get("bang_id");
				list.add(bang_id);
			}
			System.out.println("List : " + list);
			roomListVO.setRoomList(list);;
			System.out.println("roomListVO : "+roomListVO);
			controller.roomList(roomListVO);
		}
	}
	
}
