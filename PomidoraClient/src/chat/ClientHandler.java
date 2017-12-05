package chat;

import pac.OPacket;
import pac.PacketManager;

import java.awt.event.WindowEvent;
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
    private final ClientWindow window;

    public ClientHandler(Socket socket, ClientWindow window){
        this.server = socket;
        this.window = window;
    }

    //get packets and handling
    @Override
    public void run() {
        while (true){

            try {

                DataInputStream dis = new DataInputStream(server.getInputStream());
                if (dis.available() <= 0){ //если нам не пишет сервер
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){}
                    continue;
                }
                //reed packet
                short id = dis.readShort();

                OPacket packet = PacketManager.grtPacket(id);
                packet.read(dis);
                packet.handle(window);

            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
