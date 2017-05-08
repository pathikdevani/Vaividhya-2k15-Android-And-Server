package com.vaividhya.server.webscoket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

import com.vaividhya.server.Command;
import com.vaividhya.server.Handler;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.WebSocket;
import fi.iki.elonen.WebSocketFrame;
import fi.iki.elonen.WebSocketFrame.CloseCode;

public class WsWebsiteAdmin extends WebSocket{

	private WsUser admin;
	private boolean isLogin;
	
	public WsWebsiteAdmin(IHTTPSession handshakeRequest, WsUser admin) {
		super(handshakeRequest);
		
		this.admin = admin;
		this.admin.setWebSocket(this);
		WsHandler.userList.addAdmin(admin);
		isLogin = false;
		
	}

	@Override
	protected void onPong(WebSocketFrame pongFrame) {
		
	}

	

	

	@Override
	protected void onClose(CloseCode code, String reason, boolean initiatedByRemote) {
		WsHandler.userList.removeAdmin(admin);
	}

	@Override
	protected void onException(IOException e) {
		WsHandler.userList.removeAdmin(admin);
		
	}
	
	
	
	@Override
	protected void onMessage(WebSocketFrame messageFrame) {
		
		
		
		try {
			
			ByteArrayInputStream baIs = new ByteArrayInputStream(messageFrame.getBinaryPayload());
			DataInputStream daIs = new DataInputStream(baIs);
			
			int count = daIs.readInt();
			int command = daIs.readInt();
			
			
			if(isLogin){
				doWork(count,command,daIs);
				
			}else {
				DataSend data = new DataSend();
				data.add(count);
				
				if(command == Command.WS_ADMIN_LOGIN){
					if(doLogin(daIs)){
						System.out.println("login ok");
						isLogin = true;
						data.add(1);
					}else {
						data.add(0);
					}
					data.send(this);
				}
			}
			
		} catch (IOException e) {
			Handler.log.error("WsWebsiteAdmin : Command reading errore",e);
		}	
	}
	
	
	
	public void sendData(ByteArrayOutputStream data){
		try {
			send(data.toByteArray());
		} catch (IOException e) {
			Handler.log.error("WsWebsiteAdmin : sending erroe",e);
		}
	}
	
	private boolean doLogin(DataInputStream daIs) throws IOException{
	
		try {
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM user WHERE id = ? AND pass = ?;");
			
			String usrename = daIs.readUTF();
			String pass = daIs.readUTF();
			
			
			Handler.log.debug(usrename);
			Handler.log.debug(pass);
			
			
			pstm.setString(1, usrename);
			pstm.setString(2, pass);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			Handler.log.error("WaWebsiteAdmin : dologin errore" ,e);
			
		}
		
		return false;
	}

