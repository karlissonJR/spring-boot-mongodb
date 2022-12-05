package com.example.springbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch(UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDateTime convertDate(String textDate, LocalDateTime defaultValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        textDate += " 00:00:00";
        System.out.println("CERGINHO = " + textDate);
        return LocalDateTime.parse(textDate, formatter);
    }

}
