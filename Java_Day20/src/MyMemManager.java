import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyMemManager {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Mymember> da=new ArrayList<Mymember>();
		Mymember cu=null;
		int re_mod=0;
		int re_del=0;
		boolean start=true;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(start) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원검색");
			System.out.println("3. 정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 전체목록");
			System.out.println("0. 프로그램종료");
			System.out.print("메뉴선택:");
			int sel=Integer.parseInt(br.readLine());
			switch(sel) {
			case 1:
				da.add(cre());
				System.out.println("성공적으로 가입하였습니다.");
				break;
			case 2:
				cu=selone(da);
				
				if(cu!=null) {
					System.out.println("검색에 성공하셧습니다.");
				}else {
					System.out.println("찾는 데이터가 없습니다.");
				}
				break;
			case 3:
				if(cu==null) {
					System.out.println("검색을 먼저수행해주세요");
					break;
				}
				re_mod=Mod(da,cu);
				if(re_mod==1) {
					System.out.println("수정 성공");
				}
				
				
				break;
			case 4:
				if(cu==null) {
				System.out.println("검색을 먼저수행해주세요");
				break;
			}
			re_del=del(da,cu);
			da.remove(re_del);
			if(re_del>=0) {
				System.out.println("삭제 성공");
			}
				
				break;
			case 5:
				selall(da);
				if(da.isEmpty()) {
					System.out.println("데이터가 없습니다.");
				}
				break;
			case 0:
				start=false;
				break;
			default:
				
				break;
			
			}
		}
		br.close();

	}
	public static Mymember cre() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름:");
		String name=br.readLine();
		System.out.print("나이:");
		int age=Integer.parseInt(br.readLine());
		System.out.print("전화:");
		int pho=Integer.parseInt(br.readLine());
		System.out.print("주소:");
		String add=br.readLine();
		return new Mymember(name,age,pho,add);
	}
	public static void selall(ArrayList<Mymember> da) {
		for(Mymember d:da) {
			System.out.println("이름:"+d.getName());
			
			System.out.println("나이:"+d.getAge());
			
			System.out.println("전화:"+d.getPho());
			
			System.out.println("주소:"+d.getAdd());
			
		}
		
	}
	public static Mymember selone(ArrayList<Mymember> da) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름:");
		String name=br.readLine();
		for(Mymember d:da) {
			
			if(name.equals(d.getName())) {
				System.out.println(d.getName());
				return d;
			};
		}
		return null;
	}
	public static int Mod(ArrayList<Mymember> da,Mymember cu) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int re=0;
		System.out.println("1. 연락처수정");
		System.out.println("2. 주소록 수정");
		System.out.println("0.수정취소");
		System.out.print("메뉴 선택:");
		int sel=Integer.parseInt(br.readLine());
		switch(sel) {
			case 1:
				System.out.println(cu.getName()+"님의 정보를 수정합니다.");
				System.out.print("연락처 수정:");
				int pho=Integer.parseInt(br.readLine());
				for(Mymember d:da) {
					
					if(cu.getName().equals(d.getName())) {
						d.setPho(pho);
						
					};
				}
				re=1;
				break;	
			case 2:
				System.out.println(cu.getName()+"님의 정보를 수정합니다.");
				System.out.print("주소록 수정:");
				String add=br.readLine();
				for(Mymember d:da) {
					
					if(cu.getName().equals(d.getName())) {
						d.setAdd(add);
						
					};
				}
				re=1;
				break;
			case 0:
				
				break;
			default:
				break;
		}
		return re;
	}
	public static int del(ArrayList<Mymember> da,Mymember cu) throws IOException {
		boolean st=true;
		int re=-1;
		while(st) {
		System.out.print(cu.getName()+"님의 정보를 삭제하시겠습니까?(y/n):");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String sel=br.readLine();
		if(sel.equals("y") || sel.equals("n")) {
				st=false;
				switch(sel) {
				case "y":
					for(Mymember d:da) {
						
						System.out.println(da.indexOf(d));
						if(cu.getName().equals(d.getName())) {
							
							re=da.indexOf(d);
							
						};
					}
					
					break;
				case "n":
					break;
				
				}
				
			}
		}
		return re;
	
	}

}
