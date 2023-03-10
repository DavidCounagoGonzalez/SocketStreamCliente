package org.example;

import javax.swing.*;
import java.awt.*;

public class InterfazXat {

    public static JButton btnEnviar, btnCerrar;
    public static JTextField txtEscribe;
    public static JTextArea chat;
    public static JScrollPane scroll;
    public static JFrame frame ;
    public static JLabel lblTitulo;

    public InterfazXat(){

        lblTitulo = new JLabel("XAT");
        lblTitulo.setFont(new Font("TimesRoman", Font.ITALIC, 25));
        lblTitulo.setBounds(225,25,400,25);


        chat = new JTextArea();
        chat.setEditable(false);
        chat.setFont(new Font("TimesRoman", Font.TRUETYPE_FONT, 15));
        scroll = new JScrollPane(chat);
        scroll.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
        scroll.setBounds(40,80,420,250);


        txtEscribe = new JTextField();
        txtEscribe.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
        txtEscribe.setEditable(true);
        txtEscribe.setBounds(40, 340,160,25);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(40,360, 160, 40);
        btnEnviar.setToolTipText("Envia el mensaje escrito");

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(70,400, 75,40);
        btnCerrar.setToolTipText("Cierra el chat");

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0,0,500,600);
        panel.add(lblTitulo);
        panel.add(scroll);
        panel.add(txtEscribe);
        panel.add(btnEnviar);
        panel.add(btnCerrar);

        frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,600);
        frame.setTitle("XAT");
        frame.setVisible(true);
        frame.setResizable(false);

    }
}

