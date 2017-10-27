package pac;

import chat.ClientHandler;
import chat.ServerLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project name: PomidoraClient
 * Created by pavel on 26.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v1.0
 */
public class PacketMessage extends OPacket {

    private String name;

    private String message;

    public PacketMessage(){

    }

    public PacketMessage(String name, String message){
        this.name = name;
        this.message = message;
    }

    @Override
    public short getID() {
        return 2;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(name);
        dos.writeUTF(message);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        message = dis.readUTF();
    }

    @Override
    public void handle() {
        name = ServerLoader.getHandler(getSocket()).getNikName();                            //получаем имя последнего пользователя
        ClientHandler tmp = ServerLoader.users.remove(getSocket());                          //удаляем из списка пользователей, которые получат сообщение
        ServerLoader.users.keySet().forEach(s -> ServerLoader.sendPackets(s, this)); //отправляем его сообщение всем
        ServerLoader.users.put(getSocket(), tmp);                                           //добавляем обратно
        System.out.println("[" + name +"] " + message);
    }
}
