package com.vaividhya.server.webscoket;

import java.util.ArrayList;


public class WsUserList {
	
	ArrayList<WsUser> adminList;
	ArrayList<WsUser> userList;
	
	public WsUserList() {
		adminList = new ArrayList<WsUser>();
		userList = new ArrayList<WsUser>();
	}
	
	
	public void addUser(WsUser user){
		if(!userList.contains(user)){
			userList.add(user);
		}
		System.out.println(userList.size()+" user connected now....");
	}
	
	public void removeUser(WsUser user){
		if(userList.contains(user)){
			userList.remove(user);
		}
		System.out.println(userList.size()+" user connected now....");
	}
	
	public void addAdmin(WsUser admin){
		if(!adminList.contains(admin)){
			adminList.add(admin);
		}
		System.out.println(adminList.size()+" admin connected now....");
		
	}
	
	public void removeAdmin(WsUser admin){
		if(adminList.contains(admin)){
			adminList.remove(admin);
		}
		System.out.println(adminList.size()+" admin connected now....");
	}
	
	public void refreshUserUpdateready(int command){
		
		System.out.println("update for "+command);
		
		for(int i= 0; i< userList.size();i++ ){
			DataSend data = new DataSend();
			data.add(command);
			
			data.send(userList.get(i).getWebSocket());
		}
	
	}
	
	
	
	public  String getUserList(){
		
		StringBuffer list = new StringBuffer();
		
		String init =  "total "+ userList.size() +" connected" + System.getProperty("line.separator") +
				"------------------------userlist------------------------" + System.getProperty("line.separator") 
				;
		
		list.append(init);
		
		for (int i = 0; i < userList.size(); i++) {
			list.append((i+1) + ") " + userList.get(i).getWebSocket().getHandshakeRequest().getHeaders().get("http-client-ip") + System.getProperty("line.separator"));
		}
		
		return list.toString();
	}
	
	
	public String getAdminList(){
		
		StringBuffer list = new StringBuffer();
		
		String init =  "total "+ adminList.size() +" connected" + System.getProperty("line.separator") +
				"------------------------adminlist------------------------" + System.getProperty("line.separator") 
				;
		
		list.append(init);
		
		for (int i = 0; i < adminList.size(); i++) {
			list.append((i+1) + ") " + adminList.get(i).getWebSocket().getHandshakeRequest().getHeaders().get("http-client-ip") + System.getProperty("line.separator"));
		}
		
		return list.toString();
	}
	
	
	
}
