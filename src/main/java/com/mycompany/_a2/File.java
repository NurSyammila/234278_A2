package com.mycompany._a2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 Semester: A171 
 * Course: STIW3054 
 * Group: A 
 * Task: Assignment 1 
 * Matric: 234278
 * Name: #NurSyammila
 */

public class File {
    
    public String[] list;
    
    static void set(java.io.File file, Collection<java.io.File> all) {
        java.io.File[] x= file.listFiles();
        if (x != null) {
            for (java.io.File y : x) {
                all.add(y);
                set(y, all);
            }
        }
    }

    public File() {
        Collection<java.io.File> all = new ArrayList<>();
        set(new java.io.File(System.getProperty("user.dir") + java.io.File.separator + "Assignment2Test"), all);
        Collection<java.io.File> a = all;
        list = filter(a);
    }

    static String[] filter(Collection<java.io.File> listAllFileName) {
        LinkedList<String> f = new LinkedList();
        Iterator<java.io.File> find = listAllFileName.iterator();
        java.io.File getFile;
        while (find.hasNext()) {
            getFile = find.next();
            if (getFile.getName().endsWith(".java")) {
                f.add(getFile.getAbsolutePath());
            }
        }
        String[] list = new String[f.size()];
        for (int i = 0; i < f.size(); i++) {
            list[i] = f.get(i);
        }
        return list;
    }
    
}
