package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Project name: PomidoraServer
 * Created by pavel on 26.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class ServerHandler extends Thread{

    private final ServerSocket socket;

    //получаем клиентов и отправляем их на обработку
    public ServerHandler(ServerSocket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true){


            try {
                Socket client = socket.accept(); //ждемс клиента пока не подключится
                ClientHandler handler = new ClientHandler(client); //когда клиент подключился, обрабатываем
                ServerLoader.handlers.put(client, handler); //массив клиентов
            }catch (SocketException ex){
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(10);
            }catch (InterruptedException ex){}

        }
    }
}
