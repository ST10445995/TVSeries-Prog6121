/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgradesystem;

/**
 *
 * @author lab_services_student
 */
public class StudentGradeSystem {

    public static void main(String[] args) {
        
        //Create an array of the students objects 
        Student[] students = {
            new Student("Gomolemo Poopedi", new int[]{85, 90, 78}),
            new Student("Kegoineetse Maja", new int[]{70, 65, 80}),
            new Student("Gwendelynn Smith", new int[]{75, 90 ,88}),
            new Student("William van Zyl", new int[]{60, 65, 50}),
            new Student("Alicia Kingswood", new int[]{30, 55, 34})
            
        };
    
        //Print a report for each student 
        System.out.println("------- Student Report -------");
    
        for(Student s: students){
            s.printReport();
        }
    }

}