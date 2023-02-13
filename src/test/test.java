/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import utils.MyDB;

/**
 *
 * @author haifa
 */
public class test {
    public static void main(String[] args) {
        MyDB db = MyDB.getInstance();
        //MyDB db2 = MyDB.getInstance();
        
        System.out.println(db);
        //System.out.println(db2);

    }
}
