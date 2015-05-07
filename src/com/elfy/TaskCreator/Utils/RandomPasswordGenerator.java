
package com.elfy.TaskCreator.Utils;

import java.util.Random;

/**
 *
 * @author Victor
 */
public class RandomPasswordGenerator {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int noOfCharacters = 10;
    private String password = null;
    private StringBuilder sb = new StringBuilder(noOfCharacters);
    private static Random rnd = new Random();
    
    public String createPassword(){
        for(int i = 0;i<noOfCharacters;i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        
        password = sb.toString();
        
        return password;
    }
    
}
