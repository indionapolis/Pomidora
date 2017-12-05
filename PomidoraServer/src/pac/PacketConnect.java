package pac;

import chat.ServerLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Project name: PomidoraClient
 * Created by pavel on 02.12.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketConnect extends OPacket {
    private String name;


    public PacketConnect(){}

    public PacketConnect(String name){
        this.name = name;
    }

    @Override
    public short getID() {
        return 0;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {

    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        name = dis.readUTF();
    }

    @Override
    public void handle() {
        ServerLoader.getHandler(getSocket()).setNikname(name);
    }
}
