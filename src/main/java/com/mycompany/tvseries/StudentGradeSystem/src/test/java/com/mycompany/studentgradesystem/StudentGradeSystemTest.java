/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentgradesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class StudentGradeSystemTest {
    
    public StudentGradeSystemTest() {
    }
    
    /**
     * Test of main method, of class StudentGradeSystem.
     */
    @Test
    public void testAverageCalculation() {
        Student s = new Student ("Test Student", new int[] {80, 90, 100});
        
        //Expected avaerage = (80 + 90 + 100)/3 = 90.0
        assertEquals(90.0, s.calculateAverage(), 0.001);
    }
    
    @Test
    public void testLowGrades(){
        Student s = new Student ("Weak Student", new int[] {30, 40, 50});
        
        //Expected avaerage = (30 + 40 + 50)/3 = 40.0
        assertEquals(40.0, s.calculateAverage(), 0.001);
    }
    
    @Test
    public void testSingleGrades(){
        Student s = new Student ("Single Grade", new int[] {100});
        
        //Expected avaerage = 100.0
        assertEquals(100.0, s.calculateAverage(), 0.001);
    }
    
    @Test
    public void testMultipleStudentDifferentAverages(){
        Student s1 = new Student("Gomolemo Poopedi", new int[]{85, 90, 78});
        Student s2 = new Student("Kegoineetse Maja", new int[]{70, 65, 80});
        Student s3 = new Student("Gwendelynn Smith", new int[]{75, 90 ,88});
        Student s4 = new Student("William van Zyl", new int[]{60, 65, 50});
        Student s5 = new Student("Alicia Kingswood", new int[]{30, 55, 34});
        
        //Gomolemo Poopedi's average = (85 + 90 + 78)/3 = 84.33
        assertEquals(84.33, s1.calculateAverage(), 0.01);
      
        //Kegoineetse Maja's average = (70 + 65 + 80)/3 = 71.67
        assertEquals(71.67, s2.calculateAverage(), 0.01);
        
        //GGwendelynn Smith's average = (75 + 90 + 88)/3 = 84.33
        assertEquals(84.33, s3.calculateAverage(), 0.01);
        
        //William van Zyl's average = (60 + 65 + 50)/3 = 58.33
        assertEquals(58.33, s4.calculateAverage(), 0.01);
        
        //Alicia Kingswood's average = (30 + 55 + 34)/3 = 39.67
        assertEquals(39.67, s5.calculateAverage(), 0.01);
    }
}
