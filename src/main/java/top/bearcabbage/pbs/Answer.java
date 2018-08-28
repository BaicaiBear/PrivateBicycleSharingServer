package top.bearcabbage.pbs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Answer extends MainClass{

    public String ans(Socket socket) throws IOException {
        String str = new String();
        try{
            //获取输入输出流
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] buffer = new byte[200];

            int length = 0;
            length = is.read(buffer);
            str = new String(buffer,0,length);
            System.out.println("GetData: "+ str);

            //服务端反馈
            os.write("get".getBytes());

            //关闭资源
            is.close();
            os.close();
            socket.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return ERROR;
        }
        finally {
            return str;
        }
    }
}
