package com.alura.services;

import java.util.ArrayList;

public class History {
    
    protected static ArrayList<String> conversionHistory = new ArrayList<>();

    public static ArrayList<String> getConversionHistory() {
        return conversionHistory;
    }

    public static void newHistoryEntry(String newEntry) {
        conversionHistory.add(newEntry);
    }
}
