package com.vaividhya.server.webscoket;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vaividhya.server.Command;
import com.vaividhya.server.Handler;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.WebSocket;
import fi.iki.elonen.WebSocketFrame;
import fi.iki.elonen.WebSocketFrame.CloseCode;

public class WsAndroid extends WebSocket{

	private WsUser user;
	
	public WsAndroid(IHTTPSession handshakeRequest,WsUser user) {
		super(handshakeRequest);
	
		this.user = user;
		this.user.setWebSocket(this);
		WsHandler.userList.addUser(user);
	}

	@Override
	protected void onPong(WebSocketFrame pongFrame) {
		
	}

	@Override
	protected void onMessage(WebSocketFrame messageFrame) {
		
		try {
			
			ByteArrayInputStream baIs = new ByteArrayInputStream(messageFrame.getBinaryPayload());
			DataInputStream daIs = new DataInputStream(baIs);
	
			int command = daIs.readInt();
		
			doWork(command,daIs);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doWork(int command, DataInputStream daIs) {

		DataSend data = new DataSend();
		data.add(command);
		
		switch (command) {
		
		case Command.WS_ANDROID_GET_EVENT_LIST:
			getEventList(data);
			break;
			
		case Command.WS_ANDROID_GET_STUDENT_LIST:
			getStudenttList(data);
			break;
			
		case Command.WS_ANDROID_GET_FACULTY_LIST:
			getFacultyList(data);
			break;
			
		case Command.WS_ANDROID_GET_SPONSOR_LIST:
			getSponsorList(data);
			break;
			
		case Command.WS_ANDROID_GET_NEWS_LIST:
			getNewsList(data);
			break;

		default:
			break;
		}
		
	}
	
	
	private void getNewsList(DataSend data) {
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT * FROM news;");
			ResultSet rs = prst.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String last_update = rs.getString(4);
				
				
				data.add(id);
				data.add(title);
				data.add(content);
				data.add(last_update);
				
			}
			data.send(this);
			
		} catch (SQLException e) {
			
			Handler.log.error("WsAndroid :" + "errorget getNewsList "+Command.WS_ANDROID_GET_NEWS_LIST,e);
		}
	}
	

	private void getSponsorList(DataSend data) {
		System.out.println("getSponsorList cilent");
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT * FROM sponsor;");
			ResultSet rs = prst.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				String last_update = rs.getString(4);
				String last_poster_update = rs.getString(5);
				
				
				data.add(id);
				data.add(name);
				data.add(post);
				data.add(last_update);
				data.add(last_poster_update);
				
			}
			data.send(this);
			
		} catch (SQLException e) {

			Handler.log.error("WsAndroid :" + "errorget getFacultyList "+Command.WS_ANDROID_GET_SPONSOR_LIST,e);
		}
	}

	private void getFacultyList(DataSend data) {
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT * FROM faculty;");
			ResultSet rs = prst.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				String last_update = rs.getString(4);
				String last_poster_update = rs.getString(5);
				
				
				data.add(id);
				data.add(name);
				data.add(post);
				data.add(last_update);
				data.add(last_poster_update);
				
			}
			data.send(this);
			
		} catch (SQLException e) {
			Handler.log.error("WsAndroid :" + "errorget getFacultyList "+Command.WS_ANDROID_GET_FACULTY_LIST,e);
		}
		
	}

	private void getStudenttList(DataSend data) {
		
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT * FROM student;");
			ResultSet rs = prst.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				String last_update = rs.getString(4);
				String last_poster_update = rs.getString(5);
				
				
				data.add(id);
				data.add(name);
				data.add(post);
				data.add(last_update);
				data.add(last_poster_update);
				
			}
			data.send(this);
			
		} catch (SQLException e) {
			Handler.log.error("WsAndroid :" + "errorget StudenttList "+Command.WS_ANDROID_GET_STUDENT_LIST,e);
		}
		
	}

	private void getEventList(DataSend data) {
		
		System.out.println("getevent list cilent");
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT * FROM events;");
			ResultSet rs = prst.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String time = rs.getString(3);
				String type = rs.getString(4);
				String tag = rs.getString(5);
				String location = rs.getString(6);
				String intro = rs.getString(7);
				String task = rs.getString(8);
				String rule = rs.getString(9);
				String share_link = rs.getString(10);
				String co1_name = rs.getString(11);
				String co1_email = rs.getString(12);
				String co2_name = rs.getString(13);
				String co2_email = rs.getString(14);
				String last_update = rs.getString(15);
				String last_poster_update = rs.getString(16);
				int color_code = rs.getInt(17);
				
				
				data.add(id);
				data.add(name);
				data.add(time);
				data.add(type);
				data.add(tag);
				data.add(location);
				data.add(intro);
				data.add(task);
				data.add(rule);
				data.add(share_link);
				data.add(co1_name);
				data.add(co1_email);
				data.add(co2_name);
				data.add(co2_email);
				data.add(last_update);
				data.add(last_poster_update);
				data.add(color_code);
				
			}
			data.send(this);
			
		} catch (SQLException e) {

			Handler.log.error("WsAndroid :" + "errorget getEventList "+Command.WS_ANDROID_GET_EVENT_LIST,e);
		}
		
		
	}

	@Override
	protected void onClose(CloseCode code, String reason, boolean initiatedByRemote) {
		WsHandler.userList.removeUser(user);
	}

	@Override
	protected void onException(IOException e) {
		WsHandler.userList.removeUser(user);
		
	}
	
	
	public int getRowCount(ResultSet set) throws SQLException{

		int rowCount;
		int currentRow = set.getRow();            // Get current row
		rowCount = set.last() ? set.getRow() : 0; // Determine number of rows
		if (currentRow == 0)                      // If there was no current row
			set.beforeFirst();                     // We want next() to go to first row
		else                                      // If there WAS a current row
			set.absolute(currentRow);              // Restore it
		return rowCount;
	}

	
	
	

}
