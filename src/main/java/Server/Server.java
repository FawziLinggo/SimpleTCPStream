package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public  static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Boolean stop = true;



        while (stop){
                try {
                    Socket s = ss.accept();
                    System.out.println("Client Connected");
                    PrintWriter pr = new PrintWriter(s.getOutputStream());
                    InputStreamReader inputStreamReader = new InputStreamReader(s.getInputStream());
                    BufferedWriter bufferedWriter = new BufferedWriter(pr);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String text;
                    Scanner scanner = new Scanner(System.in);

                    while (stop){
                        System.out.println("Tekan 1 untuk Type : T" + " dan " + "2 Type : N");
                        text = scanner.nextLine();
                        if (text.equals("1")) {
                            for (int i = 0; i < 5; i++) {
                                Json json = new Json("T", i);
                                bufferedWriter.write(json.toString());
                                bufferedWriter.newLine();
                            }
                        }
                        if (text.equals("2")) {
                            for (int i = 0; i < 5; i++) {
                                Json json = new Json("N", i);
                                bufferedWriter.write(json.toString());
                                bufferedWriter.newLine();
                            }
                        }
                        if (text.equals("bye")) {
                            bufferedWriter.close();
                            s.close();
                        }
                        bufferedWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } stop = true;
        }
    }
}

