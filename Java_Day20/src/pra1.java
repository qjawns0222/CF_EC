import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class user{
	public String name;
	public int mail=0;
	public List<String> att=new ArrayList();
	public List<String> def=new ArrayList();
	user(String name){
		this.name=name;
	}
	public List<String> getAtt() {
		return att;
	}
	public void setAtt(String att) {
		this.att.add(att);
	}
	public List<String> getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def.add(def);
	}
	
}

public class pra1 {

	public static void main(String[] args) {
		for(int k:solution()) {
			System.out.println(k);
		};

		
		 
	}
	public static int[] solution() {
		String[] id_list={};
		 String[] report={};
		 int k=2;
		 
		 List<Integer> finalre=new ArrayList();
		 
		 List<String> idlist=new ArrayList(Arrays.asList(id_list));
		 List<String> reports=new ArrayList(Arrays.asList(report));
		 
		 List<user> userdata=new ArrayList();
		 List<String> result=new ArrayList();
		
		
		 
		 int size=0;
		 
		 for(String u:idlist) {
			 userdata.add(new user(u));
			 
		 }
		
		 
		 for(String a:reports) {
			 
			 for(user d:userdata) {
				 
				if(d.name.equals(a.split(" ")[0])) {
					if(!d.att.contains(a.split(" ")[1])) {
					d.setAtt(a.split(" ")[1]);
					
					}
				};
				if(d.name.equals(a.split(" ")[1])) {
					if(!d.def.contains(a.split(" ")[0])) {
					d.setDef(a.split(" ")[0]);
					
					}
				};
			 }
			 
		 }
		 for(user d:userdata) {
			 if(d.def.size()>=k) {
				 result.add(d.name);
			 }
			 
		 }
		 for(String m: result) {
			 for(user d:userdata) {
				if(d.att.contains(m)) {
					d.mail++;
				}
				 
			 }
			 
		 }
		 for(user d:userdata) {
				
				
					 finalre.add(d.mail);
				
			 }
		 int[] ret = finalre.stream().mapToInt(i -> i).toArray();
		 
		
		
		 return ret;
	
		
		 
		
	}

}
