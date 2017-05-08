package fi.iki.elonen;

import com.vaividhya.server.webscoket.WsUser;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;

public interface IWebSocketFactory {
    WebSocket openWebSocket(IHTTPSession handshake,WsUser user);
}
