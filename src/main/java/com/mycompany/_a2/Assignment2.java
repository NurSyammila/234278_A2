package com.mycompany._a2;

import org.json.JSONObject;



/**
 *
 * 
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String name;
        File find = new File();
        String[] list = find.list;

        CourseInfo open = new CourseInfo();
        JSONObject listdetail = open.json;
        open.CourseInfo(list);

        Keywords key = new Keywords();
        key.Count(list);
        JSONObject keyword = key.json;

        Line line = new Line();
        line.Line(list);
        JSONObject noLine = line.json;


        Save com = new Save();
        com.save(listdetail, keyword, noLine);
    }
}
