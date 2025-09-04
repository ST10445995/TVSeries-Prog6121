/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tvseries;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class TVSeriesTest {
    
    private TVSeries app;
    private SeriesModel sample;
    
    
    public TVSeriesTest() {
        
      
    }
        
        //Helper Methods
        private ArrayList<SeriesModel>getSampleData(){
            ArrayList<SeriesModel> list = new ArrayList<>();
            SeriesModel s1 = new SeriesModel();
            s1.SeriesId = "101";
            s1.SeriesName = "Extreme Sports";
            s1.SeriesAge = "12";
            s1.SeriesNumberOfEpisodes = "10";
            
            SeriesModel s2 = new SeriesModel();
            s2.SeriesId = "102";
            s2.SeriesName = "Comedy Central";
            s2.SeriesAge = "16";
            s2.SeriesNumberOfEpisodes = "20";
            
            list.add(s1);
            list.add(s2);
            
            return list;

    }
  
    /**
     * Test of searchSeries method, of class TVSeries.
     */
    @Test
    public void testSearchSeries() {
        ArrayList<SeriesModel> list = getSampleData();
        SeriesModel result = TVSeries.searchSeriesById("101", list);
        assertNotNull(result);
        assertEquals("Extreme Sports", result.SeriesName);
    }

    /**
     * Test of updateSeries method, of class TVSeries.
     */
    
     @Test
    public void TestSearchSeries_SeriesNotFound() {
        ArrayList<SeriesModel> list = getSampleData();
        SeriesModel result = TVSeries.searchSeriesById("999", list);
        assertNull(result);
    }
    /**
     * Test of updateSeries method, of class TVSeries.
     */
    @Test
    public void testUpdateSeries() {
        ArrayList<SeriesModel> data = getSampleData();
        boolean updated = TVSeries.updateSeriesById("102", "New Comedy", 15, "25", data);
        assertTrue(updated);
        
        SeriesModel updatedSeries = TVSeries.searchSeriesById("102", data);
        assertEquals("New Comedy", updatedSeries.SeriesName);
        assertEquals("15", updatedSeries.SeriesAge);
        assertEquals("25", updatedSeries.SeriesNumberOfEpisodes);
    }

    /**
     * Test of deleteSeries method, of class TVSeries.
     */
    @Test
    public void testDeleteSeries() {
        ArrayList<SeriesModel> data = getSampleData();
        boolean deleted = TVSeries.deleteSeriesById("101", data);
        assertTrue(deleted);
        assertNull(TVSeries.searchSeriesById("101", data));
    }

    /**
     * Test of printReport method, of class TVSeries.
     */
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        ArrayList<SeriesModel> list = getSampleData();
        boolean deleted = TVSeries.deleteSeriesById("999", list);
        assertFalse(deleted);
        assertEquals(1, list.size());
    }
    
    /**
     * Test of printReport method, of class TVSeries.
     */
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(TVSeries.isValidAge(12));
        assertTrue(TVSeries.isValidAge(2));
        assertTrue(TVSeries.isValidAge(18));
    }
    
    /**
     * Test of printReport method, of class TVSeries.
     */
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(TVSeries.isValidAge(1));
        assertFalse(TVSeries.isValidAge(19));
        
        assertThrows(NumberFormatException.class, () -> {
        Integer.parseInt("abc");
        });
    }

    
}
