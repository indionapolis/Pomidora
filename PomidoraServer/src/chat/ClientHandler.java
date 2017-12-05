package chat;

import pac.OPacket;
import pac.PacketManager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project name: PomidoraServer
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class ClientHandler extends Thread{

    private final Socket client;

    private String nikname = "Non";

    public ClientHandler(){
        this.client = null;
    }

    public ClientHandler(Socket client){
        this.client = client;
        System.out.println("New client connect to " + client.toString());
        nikname = "none";
        start();
    }

    public String getNikName(){
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    @Override
    public void run() {
        while (true){

            if (!readData()) { //если не прочли то спим, иначи читаем
                try {
                    Thread.sleep(10);
                }catch (InterruptedException ex){}
            }

        }
    }

    /**
     * method for reading data
     */
    private boolean readData(){
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            if (dis.available() <= 0){ //проверяем можно ли считать
                return false;
            }
            short id = dis.readShort();//считываем id
            OPacket packet = PacketManager.getPacket(id); //соз
            packet.setSocket(client); //задали сокет клиента
            packet.read(dis);         //пррочитали пакет
            packet.handle();          //обрабатываем


        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public void invalidate(){
        ServerLoader.invalidate(client);
    }
}
