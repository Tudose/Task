/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elfy.TaskCreator.test;

import com.elfy.TaskCreator.Utils.RandomPasswordGenerator;

/**
 *
 * @author Victor
 */
public class Test {
    
    public static void main(String[] args) {
        
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        System.out.println(rpg.createPassword());
    }
    
}
