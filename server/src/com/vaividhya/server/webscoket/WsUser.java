package com.vaividhya.server.webscoket;


import fi.iki.elonen.WebSocket;

public class WsUser {
	
	private WsType type;
	private WebSocket webSocket;
	
	public WsUser(WsType type) {
		this.type = type;
	}
	
	public WebSocket getWebSocket() {
		return webSocket;
	}

	public void setWebSocket(WebSocket webSocket) {
		this.webSocket = webSocket;
	}
	
	public WsType getType(){
		return type;
	}

	public void setType(WsType type){
		this.type = type;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		WsUser guest = (WsUser) obj;
		return (guest.webSocket == webSocket);

	}
}

