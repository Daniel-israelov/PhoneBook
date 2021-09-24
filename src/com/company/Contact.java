package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Contact {
    public enum Group {Friends, Family, Work, Other};
    private String name;
    private String phoneNumber;
    private Group group;

    public Contact(String name, String phoneNumber, Group group){
        setName(name);
        setPhoneNumber(phoneNumber);
        this.group = group;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void save(PrintWriter pw) throws FileNotFoundException {
        pw.println("Name: " + name);
        pw.println("Phone #: " + phoneNumber);
        pw.println("Group: " + group.name());
        pw.println("------------------------------");
    }
    public void save(String fileName) throws FileNotFoundException {
        fileName += ".txt";
        PrintWriter pw = new PrintWriter(new File(fileName));
        save(pw);
        pw.close();
    }
}
