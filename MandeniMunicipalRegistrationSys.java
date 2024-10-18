package com.mycompany.mandenimunicipalregistrationsys;

import java.util.Scanner;

/**
 * Handles citizen registration with error handling.
 */
public class MandeniMunicipalRegistrationSys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String citizenName = "";
        String citizenID = "";
        
        System.out.println("Welcome to Mandeni Municipal Citizen Registration System");
        
        try {
            System.out.print("Enter citizen's name: ");
            citizenName = scanner.nextLine();
            
            System.out.print("Enter citizen's ID (13 characters): ");
            citizenID = scanner.nextLine();
            
            // Validate if ID is the correct length (13 characters)
            if (citizenID.length() != 13) {
                throw new IllegalArgumentException("Invalid Citizen ID: Must be 13 characters long.");
            }
            
            System.out.println("Citizen successfully registered: " + citizenName);
            
        } catch (IllegalArgumentException e) {
            // Handle specific invalid ID format
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle unexpected errors
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
         
            scanner.close();
        }
    }
}
