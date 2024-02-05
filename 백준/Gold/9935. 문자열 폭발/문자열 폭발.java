import java.util.*;
import java.io.*;

class Main{
    static String input;
    static String bomb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        bomb = br.readLine();
        int blen = bomb.length();
        List<Character> st = new ArrayList();
        for (int i = 0 ; i < input.length();i++){
            st.add(input.charAt(i));
            if(input.charAt(i) == bomb.charAt(blen - 1) && st.size() >= blen) {
                boolean check = false;
                int k = 0;
                for(int j = st.size() - blen;j < st.size();j++){
                    if(st.get(j) != bomb.charAt(k)){
                        check = true;
                        break;
                    }
                    k++;
                }
                if(!check){
                    int s = st.size();
                    for(int j = 0 ; j < blen;j++){
                        st.remove(s - j - 1);
                    }
                }
            }
        }
        if(st.size()<= 0){
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < st.size();i++){
            sb.append(st.get(i));
        }
        System.out.println(sb);
    }
}