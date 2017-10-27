package pac;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name: PomidoraServer
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketManager {

    //храним массив классов с ключем id для дальнейшей обработки
    private final static Map<Short, Class<? extends OPacket>> packets = new HashMap<>();

    static {
        packets.put((short) 1, PacketAuthorize.class);
        packets.put((short) 2, PacketMessage.class);

        packets.put((short) 3, PacketEnd.class);
    }



    public static OPacket grtPacket(short id){
        try {
            return packets.get(id).newInstance();
        }catch (InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
