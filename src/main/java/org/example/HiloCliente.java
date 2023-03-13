package org.example;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {

    private Socket sc;
    private DataInputStream in;

    public HiloCliente(Socket sc) throws IOException {
        this.sc = sc;
        this.in = new DataInputStream(sc.getInputStream());
    }

    @Override
    public void run(){
            try {
                while(true){
                    String mensaje = in.readUTF();
                    InterfazXat.chat.append(mensaje + "\n");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El servidor se ha desconectado");
                InterfazXat.frame.dispatchEvent(new WindowEvent(InterfazXat.frame, WindowEvent.WINDOW_CLOSING));
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Te has desconectado");
                }
            }

    }
}
