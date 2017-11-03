package com.mycompany._a2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 Semester: A171 
 * Course: STIW3054 
 * Group: A 
 * Task: Assignment 2 
 * Matric: 234278
 * Name: #NurSyammila
 */

public class Keywords {

    LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    String task , matrik , ni;
    public final String keyword[] = {"abstract", "assert", "boolean ",
        "break", "byte ", "case", "catch", "char ", "class", "const",
        "continue", "default", "do", "double ", "else", "extends", "false",
        "final", "finally", "float ", "for", "goto", "if", "implements",
        "import", "instanceof", "int ", "interface", "long ", "native",
        "new", "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true",
        "try", "void", "volatile", "while", "enum"};


    public JSONObject Count(String[] list) {
        for (String list1 : list) {
            int count[] = new int[keyword.length];
            try (final BufferedReader baca = new BufferedReader(new FileReader(list1))) {
                String scanLine;
                while ((scanLine = baca.readLine()) != null) {
                    if (scanLine.contains("//Task:")) {
                        task = scanLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (scanLine.contains("//Matrik:")) {
                        matrik = scanLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    for (int i = 0; i < keyword.length; i++) {
                        if (scanLine.contains(keyword[i])) {
                            count[i] = count[i] + 1;
                        }
                    }
                }    
            }catch (IOException e) {
                System.out.println("Error, file cannot be read.");
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matrik);
                for (int l = 0; l < keyword.length; l++) {
                    item.put(keyword[l], count[l]);
                }
                array.put(item);
                json.put("listKeyword", array);
            } catch (JSONException ex) {
                System.out.println("Error, file cannot be read.");
            }
        }
        return json;
    }
}

