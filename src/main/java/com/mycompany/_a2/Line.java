package com.mycompany._a2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Semester: A171 
 * Course: STIW3054 
 * Group: A 
 * Task: Assignment 2 
 * Matric: 234278
 * Name: #NurSyammila
 */
public class Line {

    LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    public int totalcount;
    String task;
    String matrik;
    String scanLine;
    int command = 0;
    int zero = 0;
    int code = 0;

    public JSONObject Line(String[] list) {
        for (String list1 : list) {
            try (final BufferedReader baca = new BufferedReader(new FileReader(list1))) {
                while ((scanLine = baca.readLine()) != null) {
                    if (scanLine.contains("//Task:")) {
                        task = scanLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (scanLine.contains("//Matrik:")) {
                        matrik = scanLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    if (scanLine.contains("//")) {
                        command++;
                    } else if (scanLine.isEmpty()) {
                        zero++;
                    } else {
                        code++;
                    }
                    totalcount++;
                }
            }catch (IOException e) {
                System.out.println("Error, file cannot be read.");
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matrik);
                item.put("Command", command);
                item.put("Empty", zero);
                item.put("Actual", code);
                array.put(item);
                json.put("line", array);
            } catch (JSONException ex) {
                System.out.println("Error, file cannot be read.");
            }
        }
        return json;
    }
}
