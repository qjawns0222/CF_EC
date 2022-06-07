import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWprlEx01 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader;
		String url=null;
		InetAddress addr=null;
		
		reader=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("웹사이트 주소 입력>>");
		
		url=reader.readLine();
		
		try {
			addr=InetAddress.getByName(url);
			
		}catch(UnknownHostException ue) {
			ue.printStackTrace();
		}
		System.out.println("================================>");
		System.out.println(url+"의 ip번호"+addr.getHostAddress());
		
	}

}
