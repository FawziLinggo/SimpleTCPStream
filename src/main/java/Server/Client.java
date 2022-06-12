package Server;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4999);

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        while (true){
            String str = bf.readLine();
            if (str == null){
                s.close();
                bf.close();
            }
            System.out.println(str);

        }
    }
}
