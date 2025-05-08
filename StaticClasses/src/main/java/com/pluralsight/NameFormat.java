package com.pluralsight;

public class NameFormat {

 public static String format(String fullname){
     return fullname;
 }
 public static String format(String firstName, String lastName){
     return firstName + " " + lastName;
 }
 public static String format(String prefix,
                             String firstname,
                             String middlename,
                             String lastname,
                             String suffix){
     return prefix + " " + firstname + " " + middlename
             + " " + lastname + " " + suffix;
 }



}
