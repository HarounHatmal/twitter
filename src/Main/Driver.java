/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.TreeMap;

public class Driver {

    public static void main(String[] args){ 
        AdminView av = new AdminView();
        AdminModel am = new AdminModel();
        AdminController ac = new AdminController(av, am);
    }
    
}