	private void doWork(int count, int command, DataInputStream daIs) throws IOException{
		
		DataSend data = new DataSend();
		data.add(count);
		
		
		switch (command) {
		
		

			case Command.WS_ADMIN_PING:
				onPing(data);
				break;
			
			
			//for event	
			case Command.WS_ADMIN_GET_NAME_ID_LIST:
				eventList(data);
				break;
				
			
			case Command.WS_ADMIN_GET_EVENT_BY_ID:
				eventById(daIs,data);
				break;	
				
			
			case Command.WS_ADMIN_UPDATE_EVENT:
				updateEvent(daIs,data);
				break;
				
			case Command.WS_ADMIN_ADD_EVENT:
				addEvent(daIs,data);
				break;
				
			case Command.WS_ADMIN_DELETE_EVENT:
				deleteEvent(daIs,data);
				break;
				
				
				
			//for student	
			case Command.WS_ADMIN_GET_STUDET_NAME_ID_LIST:
				studentList(data);
				break;
				
			case Command.WS_ADMIN_GET_STUDENT_BY_ID:
				studentById(daIs,data);
				break;
				
			case Command.WS_ADMIN_DELETE_STUDENT:
				deleteStudent(daIs,data);
				break;
				
			case Command.WS_ADMIN_UPDATE_STUDENT:
				updateStudent(daIs,data);
				break;
				
			case Command.WS_ADMIN_ADD_STUDENT:
				addStudent(daIs,data);
				break;
				
				
				
				
			//for faculty	
			case Command.WS_ADMIN_GET_FACULTY_NAME_ID_LIST:
				facultyList(data);
				break;
				
			case Command.WS_ADMIN_GET_FACULTY_BY_ID:
				facultyById(daIs,data);
				break;
				
			case Command.WS_ADMIN_DELETE_FACULTY:
				deleteFaculty(daIs,data);
				break;
				
			case Command.WS_ADMIN_UPDATE_FACULTY:
				updateFaculty(daIs,data);
				break;
				
			case Command.WS_ADMIN_ADD_FACULTY:
				addFaculty(daIs,data);
				break;
				
				
				
				
				
			//for sponsor	
			case Command.WS_ADMIN_GET_SPONSOR_NAME_ID_LIST:
				sponsorList(data);
				break;
				
			case Command.WS_ADMIN_GET_SPONSOR_BY_ID:
				sponsorById(daIs,data);
				break;
				
			case Command.WS_ADMIN_DELETE_SPONSOR:
				deleteSopnsor(daIs,data);
				break;
				
			case Command.WS_ADMIN_UPDATE_SPONSOR:
				updateSponsor(daIs,data);
				break;
				
			case Command.WS_ADMIN_ADD_SPONSOR:
				addSponsor(daIs,data);
				break;
				
				
			//for news	
			case Command.WS_ADMIN_GET_NEWS_NAME_ID_LIST:
				newsList(data);
				break;
				
			case Command.WS_ADMIN_GET_NEWS_BY_ID:
				newsById(daIs,data);
				break;
				
			case Command.WS_ADMIN_DELETE_NEWS:
				deleteNews(daIs,data);
				break;
				
			case Command.WS_ADMIN_UPDATE_NEWS:
				updateNews(daIs,data);
				break;
				
			case Command.WS_ADMIN_ADD_NEWS:
				addNews(daIs,data);
				break;
				

			default:
				break;
		}
				
	}

	
	
