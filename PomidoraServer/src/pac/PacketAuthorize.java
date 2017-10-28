package pac;

import chat.ServerLoader;
import pac.OPacket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Project name: PomidoraClient
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketAuthorize extends OPacket {

    private String name;


    public PacketAuthorize(){

    }

    public PacketAuthorize(String name){
        this.name = name;
    }

    @Override
    public short getID() {
        return 1;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(name);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        name = dis.readUTF();
    }

    @Override
    public void handle() {
        ServerLoader.getHandler(getSocket()).setNikname(name);
        ServerLoader.users.keySet().forEach(s -> ServerLoader.sendPackets(s, this)); //отправляем его сообщение всем
        ServerLoader.users.put(getSocket(), ServerLoader.getHandler(getSocket()));          //добавляем нового пользователя в список пользователей
        System.out.println("New user " + name);
    }
}
