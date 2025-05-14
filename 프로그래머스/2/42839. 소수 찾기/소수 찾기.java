import java.util.*;

class Solution {
    int[] prime;
    Set<Integer> arr = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        prime = new int[numbers.length() + 1];
        visited = new boolean[numbers.length()];
        searchNum(numbers, "");
        System.out.println(arr);
        return arr.size();
    }
    
    private void searchNum(String numbers, String num) {
        if (!num.equals("") && isPrime(Integer.valueOf(num))) {
            arr.add(Integer.valueOf(num));
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                searchNum(numbers, num + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n != 2 && n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n% i == 0) return false;
        } 
        return true;
    }
}