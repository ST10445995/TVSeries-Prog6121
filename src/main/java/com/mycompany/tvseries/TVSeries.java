/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvseries;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class TVSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        
        //Menu screen
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if(!input.equals("1")){
            System.out.println("Exiting application...");
            return;
        }
        
        displayMenu(scanner, seriesList);
        
    }
    
    public static void displayMenu(Scanner scanner, ArrayList<SeriesModel>seriesList){
        
        System.out.println("\n Please select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");
        
        String choice = scanner.nextLine();
        
        switch (choice){
            case "1":
                captureSeries(scanner, seriesList);
                break;
                
            case "2":
                searchSeries(scanner, seriesList);
                break;
                
            case "3":
                updateSeries(scanner, seriesList);
                break;
                
            case "4":
                deleteSeries(scanner, seriesList);
                break;
                
            case "5":
                printReport(scanner, seriesList);
                break;
                
            case "6": 
                System.out.println("Exiting Application...");
                displayMenu(scanner, seriesList);
        }
    }
    
    public static void captureSeries(Scanner scanner, ArrayList<SeriesModel> seriesList){
        //Capture new series screen
        System.out.println("\n CAPTURE A NEW SERIES");
        System.out.println("*****************************");
        
        SeriesModel series = new SeriesModel();
        
        System.out.print("Enter the series id:");
        series.SeriesId = scanner.nextLine();
        
        System.out.print("Enter the series name:");
        series.SeriesName = scanner.nextLine();
        
        //Validate the age restriction input
        boolean validAge = false;
        
        while (!validAge){
            System.out.print("Enter the series age restriction:");
            String ageInput = scanner.nextLine();
            
            try{
                int age = Integer.parseInt(ageInput);
                if (age >= 2 && age <= 18) {
                    validAge = true;
                    series.SeriesAge = ageInput;
            }
                else{
                    System.out.println("Invalid age! Must be between 2 and 18.");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        
        System.out.print("Enter the number of episodes for" + series.SeriesName + ":");
        series.SeriesNumberOfEpisodes = scanner.nextLine();
        
        seriesList.add(series);
        
        System.out.println("Series processed successfully!");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String next = scanner.nextLine();
        if(next.equals("1")){
            displayMenu(scanner, seriesList);
        }
        else {
            System.out.println("Exiting application...");
        }
    }
    
    public static void searchSeries(Scanner scanner, ArrayList<SeriesModel> seriesList){
        System.out.print("Enter the series id to search:");
        String searchId = scanner.nextLine();
        
        boolean found = false;
        
        for(SeriesModel s : seriesList){
            
            if(s.SeriesId.equals(searchId)){
                System.out.println("________________________________________");
                System.out.println("SERIES ID:" + s.SeriesId);
                System.out.println("SERIES NAME:" + s.SeriesName);
                System.out.println("SERIES AGE RESTRICTION:" + s.SeriesAge);
                System.out.println("SERIES NUMBER OF EPISODES:" + s.SeriesNumberOfEpisodes);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series with Series Id:" + searchId + "was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String next = scanner.nextLine();
        
        if(next.equals("1")) {
            displayMenu(scanner, seriesList);
        }
        else {
            System.out.println("Exiting application...");
        }
    }  
    
    public static void updateSeries(Scanner scanner, ArrayList<SeriesModel>seriesList){
        System.out.print("Enter the series id to update:");
        String updateId = scanner.nextLine();
        
        boolean found = false;
        
        for(SeriesModel s : seriesList) {
            
            if(s.SeriesId.equals(updateId)){
                System.out.print("Enter the new series name:");
                String ageInput = scanner.nextLine();
                
                //Validate age restriction again
                boolean validAge = false;
                
                while(!validAge){
                    System.out.print("Enter the new age restriction:");
                    
                    try{
                        int age = Integer.parseInt(ageInput);
                        if(age >= 2 && age <= 18) {
                            validAge = true;
                            s.SeriesAge = ageInput;
                        }
                        else{
                            System.out.println("Invalid age! Must be between 2 and 18.");
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid input! Please enter a number.");
                    }
                }
                
                System.out.print("Enter the new number of episodes:");
                s.SeriesNumberOfEpisodes = scanner.nextLine();
                
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("Series with Series Id:" + updateId + "was not found!");
        }
               
        System.out.println("Enter (1) to launch menu or any other key to exit");  
        String next = scanner.nextLine();
        
        if(next.equals("1")){
            displayMenu(scanner, seriesList);
        }
        else{
            System.out.println("Exiting application...");
        }
        
    }
    
    public static void deleteSeries(Scanner scanner, ArrayList<SeriesModel> seriesList){
        
        System.out.print("Enter the series id to delete:");
        String deleteId = scanner.nextLine();
        
        boolean found = false;
        
        for(int k = 0; k < seriesList.size(); k++){
            SeriesModel s = seriesList.get(k);
            
            if(s.SeriesId.equals(deleteId)){
                System.out.println("Are you sure you want to delete the series" + deleteId + "? Type 'y' to confirm.");
                String confirm = scanner.nextLine();
                
                if (confirm.equalsIgnoreCase("y")){
                    seriesList.remove(k);
                    System.out.println("Series" + deleteId + "was deleted.");
                }
                
                found = true;
                break;
                
            }
        }
        
        if (!found){
            System.out.println("Series with Series Id:" + deleteId + "was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String next = scanner.nextLine();
        
        if(next.equals("1")) {
            displayMenu(scanner, seriesList);
        }
        else{
            System.out.println("Exiting application...");
        }               
    }
    
    public static void printReport(Scanner scanner, ArrayList<SeriesModel> seriesList){
        
        System.out.println("\n --- SERIES REPORT - 2025 ---");
        
        for (int k = 0; k < seriesList.size(); k++){
            SeriesModel s = seriesList.get(k);
            System.out.println("Series" + s.SeriesId);
            System.out.println("______________________________________________");
            System.out.println("SERIES ID:" + s.SeriesId);
            System.out.println("SERIES NAME:" + s.SeriesName);
            System.out.println("AGE RESTRICTION:" + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES:" + s.SeriesNumberOfEpisodes);
            System.out.println("______________________________________________");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String next = scanner.nextLine();
        
        if(next.equals("1")){
            displayMenu(scanner, seriesList);
        }
        else {
            System.out.println("Exiting application...");
        }
    }
    
    //Helper methods for unit tests
    public static boolean isValidAge(int age) {
        return age >= 2 && age <= 18;
    }
    
    public static SeriesModel searchSeriesById(String id, ArrayList<SeriesModel> seriesList) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                return s;
            }
        }
        return null;
    }
    
    public static boolean updateSeriesById(String id, String newName, int newAge, String newEpisodes, ArrayList<SeriesModel> seriesList) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                s.SeriesName = newName;
                if (isValidAge(newAge)) {
                    s.SeriesAge = String.valueOf(newAge);
                } else {
                    return false;
                }
                s.SeriesNumberOfEpisodes = newEpisodes;
                return true;
            }
        }
        return false;
    }
    
    public static boolean deleteSeriesById(String id, ArrayList<SeriesModel> seriesList) {
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).SeriesId.equals(id)) {
                seriesList.remove(i);
                return true;
            }
        }
        return false;
    }
    
}

//References://
//Youtu.be, 2025, youtu.be/1nRj4ALuw7A?si=4RWicd74ZqGE_WS0. Accessed 17 Aug. 2025.//
//Youtu.be, 2025, youtu.be/NbYgm0r7u6o?si=e8pmEe2jq_5xeJ99. Accessed 12 Aug. 2025.//
//Youtu.be, 2025, youtu.be/BdBS4x7ORug?si=alCE_TZGydhXMyF_. Accessed 31 Aug. 2025.//
//Youtu.be, 2025, youtu.be/Om3qzMoaIUo?si=ecQRaf-6S-n30dRp. Accessed 1 Sept. 2025.//
//Youtu.be, 2025, youtu.be/cFTFtuEQ-10?si=H_A-3E70YqwbrxJ_. Accessed 1 Sept. 2025.//
//OpenAI. “ChatGPT.” ChatGPT, OpenAI, 2 Sept. 2025, chatgpt.com/.//
//Youtu.be, 2025, youtu.be/wsTSREgCE5E?si=l2nArWZRRcX9lRUq. Accessed 3 Sept. 2025.//
//Youtu.be, 2025, youtu.be/Ihy0QziLDf0?si=g520kBa1c6at2Vkd. Accessed 3 Sept. 2025.//
//Youtu.be, 2025, youtu.be/O7aUm0AuUy4?si=Kz1-RntCEffvfheo. Accessed 3 Sept. 2025.//
//---. Java Programming. 10th ed., S.L., Cengage Learning, 2022.//
 
