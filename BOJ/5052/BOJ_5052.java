import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @num 5052
 * @title 전화번호 목록
 * @author Jiwoo Choi
 * @date 22.01.04.
 */

public interface BOJ_5052 {

  static class Node {
    Map<Character, Node> chiledNode = new HashMap<>();  // 자식 노드

    boolean endOfword; // 단어의 끝인지 체크
  }

  static class Trie {
    Node rootNode = new Node(); // rootNode 기본적으로 생성

    boolean insert(String str) { // Trie에 문자열 저장
      Node node = this.rootNode;  // Trie 자료구조는 항상 rootNode부터 시작

      // 문자열의 각 단어마다 가져와서 자식 노드 중에서 있는지 체크
      // 없으면 자식 노드 새로 생성
      for (int i = 0; i < str.length(); i++) {
        node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
        // System.out.println(node.endOfword);
        if(node.endOfword == true)  return true;
      }

      if(node.chiledNode.size() != 0) return true;
      
      node.endOfword = true;  // 저장할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
      return false;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      boolean res = false;

      Trie trie = new Trie();

      for (int i = 0; i < n; i++) {
        if(trie.insert(br.readLine())) {
          res = true;
          continue;
        }
      }
      sb.append(res == false ? "YES\n" : "NO\n");
    }
    System.out.println(sb.toString());
  }
}
