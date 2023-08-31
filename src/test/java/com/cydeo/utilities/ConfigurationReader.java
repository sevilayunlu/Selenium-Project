package com.cydeo.utilities;

//In this class, we will be creating the re-usable logic to read from configuration.properties file

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create Properties object
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else

    private static Properties properties = new Properties();

    static {

        try {
            //2-Open File using file input Stream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3-Load the"properties" object with "file

            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("File not found with the given path!!!");
           e.printStackTrace();
        }

    }
    //4-Use "properties" object to read from the file
    //Create a utility method to use the object to read
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }



}
//We wanted to create a re-usable utility method for the logic we created to read from configuration.properties file.
//We have created a "Reading properties" class in day 08 . Not to write all 4 steps from the beginning, we created o utility which is ConfigurationReader.
//We call this method and this method will trigger the steps to read from .properties file, and it will return us the value of the key we provide.