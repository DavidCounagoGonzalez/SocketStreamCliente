package org.example;

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
                throw new RuntimeException(e);
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
