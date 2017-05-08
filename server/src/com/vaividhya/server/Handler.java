package com.vaividhya.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;


import com.vaividhya.server.webscoket.WsHandler;
import org.apache.log4j.Logger;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.NanoHTTPD.ResponseException;

public class Handler {

    public static Logger log = Logger.getLogger("pathik");

    SimpleWebServer server;
    WsHandler wsHandler;

    public static Connection conn = null;

    public Handler(SimpleWebServer server) {
        try {


            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Config.db_name + "?user=" + Config.mysql_user + "&password=" + Config.mysql_password + "&autoReconnect=true&failOverReadOnly=false&maxReconnects=5");

            Timer timer = new Timer();
            TimerTask hourlyTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        PreparedStatement prst = conn.prepareStatement("SELECT 1;");
                        prst.executeQuery();
                    } catch (SQLException e) {
                    }

                }
            };


            timer.schedule(hourlyTask, 0l, 1000 * 60 * 60);

        } catch (SQLException e) {
            log.error("my sql connection erre", e);

            System.out.print("err");
        }
        this.server = server;
        wsHandler = new WsHandler();


    }


    public Response serve(IHTTPSession session) {

        Map<String, String> header = session.getHeaders();
        Map<String, String> parms = session.getParms();
        String uri = session.getUri();

        String method = session.getMethod().toString();
        if (method.equalsIgnoreCase("GET")) {
            return GET(session, header, parms, uri);
        } else if (method.equalsIgnoreCase("POST")) {
            return POST(session, header, parms, uri);
        }

        return createResponse(Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "404 not found");
    }


    private Response POST(IHTTPSession session, Map<String, String> header, Map<String, String> parms, String uri) {


        String username = parms.get("username");
        String password = parms.get("password");

        if (isAdminExits(username, password)) {
            try {
                Map<String, String> files = new HashMap<String, String>();
                session.parseBody(files);

                System.out.println(files);
                System.out.println(uri);

                Set<String> keys = files.keySet();
                for (String key : keys) {
                    String name = key;
                    String location = files.get(key);

                    File tempfile = new File(location);
                    Files.copy(tempfile.toPath(), new File("./web" + uri + name).toPath(), StandardCopyOption.REPLACE_EXISTING);

                    updatePosterLastTime(parms.get("type"), Integer.parseInt(parms.get("id")));
                }


            } catch (IOException | ResponseException e) {
                log.error("Handler :i am error file upload post ", e);

            }
            return createResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, "ohk ,upload success ");
        }

        return createResponse(Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "hey, you are not admin...");
    }


    public Response GET(IHTTPSession session, Map<String, String> header, Map<String, String> parms, String uri) {


        String keyparm = parms.get("key");
        if (keyparm != null) {


            int key;
            try {
                key = Integer.parseInt(keyparm);
            } catch (Exception e) {
                key = 0;
            }

            Response rs = wsHandler.connect(session, key);
            if (rs != null) {
                return rs;
            }
        }


        if (uri.length() > 1) {
            if (uri.charAt(uri.length() - 1) == '/') {

            } else {

				/*if(uri.equalsIgnoreCase("/this-is-server-test-config")){
                    String configparm = parms.get("config");
					if(configparm != null){
						switch (configparm) {
						case "user":
							return createResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, WsHandler.userList.getUserList());
						case "admin":
							return createResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, WsHandler.userList.getAdminList());
						case "server":
							return createResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, Config.getServerTest());
						}						
					}
					
				}*/

                return null;
            }

        } else {
            return null;
        }

        return createResponse(Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "sorry can't open for you...");

    }


    private Response createResponse(Response.Status status, String mimeType, String message) {
        Response res = new Response(status, mimeType, message);
        res.addHeader("Accept-Ranges", "bytes");
        return res;
    }


    public void updatePosterLastTime(String type, int event_id) {
        int command = 0;
        String qurey_string = null;


        switch (type) {
            case "event":
                qurey_string = "UPDATE events SET last_poster_update = ? WHERE id = ?;";
                command = Command.WS_ANDROID_REFRESH_FOR_UPDATE_EVENT;
                break;

            case "student":
                qurey_string = "UPDATE " + type + " SET last_image_update = ? WHERE id = ?;";
                command = Command.WS_ANDROID_REFRESH_FOR_UPDATE_STUDENT;
                break;

            case "faculty":
                qurey_string = "UPDATE " + type + " SET last_image_update = ? WHERE id = ?;";
                command = Command.WS_ANDROID_REFRESH_FOR_UPDATE_FACULTY;
                break;

            case "sponsor":
                qurey_string = "UPDATE " + type + " SET last_image_update = ? WHERE id = ?;";
                command = Command.WS_ANDROID_REFRESH_FOR_UPDATE_SPONSOR;
                break;

            default:
                break;
        }


        if (command != 0) {

            try {

                long currentTime = Calendar.getInstance().getTime().getTime();

                PreparedStatement prstEvent = Handler.conn.prepareStatement(qurey_string);
                prstEvent.setString(1, currentTime + "");
                prstEvent.setInt(2, event_id);


                int rowUpdate = prstEvent.executeUpdate();

                WsHandler.userList.refreshUserUpdateready(command);


            } catch (SQLException e) {
                log.error("Handler :error last time update", e);
            }

        }
    }


    public boolean isAdminExits(String username, String password) {
        try {
            PreparedStatement pstm = Handler.conn.prepareStatement("SELECT * FROM user WHERE id = ? AND pass = ?;");
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            log.error("Handler :error isAdminExits file upload", e);
        }

        return false;
    }


}
