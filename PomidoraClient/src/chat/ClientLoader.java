package chat;

import pac.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Project name: PomidoraClient
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
//TODO проверка жив ли объект
public class ClientLoader {

    private static final int PORT = 4444; //эта нет

    private static InetAddress IP;

    private static final String address =  "10.240.21.28"; //эта хуйня может меняться

    private static Socket server; //connection server
    private static ClientHandler handler;
    private static boolean isNamed = false;
    private static String name;



    /**
     * Set up of user
     */
    public static void main(String[] args) {
        connect();
        handle();
        end();
    }


    //TODO обработать ошибку если подключаюсь к несуществующему серверу
    /**
     * Method to connect with server
     */
    private static void connect(){
        try {
            IP = InetAddress.getByName(address);
            server = new Socket(IP, PORT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }




    /**
     * method to handel with client
     */
    private static void handle(){
        handler = new ClientHandler(server);
        handler.start();
        readChat();
    }




    /**
     * method to work with chat
     */
    private static void readChat(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (!isNamed) System.out.print("Enter your name: ");
            if (scanner.hasNextLine()){           //если есть что чтать

                String line = scanner.nextLine(); //читаем чат

                if (line.equals("/end")) {
                    sendPacket(new PacketEnd(name));
                    end();
                }

                if (!isNamed){                    //если мы только регестрируемся
                    isNamed = true;
                    System.out.println("Your name: " + line);
                    sendPacket(new PacketAuthorize(line));  //отправляем пакет с сообщением авторизации
                    continue;
                }
                sendPacket(new PacketMessage(name, line));  //отправляем пакет с сообщением

            }else {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}
            }
        }
    }




    /**
     * method send packet on server
     * @param packet packet
     */
    public static void sendPacket(OPacket packet){
        try {
            DataOutputStream dos = new DataOutputStream(server.getOutputStream());  //создаем новый поток через сокет
            dos.writeShort(packet.getID());     //записывваем вид пакета для стороны получателя
            packet.write(dos);      //передаем инфу в формате пакета
            dos.flush();            //отправляем инфу
        }catch (IOException e){
            e.printStackTrace();
        }
    }




    /**
     * method to stop execution of program
     */
    public static void end(){
        //TODO отправлять пакет отключения от сервера
        System.out.println("End user");
        try {
            server.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.exit(0); //выхожу из системы
    }
}