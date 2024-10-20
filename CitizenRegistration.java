package com.mycompany.mandenimunicipalregistrationsys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CitizenRegistration {

    private ArrayList<Citizen> citizensList = new ArrayList<>();

   
    public void sortCitizensByName() {
        if (citizensList.isEmpty()) {
            System.out.println("No citizens to sort.");
            return;
        }
        Collections.sort(citizensList, new Comparator<Citizen>() {
            @Override
            public int compare(Citizen c1, Citizen c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        System.out.println("Citizens sorted by name.");
    }

   
    public Citizen searchCitizenById(String idNumber) {
        if (idNumber.length() != 13) {
            System.out.println("Error: ID number must be 13 digits.");
            return null;
        }
        for (Citizen citizen : citizensList) {
            if (citizen.getIdNumber().equals(idNumber)) {
                return citizen; 
            }
        }
        System.out.println("Citizen not found.");
        return null;
    }

    
    public void addCitizen(String name, String idNumber) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Name cannot be blank.");
            return;
        }
        if (idNumber.length() != 13) {
            System.out.println("Error: ID number must be 13 digits.");
            return;
        }
        citizensList.add(new Citizen(name, idNumber));
        System.out.println("Citizen added: " + name);
    }

   
    public static void main(String[] args) {
        CitizenRegistration system = new CitizenRegistration();

     
        system.addCitizen("John Doe", "1234567890123");
        system.addCitizen("Alice Smith", "9876543210987");
        system.addCitizen("Bob Jones", "1231231231231");

       
        system.addCitizen("", "9876543210987"); 
        system.addCitizen("Invalid ID", "12345"); 
  
        system.sortCitizensByName();


        Citizen foundCitizen = system.searchCitizenById("1234567890123");
        if (foundCitizen != null) {
            System.out.println("Citizen found: " + foundCitizen.getName());
        }


        system.searchCitizenById("invalidID");
    }
}


class Citizen {
    private String name;
    private String idNumber;


    public Citizen(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }


    public String getName() {
        return name;
    }


    public String getIdNumber() {
        return idNumber;
    }
}
