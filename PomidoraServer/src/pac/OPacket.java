package pac;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project name: PomidoraClient
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public abstract class OPacket {

    private Socket client;

    public Socket getSocket() {
        return client;
    }

    public void setSocket(Socket client) {
        this.client = client;
    }

    public abstract short getID();

    public abstract void write(DataOutputStream dos) throws IOException;

    public abstract void read(DataInputStream dis) throws IOException;

    public abstract void handle();
}
