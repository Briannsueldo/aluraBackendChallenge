package com.alura.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Time {

    protected static ArrayList<String> dateHistory = new ArrayList<>();

    protected static ArrayList<String> getDateHistory() {
        return dateHistory;
    }

    protected static void saveDate() {

        LocalDateTime setDate = LocalDateTime.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = setDate.format(dateFormat);

        dateHistory.add(formattedDate);

        System.out.println(formattedDate);
    }

    public static void main(String[] args) {
        saveDate();
    }
}
