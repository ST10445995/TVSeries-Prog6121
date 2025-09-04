/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseries;

import java.util.ArrayList;


/**
 *
 * @author lab_services_student
 */
public class Series {
    // Helper method for searching a series by ID
public static SeriesModel searchSeriesById(String id, ArrayList<SeriesModel> seriesList) {
    for (SeriesModel s : seriesList) {
        if (s.SeriesId.equals(id)) {
            return s;
        }
    }
    return null;
}

// Helper method to update a series
public static boolean updateSeriesById(String id, String newName, String newAge, String newEpisodes, ArrayList<SeriesModel> seriesList) {
    for (SeriesModel s : seriesList) {
        if (s.SeriesId.equals(id)) {
            s.SeriesName = newName;
            s.SeriesAge = newAge;
            s.SeriesNumberOfEpisodes = newEpisodes;
            return true;
        }
    }
    return false;
}

// Helper method to delete a series
public static boolean deleteSeriesById(String id, ArrayList<SeriesModel> seriesList) {
    for (int i = 0; i < seriesList.size(); i++) {
        if (seriesList.get(i).SeriesId.equals(id)) {
            seriesList.remove(i);
            return true;
        }
    }
    return false;
}

// Helper method to validate age
public static boolean isValidAge(String ageInput) {
    try {
        int age = Integer.parseInt(ageInput);
        return age >= 2 && age <= 18;
    } catch (NumberFormatException e) {
        return false;
    }
}
}

    
   

