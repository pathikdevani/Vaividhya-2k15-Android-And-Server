package com.spidren.vaividhya2k15;


import android.graphics.Color;

public class Config {
    //pathik.com is my local machine ip address
    //public static final String host = "pathik.com:3030";
    public static final String host = "192.168.0.100:3030";
    public static final String image_format = ".jpg";
    public static final String webscoket_link = "ws://" + host + "?key=1001";


    public static boolean isConnected = false;


    public static final String event_image_link = "http://" + host + "/img/event/";
    public static final String student_image_link = "http://" + host + "/img/student/";
    public static final String faculty_image_link = "http://" + host + "/img/faculty/";
    public static final String sponsor_image_link = "http://" + host + "/img/sponsor/";


    public static final int BACK_COLOR = Color.parseColor("#e5e5e5");


    public static String event_image_link(int id) {
        return event_image_link + id + image_format;
    }

    public static String student_image_link(int id) {
        return student_image_link + id + image_format;
    }

    public static String faculty_image_link(int id) {
        return faculty_image_link + id + image_format;
    }

    public static String sponsor_image_link(int id) {
        return sponsor_image_link + id + image_format;
    }
}
