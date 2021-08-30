import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    HashMap<String,Integer> map = new HashMap<>();
	    map.put("zero",0);
	    map.put("one",1);
	    map.put("two",2);
	    map.put("three",3);
	    map.put("four",4);
	    map.put("five",5);
	    map.put("six",6);
	    map.put("seven",7);
	    map.put("eight",8);
	    map.put("nine",9);
	    map.put("ten",10);
	    map.put("evelen",11);
	    map.put("twelve",12);
	    map.put("thirteen",13);
	    map.put("forteen",14);
	    map.put("fifteen",15);
	    map.put("sixteen",16);
	    map.put("seventeen",17);
	    map.put("eighteen",18);
	    map.put("nineteen",19);
	    map.put("twenty",20);
	    map.put("thirty",30);
	    map.put("fourty",40);
	    map.put("fifty",50);
	    map.put("sixty",60);
	    map.put("seventy",70);
	    map.put("eighty",80);
	    map.put("ninety",90);
	    
	    
	    InputStreamReader reader = new InputStreamReader(System.in);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    
	    while((line = in.readLine()) != null){
	        int ans = 0;
	        
	        int[] vals = new int[4];
	        
	        [ _ , 1 , 100 , _ ]
	        
	        for(String st:line.split(" ")){
	            if(st.equals("hundred")) ans *= 100;
	            else if(st.equals("thousand")) {
	                vals[2] = ans;
	                ans = 0;
	            }
	            else if(st.equals("million")){
	                vals[1] = ans;
	                ans = 0;
	            }
	            else if(st.equals("billion")){
	                vals[0] = ans;
	                ans = 0;
	            }
	            else ans += map.get(st); 
	        }
	        vals[3] = ans;
	        ans = 0;
	        
	        for(int i:vals){
	            ans = ans*1000 + i;
	        }
	        
	        System.out.println(ans);
	    }
	}
}
