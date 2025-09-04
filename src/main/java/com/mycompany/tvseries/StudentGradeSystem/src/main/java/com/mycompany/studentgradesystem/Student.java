/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradesystem;

/**
 *
 * @author lab_services_student
 */
public class Student extends Person{
    
    //An array to store grades
    private int[] grades;
    
    //Constructor

    public Student(String name, int[] grades) {
      
        //Call the parent constructor
        super(name);
        this.grades = grades;
       
    }
    
    //Method to calculate average grade
    public double calculateAverage(){
        int sum = 0;
        
        //Loop
        for (int grade : grades){
            sum += grade;
        }
        
        return (double)  sum / grades.length;
    }
    
    //Method to print a report for this students below
    public void printReport(){
        System.out.println("Name:" + getName());
        System.out.println("Grades:");
        
        for(int g = 0; g < grades.length; g++) {
            System.out.print(grades[g]);
            
            if(g < grades.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println("\n Average:" + calculateAverage());
        System.out.println("---------------------");
    }
    
} 

//References://
//“ChatGPT.” ChatGPT, 2025, chatgpt.com/c/68b88f0b-b390-832a-93c1-e5d16976b3e9. Accessed 1 Sept. 2025.//
//THE INDEPENDENT INSTITUTION OF EDUCATION. INTRODUCTION to MOBILE APPLICATION DEVELOPMENT. MODULE MANUAL 2024, 2024, advtechonline.sharepoint.com/sites/TertiaryStudents/IIE%20Student%20Materials/Forms/Default%20View.aspx?viewid=db15e059%2D4f93%2D487f%2Dabda%2De538b821c7b8&id=%2Fsites%2FTertiaryStudents%2FIIE%20Student%20Materials%2FNew%20Student%20Materials%20CAT%2FIMAD5112%2F2024%2FIMAD5112MM%2Epdf&parent=%2Fsites%2FTertiaryStudents%2FIIE%20Student%20Materials%2FNew%20Student%20Materials%20CAT%2FIMAD5112%2F2024.//
//---. INTRODUCTION to PROGRAMMING LOGIC MODULE MANUAL 2024. FIRST EDITION: 2024 ed., advtechonline.sharepoint.com/sites/TertiaryStudents/IIE%20Student%20Materials/Forms/Default%20View.aspx?id=%2Fsites%2FTertiaryStudents%2FIIE%20Student%20Materials%2FNew%20Student%20Materials%20CAT%2FIPRG5111%2F2024%2FIPRG5111MM%2Epdf&viewid=db15e059%2D4f93%2D487f%2Dabda%2De538b821c7b8&parent=%2Fsites%2FTertiaryStudents%2FIIE%20Student%20Materials%2FNew%20Student%20Materials%20CAT%2FIPRG5111%2F2024//
//---. Java Programming. 10th ed., S.L., Cengage Learning, 2022.//
    
   


