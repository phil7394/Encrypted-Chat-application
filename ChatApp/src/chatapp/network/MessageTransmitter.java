/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.network;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Philip
 */
public class MessageTransmitter  extends Thread{
    String message, hostname;
    int port;
    MessageCrypt encrypt;
    public MessageTransmitter() {
    }

    public MessageTransmitter(String message, String hostname, int port) {
        encrypt = new MessageCrypt();
        this.message = encrypt.encryption(message);
        System.out.println("\n" + this.message);
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