	private void addNews(DataInputStream daIs, DataSend data) {
		
		try {
			String title = daIs.readUTF();
			String content = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			PreparedStatement prst = Handler.conn.prepareStatement("INSERT INTO news (title,content,last_update)" + "VALUES(?,?,?);");
			
			prst.setString(1, title);
			prst.setString(2, content);
			prst.setString(3, currentTime+"");
			
			int row = prst.executeUpdate();
			System.out.println("inser "+row);
			
			PreparedStatement prstLastID = Handler.conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet rsLatId = prstLastID.executeQuery();
			
			rsLatId.next();
			int id = rsLatId.getInt(1);
			System.out.println("id" + id);
			data.add(id);
			
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_NEWS);
			
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "erroe addNews "+Command.WS_ADMIN_ADD_NEWS,e);
			
		}
	}

	private void updateNews(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			String title = daIs.readUTF();
			String content = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			
			PreparedStatement prstEvent = Handler.conn.prepareStatement("UPDATE news SET title = ?, content = ?, last_update = ? WHERE id = ?;");
			prstEvent.setString(1, title);
			prstEvent.setString(2, content);
			prstEvent.setString(3, currentTime+"");
			prstEvent.setInt(4, id);
			
			
			int rowUpdate = prstEvent.executeUpdate();
			
			data.add(1);
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_NEWS);
			
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "error updateNews"+Command.WS_ADMIN_UPDATE_NEWS,e);
		}
	}

	private void deleteNews(DataInputStream daIs, DataSend data) {
		
		try {
			int id = daIs.readInt();
			
			PreparedStatement prst = Handler.conn.prepareStatement("DELETE FROM news WHERE id = ?;");
			prst.setInt(1, id);
			int row = prst.executeUpdate();
			
			data.add(1);
			data.send(this);
			
			/*File file = new File("./web/img/student/"+id+Command.file_type);
			if(file.exists())
				file.delete();*/
			
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_NEWS);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "erorre deleteNews "+Command.WS_ADMIN_DELETE_NEWS,e);
		}
	}

	private void newsById(DataInputStream daIs, DataSend data) {
		
		try {
			
			int rq_id = daIs.readInt();
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM news WHERE id = ?;");
			pstm.setInt(1, rq_id);
			ResultSet rs = pstm.executeQuery();
			

			int rowCountEvent = getRowCount(rs);
			data.add(rowCountEvent);
			
			if(rs.next()){
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				
				data.add(id);;
				data.add(title);
				data.add(content);
			}
			
			data.send(this);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore newsById "+ Command.WS_ADMIN_GET_NEWS_BY_ID,e);
		}
	}

	private void newsList(DataSend data) {
		
		try {

			System.out.println("i am news list");
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT id,title FROM news ORDER BY last_update DESC;");
			ResultSet rs = prst.executeQuery();

			int rowCount = getRowCount(rs);
			data.add(rowCount);

			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);

				data.add(id);
				data.add(title);
			}

			data.send(this);

		} catch (SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore newsList "+Command.WS_ADMIN_GET_NEWS_NAME_ID_LIST,e);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	private void addStudent(DataInputStream daIs, DataSend data) {
		
		try {
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			PreparedStatement prst = Handler.conn.prepareStatement("INSERT INTO student (name,post,last_update,last_image_update)"
											+ "VALUES(?,?,?,?);");
			
			prst.setString(1, name);
			prst.setString(2, post);
			prst.setString(3, currentTime+"");
			prst.setString(4, currentTime+"");
			
			int row = prst.executeUpdate();
			System.out.println("inser "+row);
			
			PreparedStatement prstLastID = Handler.conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet rsLatId = prstLastID.executeQuery();
			
			rsLatId.next();
			int id = rsLatId.getInt(1);
			System.out.println("id" + id);
			data.add(id);
			
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_STUDENT);
			
			
		} catch (IOException | SQLException e) {
			
			
			Handler.log.error("WsWebsiteAdmin : " + "erroe addStudent "+Command.WS_ADMIN_ADD_STUDENT,e);
			
		}
	}

	private void updateStudent(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			
			PreparedStatement prstEvent = Handler.conn.prepareStatement("UPDATE student SET name = ?, post = ?, last_update = ? WHERE id = ?;");
			prstEvent.setString(1, name);
			prstEvent.setString(2, post);
			prstEvent.setString(3, currentTime+"");
			prstEvent.setInt(4, id);
			
			
			int rowUpdate = prstEvent.executeUpdate();
			
			data.add(1);
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_STUDENT);
			
			
		} catch (IOException | SQLException e) {

			Handler.log.error("WsWebsiteAdmin : " + "error updateStudent"+Command.WS_ADMIN_UPDATE_STUDENT,e);
		}
	}

	private void deleteStudent(DataInputStream daIs, DataSend data) {
		
		try {
			int id = daIs.readInt();
			
			PreparedStatement prst = Handler.conn.prepareStatement("DELETE FROM student WHERE id = ?;");
			prst.setInt(1, id);
			int row = prst.executeUpdate();
			
			data.add(1);
			data.send(this);
			
			File file = new File("./web/img/student/"+id+Command.file_type);
			if(file.exists())
				file.delete();
			
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_STUDENT);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "erorre deleteStudent "+Command.WS_ADMIN_DELETE_STUDENT,e);

		}
	}

	private void studentById(DataInputStream daIs, DataSend data) {
		
		try {
			int rq_id = daIs.readInt();
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM student WHERE id = ?;");
			pstm.setInt(1, rq_id);
			ResultSet rs = pstm.executeQuery();
			

			int rowCountEvent = getRowCount(rs);
			data.add(rowCountEvent);
			
			if(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				
				data.add(id);;
				data.add(name);
				data.add(post);
			}
			
			data.send(this);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore studentbyid "+ 2101,e);
		}
	}

	private void studentList(DataSend data) {
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT id,name FROM student;");
			ResultSet rs = prst.executeQuery();

			int rowCount = getRowCount(rs);
			data.add(rowCount);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);

				data.add(id);
				data.add(name);
			}

			data.send(this);

		} catch (SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "errore studentList "+2100,e);
		}
		
	}
	
	
	
	
	private void addFaculty(DataInputStream daIs, DataSend data) {
		try {
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			PreparedStatement prst = Handler.conn.prepareStatement("INSERT INTO faculty (name,post,last_update,last_image_update)"
											+ "VALUES(?,?,?,?);");
			
			prst.setString(1, name);
			prst.setString(2, post);
			prst.setString(3, currentTime+"");
			prst.setString(4, currentTime+"");
			
			int row = prst.executeUpdate();
			System.out.println("inser "+row);
			
			PreparedStatement prstLastID = Handler.conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet rsLatId = prstLastID.executeQuery();
			
			rsLatId.next();
			int id = rsLatId.getInt(1);
			System.out.println("id" + id);
			data.add(id);
			
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_FACULTY);
			
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "erroe addFaculty "+Command.WS_ADMIN_ADD_FACULTY,e);
		}
	}

	private void updateFaculty(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			
			PreparedStatement prstEvent = Handler.conn.prepareStatement("UPDATE faculty SET name = ?, post = ?, last_update = ? WHERE id = ?;");
			prstEvent.setString(1, name);
			prstEvent.setString(2, post);
			prstEvent.setString(3, currentTime+"");
			prstEvent.setInt(4, id);
			
			
			int rowUpdate = prstEvent.executeUpdate();
			
			data.add(1);
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_FACULTY);
			
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "error updateFaculty"+Command.WS_ADMIN_UPDATE_FACULTY,e);
		}
		
	}
	
	private void deleteFaculty(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			PreparedStatement prst = Handler.conn.prepareStatement("DELETE FROM faculty WHERE id = ?;");
			prst.setInt(1, id);
			int row = prst.executeUpdate();
			
			data.add(1);
			data.send(this);
			
			File file = new File("./web/img/faculty/"+id+Command.file_type);
			if(file.exists())
				file.delete();
			
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_FACULTY);
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "erorre deleteFaculty "+Command.WS_ADMIN_DELETE_FACULTY,e);
		}
	}
	
	
	private void facultyById(DataInputStream daIs, DataSend data) {
		
		try {
			int rq_id = daIs.readInt();
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM faculty WHERE id = ?;");
			pstm.setInt(1, rq_id);
			ResultSet rs = pstm.executeQuery();
			

			int rowCountEvent = getRowCount(rs);
			data.add(rowCountEvent);
			
			if(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				
				data.add(id);;
				data.add(name);
				data.add(post);
			}
			
			data.send(this);
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "errore facultybyid "+ 2201,e);
		}
	}

	private void facultyList(DataSend data) {
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT id,name FROM faculty;");
			ResultSet rs = prst.executeQuery();

			int rowCount = getRowCount(rs);
			data.add(rowCount);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);

				data.add(id);
				data.add(name);
			}

			data.send(this);

		} catch (SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "errore facultyList "+2200,e);

		}
		
	}
	
	
	
	
	
	private void addSponsor(DataInputStream daIs, DataSend data) {
		try {
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			PreparedStatement prst = Handler.conn.prepareStatement("INSERT INTO sponsor (name,post,last_update,last_image_update)"
											+ "VALUES(?,?,?,?);");
			
			prst.setString(1, name);
			prst.setString(2, post);
			prst.setString(3, currentTime+"");
			prst.setString(4, currentTime+"");
			
			int row = prst.executeUpdate();
			System.out.println("inser "+row);
			
			PreparedStatement prstLastID = Handler.conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet rsLatId = prstLastID.executeQuery();
			
			rsLatId.next();
			int id = rsLatId.getInt(1);
			System.out.println("id" + id);
			data.add(id);
			
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_SPONSOR);
			
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "erroe addSponsor "+Command.WS_ADMIN_ADD_FACULTY,e);
		}
	}

	private void updateSponsor(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			String name = daIs.readUTF();
			String post = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			
			PreparedStatement prstEvent = Handler.conn.prepareStatement("UPDATE sponsor SET name = ?, post = ?, last_update = ? WHERE id = ?;");
			prstEvent.setString(1, name);
			prstEvent.setString(2, post);
			prstEvent.setString(3, currentTime+"");
			prstEvent.setInt(4, id);
			
			
			int rowUpdate = prstEvent.executeUpdate();
			
			data.add(1);
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_SPONSOR);
			
			
		} catch (IOException | SQLException e) {

			Handler.log.error("WsWebsiteAdmin : " + "error updateSponsor"+Command.WS_ADMIN_UPDATE_SPONSOR,e);
		}
		
	}

	private void deleteSopnsor(DataInputStream daIs, DataSend data) {
		try {
			int id = daIs.readInt();
			
			PreparedStatement prst = Handler.conn.prepareStatement("DELETE FROM sponsor WHERE id = ?;");
			prst.setInt(1, id);
			int row = prst.executeUpdate();
			
			data.add(1);
			data.send(this);
			
			File file = new File("./web/img/sponsor/"+id+Command.file_type);
			if(file.exists())
				file.delete();
			
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_SPONSOR);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "erorre deleteSopnsor "+Command.WS_ADMIN_DELETE_SPONSOR,e);
		}
	}
	
	private void sponsorById(DataInputStream daIs, DataSend data) {
		
		try {
			int rq_id = daIs.readInt();
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM sponsor WHERE id = ?;");
			pstm.setInt(1, rq_id);
			ResultSet rs = pstm.executeQuery();
			

			int rowCountEvent = getRowCount(rs);
			data.add(rowCountEvent);
			
			if(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String post = rs.getString(3);
				
				data.add(id);;
				data.add(name);
				data.add(post);
			}
			
			data.send(this);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore sponsorbyid "+ 2301,e);
		}
	}

	private void sponsorList(DataSend data) {
		
		try {
			PreparedStatement prst = Handler.conn.prepareStatement("SELECT id,name FROM sponsor;");
			ResultSet rs = prst.executeQuery();

			int rowCount = getRowCount(rs);
			data.add(rowCount);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);

				data.add(id);
				data.add(name);
			}

			data.send(this);

		} catch (SQLException e) {

			Handler.log.error("WsWebsiteAdmin : " + "errore sponsorList "+2300,e);
		}
		
	}
	
	 
	  
	private void onPing(DataSend data) {
		data.add(1);
		data.send(this);
	}

	private void deleteEvent(DataInputStream daIs, DataSend data) {
		
		try {
			int id = daIs.readInt();
			
			PreparedStatement prst = Handler.conn.prepareStatement("DELETE FROM events WHERE id = ?;");
			prst.setInt(1, id);
			int row = prst.executeUpdate();
			
			data.add(1);
			data.send(this);
			
			File file = new File("./web/img/event/"+id+Command.file_type);
			if(file.exists())
				file.delete();
			
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_EVENT);
			
		} catch (IOException | SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "erorre "+Command.WS_ADMIN_DELETE_EVENT,e);
			
		}
		
	}

	private void addEvent(DataInputStream daIs, DataSend data) {
		try {
			String name = daIs.readUTF();
			String time = daIs.readUTF();
			String type = daIs.readUTF();
			String tag = daIs.readUTF();
			String location = daIs.readUTF();
			String intro = daIs.readUTF();
			String task = daIs.readUTF();
			String rule = daIs.readUTF();
			String share_link = daIs.readUTF();
			
			String coordinator1_name = daIs.readUTF();
			String coordinator1_email = daIs.readUTF();
			
			String coordinator2_name = daIs.readUTF();
			String coordinator2_email = daIs.readUTF();
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			PreparedStatement prst = Handler.conn.prepareStatement("INSERT INTO events (name,time,type,tag,location,intro,task,rule,share_link,co1_name,co1_email,co2_name,co2_email,last_update,last_poster_update,color_code)"
											+ "VALUES(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?,?);");
			
			prst.setString(1, name);
			prst.setString(2, time);
			prst.setString(3, type);
			prst.setString(4, tag);
			prst.setString(5, location);
			prst.setString(6, intro);
			prst.setString(7, task);
			prst.setString(8, rule);
			prst.setString(9, share_link);
			prst.setString(10, coordinator1_name);
			prst.setString(11, coordinator1_email);
			prst.setString(12, coordinator2_name);
			prst.setString(13, coordinator2_email);
			prst.setString(14, currentTime+"");
			prst.setString(15, currentTime+"");
			prst.setInt(16, new Random().nextInt(12));
			
			int row = prst.executeUpdate();
			System.out.println("inser "+row);
			
			PreparedStatement prstLastID = Handler.conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet rsLatId = prstLastID.executeQuery();
			
			rsLatId.next();
			data.add(rsLatId.getInt(1));
			
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_EVENT);
			
			
		} catch (IOException | SQLException e) {
			Handler.log.error("WsWebsiteAdmin : " + "erroe "+Command.WS_ADMIN_ADD_EVENT,e);
		}
		
	}

	private void updateEvent(DataInputStream daIs, DataSend data) {
		
		
		try {
			int id = daIs.readInt();
			
			String name = daIs.readUTF();
			
			Handler.log.debug(name);
			
			
			String time = daIs.readUTF();
			Handler.log.debug(time);
			
			String type = daIs.readUTF();
			Handler.log.debug(type);
			
			String tag = daIs.readUTF();
			Handler.log.debug(tag);
			
			String location = daIs.readUTF();
			Handler.log.debug(location);
			
			String intro = daIs.readUTF();
			Handler.log.debug(intro);
			
			
			Handler.log.debug("okokok");
			String task = daIs.readUTF();
			Handler.log.debug(task);
			
			String rule = daIs.readUTF();
			Handler.log.debug(rule);
			
			String share_link = daIs.readUTF();
			Handler.log.debug(share_link);
			
			String coordinator1_name = daIs.readUTF();
			Handler.log.debug(coordinator1_name);
			String coordinator1_email = daIs.readUTF();
			Handler.log.debug(coordinator1_email);
			
			String coordinator2_name = daIs.readUTF();
			Handler.log.debug(coordinator2_name);
			String coordinator2_email = daIs.readUTF();
			Handler.log.debug(coordinator2_email);
			
			long currentTime = Calendar.getInstance().getTime().getTime();
			
			
			
			PreparedStatement prstEvent = Handler.conn.prepareStatement("UPDATE events SET name = ?, time = ?, type = ?,"
											+ " tag = ?, location = ? ,intro = ?, task= ?, rule = ?,share_link = ?,"
											+ " co1_name = ?, co1_email =? ,co2_name = ?, co2_email = ?,last_update = ? WHERE id = ?;");
			prstEvent.setString(1, name);
			prstEvent.setString(2, time);
			prstEvent.setString(3, type);
			prstEvent.setString(4, tag);
			prstEvent.setString(5, location);
			prstEvent.setString(6, intro);
			prstEvent.setString(7, task);
			prstEvent.setString(8, rule);
			prstEvent.setString(9, share_link);
			prstEvent.setString(10, coordinator1_name);
			prstEvent.setString(11, coordinator1_email);
			prstEvent.setString(12, coordinator2_name);
			prstEvent.setString(13, coordinator2_email);
			prstEvent.setString(14, currentTime+"");
			prstEvent.setInt(15, id);
			
			
			int rowUpdate = prstEvent.executeUpdate();
			
			
			data.add(1);
			data.send(this);
			WsHandler.userList.refreshUserUpdateready(Command.WS_ANDROID_REFRESH_FOR_UPDATE_EVENT);
			
			
			
		} catch (IOException | SQLException e) {
			

			Handler.log.error("WsWebsiteAdmin : " +"error "+Command.WS_ADMIN_UPDATE_EVENT,e);
		}
		
		
	}

	private void eventById(DataInputStream daIs, DataSend data) {
		
		try {
			
			
			int eventId = daIs.readInt();
			
			PreparedStatement pstmEvent = Handler.conn.prepareStatement("SELECT * FROM events WHERE id = ?;");
			pstmEvent.setInt(1, eventId);
			ResultSet rsEvent = pstmEvent.executeQuery();
			
			int rowCountEvent = getRowCount(rsEvent);
			data.add(rowCountEvent);
			
			
			/*PreparedStatement pstmCoordinator = Handler.conn.prepareStatement("SELECT name,email FROM coordinator WHERE event_id = ?;");
			pstmCoordinator.setInt(1, eventId);
			ResultSet rsCoordinator = pstmCoordinator.executeQuery();*/
			
			
			while (rsEvent.next()) {
				data.add(rsEvent.getInt(1));
				data.add(rsEvent.getString(2));
				data.add(rsEvent.getString(3));
				data.add(rsEvent.getString(4));
				data.add(rsEvent.getString(5));
				data.add(rsEvent.getString(6));
				data.add(rsEvent.getString(7));
				data.add(rsEvent.getString(8));
				data.add(rsEvent.getString(9));
				data.add(rsEvent.getString(10));
				data.add(rsEvent.getString(11));
				data.add(rsEvent.getString(12));
				data.add(rsEvent.getString(13));
				data.add(rsEvent.getString(14));
				
				/*while (rsCoordinator.next()) {
					data.add(rsCoordinator.getString(1));
					data.add(rsCoordinator.getString(2));
				}*/
			}
			
			data.send(this);
		} catch (SQLException | IOException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore command "+Command.WS_ADMIN_GET_EVENT_BY_ID,e);
			
		}
		
	}

	private void eventList(DataSend data) {
		
		try {
			PreparedStatement pstm = Handler.conn.prepareStatement("SELECT id,name FROM events;");
			ResultSet rs = pstm.executeQuery();
			
			int rowCount = getRowCount(rs);
			data.add(rowCount);
			
			while (rs.next()) {
				data.add(rs.getInt(1));
				data.add(rs.getString(2));
			}
			
			data.send(this);
		} catch (SQLException e) {
			
			Handler.log.error("WsWebsiteAdmin : " + "errore command "+Command.WS_ADMIN_GET_NAME_ID_LIST,e);
		}
		
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
