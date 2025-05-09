import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) throws Exception{
        System.out.println("S: server has started :");
        ServerSocket ss=new ServerSocket(9999);

        System.out.println("S: server is wating for client request: ");
        Socket s=ss.accept();

        System.out.println("S: client connected :");
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str=br.readLine();
        System.out.println("S: client data: "+str);

        String nickname=str.substring(0,3);
        OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
        PrintWriter out=new PrintWriter(os);
        out.println(nickname);
        out.flush();
        System.out.println("S: DATA sent from server to client ");
        ss.close();
        




    }
}
