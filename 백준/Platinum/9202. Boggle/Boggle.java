import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9202
public class Main {
    static TrieNode root = new TrieNode();
    static int w, b;
    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static StringBuilder sb;

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++) {
            insertTrieNode(br.readLine());
        }
        br.readLine();
        b = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                String in = br.readLine();
                for (int k = 0; k < 4; k++) {
                    map[j][k] = in.charAt(k);
                }
            }
            br.readLine();
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    // 출발 가능 조건 -> root 가 해당 child 를 가지면
                    if (root.hasChild(map[x][y])) {
                        search(x, y, root.getChild(map[x][y]));
                    }
                }
            }
            // 결과 출력
            resultSb.append(sum + " " + answer + " " + count + "\n");
            root.clearHit();
        }
        System.out.println(resultSb.toString());
    }

    static void search(int x, int y, TrieNode node) {
        // 1. 체크인 -> visited
        visited[x][y] = true;
        sb.append(map[x][y]);
        // 2. 목적지에 도달하였는가 -> isWord == true, isHit == false
        if (node.isWord && !node.isHit) {
            node.isHit = true;
            // 답 -> 길이, 단어,
            String foundWord = sb.toString();
            int length = foundWord.length();
            count++;
            sum += score[length];
            if (answer.length() < length) {
                answer = foundWord;
            } else if (answer.length() == length) {
                if (answer.compareTo(foundWord) > 0) {
                    answer = foundWord;
                }
            }
        }
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            // 4. 가능한가? -> map 경계, 방문하지 않았는지, node 가 해당 자식을 가지고 있는지
            if (0 <= tx && tx < 4 && 0 <= ty && ty < 4) {
                if (visited[tx][ty] == false && node.hasChild(map[tx][ty])) {
                    // 5. 간다
                    search(tx, ty, node.getChild(map[tx][ty]));
                }
            }
        }

        // 6. 체크아웃
        sb.deleteCharAt(sb.length() - 1);
        visited[x][y] = false;
    }

    static void insertTrieNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (current.child[a - 'A'] == null) {
                current.child[a - 'A'] = new TrieNode();
            } // 자식이 생김
            current = current.child[a - 'A'];
        }
        // 단어 완성
        current.isWord = true;
    }
}

class TrieNode {
    boolean isWord = false;
    boolean isHit = false;
    TrieNode[] child = new TrieNode[26];

    void clearHit() {
        isHit = false;
        for (int i = 0; i < child.length; i++) {
            if (child[i] != null) {
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c) {
        return child[c - 'A'] != null;
    }

    TrieNode getChild(char c) {
        return child[c - 'A'];
    }
}