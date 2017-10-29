/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._a2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Badrul
 */
public class Save {

    public JSONObject json;
    public JSONArray array, array1, array2;
    public JSONObject item;
    public String matrik, matrik1, matrik2;

    public void save(JSONObject listdetail, JSONObject keyword, JSONObject noLine) {
        try {
            array = listdetail.getJSONArray("information");
            array.put(keyword);
            array.put(noLine);
        } catch (JSONException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listdetail.toString());
    }
}
