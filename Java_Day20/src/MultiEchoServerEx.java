import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiEchoServerEx {

	ServerSocket server;
	static final int PORT=7002;
	Socket child;
	public MultiEchoServerEx() {
		try {
			server=new ServerSocket(PORT);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(">>>채팅서버<<<");
		System.out.println("서버는 클라이언트 접속요청을 기다리고 있음");
		while(true) {
			try {
				child=server.accept();
				EchoServerThread th= new EchoServerThread(child);
				Thread t=new Thread(th);
				t.start();
			}catch(Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) {
		new MultiEchoServerEx();
	}

}
class EchoServerThread implements Runnable{
	Socket child;
	
	InputStream is;
	ObjectInputStream ois;
	
	OutputStream os;
	ObjectOutputStream oos;
	String receiveData;
	public EchoServerThread(Socket child) {
		this.child=child;
		try {
			System.out.println(child.getInetAddress()+"로 부터 연결 요청");
			is=child.getInputStream();
			ois=new ObjectInputStream(is);
			
			os=child.getOutputStream();
			oos=new ObjectOutputStream(os);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			while(true) {
				receiveData=(String)ois.readObject();
				System.out.println(child.getInetAddress()+"의 메시지"+receiveData);
				oos.writeObject(receiveData);
				oos.flush();
			}
		}catch(Exception e) {
			System.out.println("클라이언트 강제 조료");
		}finally {
			   try {
		            if(is != null) is.close();
		            if(ois != null) ois.close();
		            if(os != null) os.close();
		            if(oos != null) oos.close();
		         }catch(Exception e) {e.printStackTrace();}

		}
	}
	
}
