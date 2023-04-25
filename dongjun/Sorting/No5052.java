import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            // 전화번호의 수
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            ArrayList<String> phoneNumberList = new ArrayList<>();
            for (int j=0; j<n; j++) {
                String phoneNumber = br.readLine();

                trie.add(phoneNumber);
                phoneNumberList.add(phoneNumber);
            }
            String answer = getAnswer(trie, phoneNumberList);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static String getAnswer(Trie trie, ArrayList<String> phoneNumberList) {
        for (String phoneNumber: phoneNumberList) {
            if (!trie.valid(phoneNumber)) return "NO";
        }
        return "YES";
    }

    public static class Trie {
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        // 노드 삽입
        void add(String phoneNumber) {
            Node node = this.root;
            for(int i=0; i<phoneNumber.length(); i++) {
                node = node.children.computeIfAbsent(phoneNumber.charAt(i)-'0', n -> new Node());
            }
            node.last = true;
        }

        // 일관성이 없는 목록인지 확인
        boolean valid(String phoneNumber) {
            // 마지막 노드 찾기
            Node lastNumberNode = this.root;
            for(int i=0; i<phoneNumber.length(); i++){
                lastNumberNode = lastNumberNode.children.get(phoneNumber.charAt(i)-'0');
            }

            // 마지막 노드가 올바른 leaf node 형태라면 return true
            // 마지막 노드가 올바르지 않은 leaf node 형태라면 return false
            return lastNumberNode.last && lastNumberNode.children.isEmpty();
        }
    }

    public static class Node {
        private Map<Integer, Node> children = new HashMap<>();
        private boolean last;
    }
}