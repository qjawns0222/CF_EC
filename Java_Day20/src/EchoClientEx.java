import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClientEx {
	Socket client=null;
	String ipAddress;
	static final int PORT=7002;
	BufferedReader read;
	
	InputStream is;
	ObjectInput ois;
	
	OutputStream os;
	ObjectOutputStream oos;
	
	String sendData;
	String receiveData;
	
	public EchoClientEx(String ipAddress){
		this.ipAddress=ipAddress;
		try {
			System.out.println(">>클라이언트<<");
			client=new Socket(ipAddress,PORT);
			read= new BufferedReader(new InputStreamReader(System.in));
			
			os=client.getOutputStream();
			oos=new ObjectOutputStream(os);
			
			is=client.getInputStream();
			ois=new ObjectInputStream(is);
			
			System.out.println("입력>>");
			while((sendData=read.readLine())!=null) {
				oos.writeObject(sendData);
				oos.flush();
				if(sendData.equals("quit")) {
					break;
				}
				receiveData=(String)ois.readObject();
				System.out.println(client.getInetAddress()+"로 부터 받은 메시지:"+receiveData);
				System.out.println("입력>>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				if(is!=null)is.close();
				if(ois!=null)ois.close();
				if(os!=null)os.close();
				if(oos!=null)oos.close();
				if(client!=null)client.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		
	}

	public static void main(String[] args) {
		new EchoClientEx("127.0.0.1");

	}

}
