
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Main
{
    // instance variables - replace the example below with your own
    public static void main (String[] args){
        JFrame f = new JFrame("textfield");
        JTextField msgTxt = new JTextField(16);
        JPanel p = new JPanel();
        JLabel msgLabel = new JLabel("Enter your message: ");
    
        JTextField keyTxt = new JTextField(16);
        JLabel keyLabel = new JLabel("Enter your key: ");
        
        Action getMsg = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String message = msgTxt.getText();
            }
        };
        Action getKey = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String message = keyTxt.getText();
            }
        };
        msgTxt.addActionListener(getMsg);
        p.add(msgLabel);
        p.add(msgTxt);
        p.add(keyLabel);
        p.add(keyTxt);
        // add panel to frame
        f.add(p);
 
        // set the size of frame
        f.setSize(300, 300);
 
        f.setVisible(true);
    
 
        // if the button is pressed
        int key1 = 3;
        int key2 = 5;
        // FileResource fr = new FileResource();
        String message = "AaaA";
        String message2 = "Z bpfy jfy vf ugttprk kjv dgjuriv";
        String encrypted = encrypt2(message, key1, key2);
        String decrypted = decrypt2(message2, 2, 17);
        System.out.println(encrypted);
        System.out.println(decrypted);

    }
    
    public static String encrypt(String message, int key){
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key, alphabet.length()) + alphabet.substring(0, key);
        
        StringBuilder encrypted = new StringBuilder();
        message = message.toUpperCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i=0; i<message.length(); i++){
            //Look at the ith character of encrypted (call it currChar)
            String currChar = String.valueOf(message.charAt(i));
            //Find the index of currChar in the alphabet (call it idx)
            int alphaIndex = alphabet.indexOf(currChar);
           
             //If currChar is in the alphabet
            if(alphaIndex != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                //Replace the ith character of encrypted with newChar
                encrypted.append(String.valueOf(shiftedAlphabet.charAt(alphaIndex)));
            }
            else{
                encrypted.append(" ");
            }
        }
        return encrypted.toString();

    }
    
    public static String encrypt2(String message, int key1, int key2){
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1, alphabet.length()) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2, alphabet.length()) + alphabet.substring(0, key2);
        
        StringBuilder encrypted = new StringBuilder();
        message = message.toUpperCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i=0; i<message.length(); i++){
            //Look at the ith character of encrypted (call it currChar)
            String currChar = String.valueOf(message.charAt(i));
            //Find the index of currChar in the alphabet (call it idx)
            int alphaIndex = alphabet.indexOf(currChar);

             //If currChar is in the alphabet
            if(alphaIndex != -1){
               //Get the idxth character of shiftedAlphabet (newChar)
               //Replace the ith character of encrypted with newChar
               if(i%2 != 0){    
                   encrypted.append(String.valueOf(shiftedAlphabet1.charAt(alphaIndex)));
               }
               else{
                   encrypted.append(String.valueOf(shiftedAlphabet2.charAt(alphaIndex)));
               }
            }
            else{
                encrypted.append(" ");
            }
        }
        return encrypted.toString();
    }
    
    public static String decrypt(String message, int key){
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key, alphabet.length()) + alphabet.substring(0, key);
        
        StringBuilder decrypted = new StringBuilder();
        message = message.toUpperCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i=0; i<message.length(); i++){
            //Look at the ith character of encrypted (call it currChar)
            String currChar = String.valueOf(message.charAt(i));
            //Find the index of currChar in the alphabet (call it idx)
            int shiftIndex = shiftedAlphabet.indexOf(currChar);
           
             //If currChar is in the alphabet
            if(shiftIndex != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                //Replace the ith character of encrypted with newChar
                decrypted.append(String.valueOf(alphabet.charAt(shiftIndex)));
            }
            else{
                decrypted.append(" ");
            }
        }
        return decrypted.toString();

    }
    
    public static String decrypt2(String message, int key1, int key2){
        //Write down the alphabet
        int shiftIndex;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1, alphabet.length()) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2, alphabet.length()) + alphabet.substring(0, key2);
       
        StringBuilder encrypted = new StringBuilder();
        message = message.toUpperCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i=0; i<message.length(); i++){
            //Look at the ith character of encrypted (call it currChar)
            String currChar = String.valueOf(message.charAt(i));
            //Find the index of currChar in the alphabet (call it idx)
            if(i%2 != 0){    
               shiftIndex = shiftedAlphabet1.indexOf(currChar);
            }
            else{
               shiftIndex = shiftedAlphabet2.indexOf(currChar);
            }
             //If currChar is in the alphabet
            if(shiftIndex != -1){
               //Get the idxth character of shiftedAlphabet (newChar)
               //Replace the ith character of encrypted with newChar
               if(i%2 != 0){    
                   encrypted.append(String.valueOf(alphabet.charAt(shiftIndex)));
               }
               else{
                   encrypted.append(String.valueOf(alphabet.charAt(shiftIndex)));
               }
            }
            else{
                encrypted.append(" ");
            }
        }
        return encrypted.toString();

    }
} 

