package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {

    private Socket sc;

    public HiloCliente(Socket sc) {
        this.sc = sc;

    }

    @Override
    public void run(){
        while(true){
            try {
                SocketCliente.recibo();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
