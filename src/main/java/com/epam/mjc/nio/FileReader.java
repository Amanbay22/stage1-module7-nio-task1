package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String fileName = file.getPath();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(": ");
                if (split[0].equals("Name")) profile.setName(split[1]);
                if (split[0].equals("Age")) profile.setAge(Integer.valueOf(split[1]));
                if (split[0].equals("Email")) profile.setEmail(split[1]);
                if (split[0].equals("Phone")) profile.setPhone(Long.valueOf(split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
