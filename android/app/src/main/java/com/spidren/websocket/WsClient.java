package com.spidren.websocket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.handshake.ServerHandshake;

import android.util.Log;

import com.spidren.database.DBEvent;
import com.spidren.database.DBFaculty;
import com.spidren.database.DBNews;
import com.spidren.database.DBSponsor;
import com.spidren.database.DBStudent;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;


public class WsClient extends WebSocketClient{

	public static final int WS_GET_EVENT_LIST = 3001;
	public static final int WS_GET_STUDENT_LIST = 3002;
	public static final int WS_GET_FACULTY_LIST = 3003;
	public static final int WS_GET_SPONSOR_LIST = 3004;
	public static final int WS_GET_NEWS_LIST = 3005;
	
	
	public static final int WS_EVENT_UPDATE_READY = 3101;
	public static final int WS_STUDENT_UPDATE_READY = 3102;
	public static final int WS_FACULTY_UPDATE_READY = 3103;
	public static final int WS_SPONSOR_UPDATE_READY = 3104;
	public static final int WS_NEWS_UPDATE_READY = 3105;
	
	
	private Timer timer;
	
	public WsClient(URI serverURI) {
		super(serverURI);
		
		timer = new Timer();
	}
	

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		
		Config.isConnected = true;
		
		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				FramedataImpl1 frame = new FramedataImpl1(Opcode.PING);
				frame.setFin(true);
				sendFrame(frame);
			}
		}, 0,3000);
		
		
		data_list_request(WS_GET_EVENT_LIST);
		data_list_request(WS_GET_STUDENT_LIST);
		data_list_request(WS_GET_FACULTY_LIST);
		data_list_request(WS_GET_SPONSOR_LIST);
		data_list_request(WS_GET_NEWS_LIST);
		
	}

	
	@Override
	public void onMessage(ByteBuffer bytes) {
		super.onMessage(bytes);
		
		
		
		try {
			ByteArrayInputStream Bin = new ByteArrayInputStream(bytes.array());
			DataInputStream Din = new DataInputStream(Bin);
			
			int command = Din.readInt();
			
			doWork(command,Din);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("onmessage command reading error");
			e.printStackTrace();
		}
		
		
		
	}
	
	private void doWork(int command, DataInputStream din) {
		
		
		switch (command) {
		
		case WS_GET_EVENT_LIST:
			eventListResponse(din);
			break;
			
		case WS_GET_STUDENT_LIST:
			studentListResponse(din);
			break;
			
		case WS_GET_FACULTY_LIST:
			facultyListResponse(din);
			break;
			
		case WS_GET_SPONSOR_LIST:
			sponsorListResponse(din);
			break;
		case WS_GET_NEWS_LIST:
			newsListResponse(din);
			break;
			
			
			
			

		case WS_EVENT_UPDATE_READY:
			data_list_request(WS_GET_EVENT_LIST);
			break;			
			
		case WS_STUDENT_UPDATE_READY:
			Log.i("My", "i am student update");
			data_list_request(WS_GET_STUDENT_LIST);
			break;			
			
		case WS_FACULTY_UPDATE_READY:
			data_list_request(WS_GET_FACULTY_LIST);
			break;			
			
		case WS_SPONSOR_UPDATE_READY:
			data_list_request(WS_GET_SPONSOR_LIST);
			break;			
		case WS_NEWS_UPDATE_READY:
			data_list_request(WS_GET_NEWS_LIST);
			break;			
			
		default:
			break;
		}
		
		
		
		
	}
	
	
	
	private void newsListResponse(DataInputStream din) {
		
		try {
			ArrayList<DBNews> list = new ArrayList<DBNews>();
			int rowCount = din.readInt();
			
			for (int i = 0; i < rowCount; i++) {
				
				int id = din.readInt();
				
				String title = din.readUTF();
				String content = din.readUTF();
				
				String last_update = din.readUTF();
				
				DBNews news = new DBNews();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setLastUpdate(Long.parseLong(last_update));
				
				list.add(news);
			}
			
			MainActivity.db.addNews(list);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("i am errore newsListResponse ");
			e.printStackTrace();
		}
	}
	
	
	
	private void sponsorListResponse(DataInputStream din) {
		
		try {
			ArrayList<DBSponsor> list = new ArrayList<DBSponsor>();
			int rowCount = din.readInt();
			
			for (int i = 0; i < rowCount; i++) {
				
				int id = din.readInt();
				
				String name = din.readUTF();
				String post = din.readUTF();
				
				String last_update = din.readUTF();
				String last_image_update = din.readUTF();
				
				DBSponsor sponsor = new DBSponsor();
				sponsor.setId(id);
				sponsor.setName(name);
				sponsor.setPost(post);
				sponsor.setLast_update(Long.parseLong(last_update));
				sponsor.setLast_image_update(Long.parseLong(last_image_update));
				
				list.add(sponsor);

			}
			
			MainActivity.db.addSponsors(list);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("i am errore sponsorListResponse 3004");
			e.printStackTrace();
		}
	}

	private void facultyListResponse(DataInputStream din) {
		try {
			ArrayList<DBFaculty> list = new ArrayList<DBFaculty>();
			int rowCount = din.readInt();
			
			for (int i = 0; i < rowCount; i++) {
				
				int id = din.readInt();
				
				String name = din.readUTF();
				String post = din.readUTF();
				
				String last_update = din.readUTF();
				String last_image_update = din.readUTF();
				
				DBFaculty faculty = new DBFaculty();
				faculty.setId(id);
				faculty.setName(name);
				faculty.setPost(post);
				faculty.setLast_update(Long.parseLong(last_update));
				faculty.setLast_image_update(Long.parseLong(last_image_update));
				
				list.add(faculty);

			}
			
			MainActivity.db.addFacultys(list);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("i am errore facultyListResponse 3003");
			e.printStackTrace();
		}
	}

	public void studentListResponse(DataInputStream din){
		
		
		try {
			ArrayList<DBStudent> list = new ArrayList<DBStudent>();
			int rowCount = din.readInt();
			
			for (int i = 0; i < rowCount; i++) {
				
				int id = din.readInt();
				
				String name = din.readUTF();
				String post = din.readUTF();
				
				String last_update = din.readUTF();
				String last_image_update = din.readUTF();
				
				DBStudent student = new DBStudent();
				student.setId(id);
				student.setName(name);
				student.setPost(post);
				student.setLast_update(Long.parseLong(last_update));
				student.setLast_image_update(Long.parseLong(last_image_update));
				
				list.add(student);

				//MainActivity.cf.Log(student.toString());
				
			}
			
			MainActivity.db.addStudents(list);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("i am errore studentListResponse 3002");
			e.printStackTrace();
		}
	}
	
	
	

	private void eventListResponse(DataInputStream din) {
		Log.i("My", "i am studenlist wsclient responde");
		try {
			
			ArrayList<DBEvent> list = new ArrayList<DBEvent>();
			int rowCount = din.readInt();
			
			for (int i = 0; i < rowCount; i++) {
				
				int id = din.readInt();
				
				String name = din.readUTF();
				String time = din.readUTF();
				String type = din.readUTF();
				String tag = din.readUTF();
				String location = din.readUTF();
				String intro = din.readUTF();
				String task = din.readUTF();
				String rule = din.readUTF();
				String share_link = din.readUTF();
				
				String co1_name = din.readUTF();
				String co1_email = din.readUTF();
				
				String co2_name = din.readUTF();
				String co2_email = din.readUTF();
				
				String last_update = din.readUTF();
				String last_poster_update = din.readUTF();
				
				int color_code = din.readInt();
				
				DBEvent event = new DBEvent();
				event.setId(id);
				event.setName(name);
				event.setTime(time);
				event.setType(type);
				event.setTag(tag);
				event.setLocation(location);
				event.setIntro(intro);
				event.setTask(task);
				event.setRule(rule);
				event.setShareLink(share_link);

				event.setCo1_name(co1_name);
				event.setCo1_email(co1_email);
				
				event.setCo2_name(co2_name);
				event.setCo2_email(co2_email);
				
				event.setLast_update(Long.parseLong(last_update));
				event.setLast_poster_update(Long.parseLong(last_poster_update));
				
				event.set_color_code(color_code);
				
				list.add(event);
				
				/*MainActivity.cf.Log("id="+id+",name="+name+",time="+time+",type="+type+",tag="+tag+",loaction="+location
									+",intro="+intro+",task="+task+",rule="+rule+",share_link="+share_link+",co1_name="+co1_name
									+",co1_email="+co1_email+",co2_name="+co2_name+",co2_email="+co2_email
									+",last_upadate="+last_update+",last_poster_update="+last_poster_update);*/
			}
			
			MainActivity.db.addEvents(list);
			
		} catch (IOException e) {
			//MainActivity.cf.Log("i am errore eventListResponse 3001");
			e.printStackTrace();
		}
		
	}
	
	
	

	
	private void data_list_request(int command) {
		
		
		try {
			ByteArrayOutputStream Bout = new ByteArrayOutputStream();
			DataOutputStream Dout = new DataOutputStream(Bout);
			
			Dout.writeInt(command);
			
			send(Bout.toByteArray());
			
		} catch (IOException e) {
			//MainActivity.cf.Log("errore get event list request " + command);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onMessage(String message) {
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		Config.isConnected = false;
	}

	@Override
	public void onError(Exception ex) {
		Config.isConnected = false;
	}

}
