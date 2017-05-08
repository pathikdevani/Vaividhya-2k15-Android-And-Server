package com.vaividhya.server.webscoket;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.vaividhya.server.Handler;

import fi.iki.elonen.WebSocket;

public class DataSend {

	private ArrayList<Object> list;
	
	public DataSend() {
		list = new ArrayList<Object>();
	}
	
	public void add(Object obj) {
		list.add(obj);
	}
	
	public void send(WebSocket webSocket) {
		try {
			webSocket.send(getByteArray());
		} catch (IOException e) {
			Handler.log.error("Data class sending error...",e);
		}
	}

	
	
	public byte[] getByteArray() {
		ByteArrayOutputStream Bout = new ByteArrayOutputStream();
		DataOutputStream Dout = new DataOutputStream(Bout);

		for (Object object : list) {

			try {
				if (object.getClass() == String.class) {
					Dout.writeUTF((String) object);
				} else if (object.getClass() == Integer.class) {
					Dout.writeInt((Integer) object);
				}
				Dout.close();
				Bout.close();
			} catch (IOException e) {
				Handler.log.error("Data getbytearry",e);
			}
		}

		return Bout.toByteArray();
	}
}
