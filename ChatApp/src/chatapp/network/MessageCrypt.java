/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.network;

/**
 *
 * @author Philip
 */

public class MessageCrypt {
    private static char alphabets[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    private static char key[] = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ' '};
    
    public MessageCrypt(){
    
    }
    public static String encryption(String message) {
        char cipherText[] = new char[(message.length())];
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < 27; j++) {
                if (alphabets[j] == message.charAt(i)) {
                    cipherText[i] = key[j];
                    break;
                }
            }
        }
        return (new String(cipherText));
    }
    
    public static String decryption(String message) {
        char plainText[] = new char[(message.length())];
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < 27; j++) {
                if (key[j] == message.charAt(i)) {
                    plainText[i] = alphabets[j];
                    break;
                }
            }
        }
        return (new String(plainText));
    }
}