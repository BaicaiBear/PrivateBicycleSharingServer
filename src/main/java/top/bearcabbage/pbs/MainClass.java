package top.bearcabbage.pbs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

    public static final String OPEN_LOCK = "openlock";
    public static final String CLOSE_LOCK = "closelock";
    public static final String GET_GPS = "getgps";
    public static final String GET_TIME = "gettime";
    public static final String GET_STATE = "getstate";
    public static final String ERROR = "e";

    public static final char HOST = 'h';
    public static final char USER = 'u';
    public static final char LOCK = 'l';

    public void Main() throws IOException {

        while (true) {
            System.out.println("I am started.");

            //创建一个套接字
            ServerSocket ss = new ServerSocket(20188);

            //监听连接连接
            Socket socket = ss.accept();
            System.out.println("Connected successfully.");

            //监听到连接后启动多线程
            panduan(new Answer().ans(socket));
        }
    }

    public void panduan(String str){
        if(str.equals("e"))
            return;
        if(str.charAt(0)==HOST){
            if(str.equals(OPEN_LOCK))
                top.bearcabbage.pbs.host.LockCommand.open();
            if(str.equals(CLOSE_LOCK))
                top.bearcabbage.pbs.host.LockCommand.close();
            if(str.equals(GET_GPS))
                top.bearcabbage.pbs.host.LockCommand.getgps();
            if(str.equals(GET_TIME))
                top.bearcabbage.pbs.host.LockCommand.gettime();
            if(str.equals(GET_STATE))
                top.bearcabbage.pbs.host.LockCommand.getstate();
        }
}
