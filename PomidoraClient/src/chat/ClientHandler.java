package chat;

import pac.OPacket;
import pac.PacketManager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project name: PomidoraClient
 * Created by pavel on 26.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class ClientHandler extends Thread{

    private final Socket server;

    public ClientHandler(Socket socket){
        this.server = socket;
    }

    @Override
    public void run() {
        while (true){

            try {
                DataInputStream dis = new DataInputStream(server.getInputStream());
                if (dis.available() <= 0){ //если нам пишет сервер
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){}
                    continue;
                }
                short id = dis.readShort();

                OPacket packet = PacketManager.grtPacket(id);
                packet.read(dis);
                packet.handle();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
