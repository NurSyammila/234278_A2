/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._a2;

import org.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Badrul
 */
public class CourseInfo {

    LinkedList<String> listFileContent;
    public String semester;
    public String course;
    public String group;
    public String task;
    public String matrik;
    public String name;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;

    public JSONObject CourseInfo(String[] list) {
        for (int i = 0; i < list.length; i++) {
            try (BufferedReader baca = new BufferedReader(new FileReader(list[i]))) {
                String scanLine;
                while ((scanLine = baca.readLine()) != null) {
                    if (scanLine.contains("//Semester:")) {
                        semester = scanLine.replaceAll("\\s*//Semester:\\s*#", "");
                    } else if (scanLine.contains("//Course:")) {
                        course = scanLine.replaceAll("\\s*//Course:\\s*#", "");
                    } else if (scanLine.contains("//Task:")) {
                        task = scanLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (scanLine.contains("//Matrik:")) {
                        matrik = scanLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    } else if (scanLine.contains("//Name:")) {
                        name = scanLine.replaceAll("\\s*//Name:\\s*#", "");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error, file cannot be read.");
            }
            try {
                item = new JSONObject();
                item.put("File Name", list[i]);
                item.put("Semester", semester);
                item.put("Course", course);
                item.put("Task", task);
                item.put("Matrik", matrik);
                item.put("Name", name);
                array.put(item);

                json.put("information", array);
            } catch (JSONException ex) {
                System.out.println("Error, file cannot be read.");
            }
        }
        return json;
    }
}
