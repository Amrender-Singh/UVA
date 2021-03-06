import java.io.*;
import java.util.*;

class Reader{
    BufferedReader br;
    StringTokenizer st;
    Reader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        if(st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());                
            } catch (Exception e) {
               
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            
        }
        return str;
    }
}

 public class Containers {
    public static int getStackCount(String containers){
        ArrayList<Stack<Character>> list = new ArrayList<>();
        boolean found = false;
        for(int i = 0; i < containers.length(); i++){
            for(Stack<Character> s : list){
                if(s.peek() >= containers.charAt(i)){
                    s.push(containers.charAt(i));
                    found = true;
                    break;
                }
            }
            if(!found){
                Stack<Character> s = new Stack();
                s.push(containers.charAt(i));
                list.add(s);
            }
            found = false;
        }
        return list.size();
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        int caseNo = 1;
        while((s = sc.nextLine()) != null && !s.equals("end")){
            output.append("Case " + caseNo + ": " + getStackCount(s) + "\n");
            caseNo++;
        }
        System.out.print(output.toString());
    }
}