/*
package Loto;

import javax.swing.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

public class Loto {
    public static void main(String[] args) {
        while (true) {
            Stack<Integer> stack = new Stack<>();
            Random random = new Random();
            
            for (int i = 0; i < 10; i++) {
                stack.push(random.nextInt(10));  
            }
            

            Integer[] luckyNumbers = new Integer[3];
            for (int i = 0; i < 3; i++) {
                luckyNumbers[i] = stack.pop();  
            }
            
            String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            
            String message = "Lucky Numbers: " + Arrays.toString(luckyNumbers) + "\n" +
                             "Draw Date & Time: " + currentDate;
            JOptionPane.showMessageDialog(null, message, "Lottery Results", JOptionPane.INFORMATION_MESSAGE);
            
            try {
                Thread.sleep(60000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
*/