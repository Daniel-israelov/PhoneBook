package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void printGroup(){
        Contact.Group[] types = Contact.Group.values();
        for(Contact.Group t : types)
            System.out.print(t.name() + "/");
        System.out.println();
    }
    public static void CreateContacts(Contact[] c){
        String name, phoneNumber;
        System.out.println("Enter contacts info:");
        for(int i = 0; i < c.length; i++){
            s.nextLine(); //cleans buffer
            System.out.println("Contact #" + (i+1) + ":");
            System.out.print("Name:  ");
            name = s.nextLine();
            System.out.print("Phone #: ");
            phoneNumber = s.nextLine();
            System.out.println("Choose group from the following:");
            printGroup();
            Contact.Group type = Contact.Group.valueOf(s.next());
            c[i] = new Contact(name, phoneNumber, type);
        }
    }
    public static void CreateFile(Contact[] c) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("MyContacts.txt"));
        pw.println("Total contacts --> " + c.length + ".");
        pw.println();
        for( int i = 0; i<c.length;  i++)
            c[i].save(pw);
        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        int numOfContacts;

        System.out.print("How many contacts?  ");
        numOfContacts = s.nextInt();

        Contact[] c = new Contact[numOfContacts];

        CreateContacts(c);
        CreateFile(c);
    }
}