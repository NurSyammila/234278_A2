/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._a2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class FileTest {
    
    public FileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSet() {
        System.out.println("set");
        File file = new File ("C:\\Users\\Win8\\Documents\\NetBeansProjects\\234278_A2\\Assignment2Test");
        Collection<File> all = new ArrayList<>();
        com.mycompany._a2.File.set(file, all);
    }

    @Test
    public void testFilter() {
        System.out.println("filter");
        Collection<File> listAllFileName = new ArrayList<>();
        String[] expResult = {};
        String[] result = com.mycompany._a2.File.filter(listAllFileName);
        assertArrayEquals(expResult, result);
    }
    
}
