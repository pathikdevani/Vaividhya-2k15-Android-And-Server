package com.vaividhya.server.webscoket;

import com.vaividhya.server.Command;

import fi.iki.elonen.IWebSocketFactory;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.WebSocket;
import fi.iki.elonen.WebSocketResponseHandler;
import fi.iki.elonen.NanoHTTPD.IHTTPSession;

public class WsHandler {

	public static WsUserList userList;
	WebSocketResponseHandler webscResponseHandler;
	IWebSocketFactory iWebSocketFactory;
	
	public WsHandler() {
		
		userList = new WsUserList();
		iWebSocketFactory = new IWebSocketFactory() {
			@Override
			public WebSocket openWebSocket(IHTTPSession handshake, WsUser user) {
				
				if(user.getType() == WsType.WS_ANDROID){
					return new WsAndroid(handshake, user);
				}else {
					return new WsWebsiteAdmin(handshake, user);
				}	
			}
		};
		
		webscResponseHandler = new WebSocketResponseHandler(iWebSocketFactory);
	}
	
	
	public Response connect(IHTTPSession session, int key){
		
		switch (key) {
		case Command.WS_ANDROID:
				return webscResponseHandler.serve(session, new WsUser(WsType.WS_ANDROID));

		case Command.WS_WEBSITE_ADMIN:
			return webscResponseHandler.serve(session, new WsUser(WsType.WS_WEBSITE_ADMIN));
		}
		
		return null;
	}
	
}
