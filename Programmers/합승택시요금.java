import java.util.*;

class 합승택시요금 {
    private static final int INF = Integer.MAX_VALUE;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;
    
    
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        

        // (S -> 합승) + (합승 -> A) + (합승 -> B)
        int[] share = dijkstra(s, n);
        int[] muzi = dijkstra(a, n); // 무지 혼자
        int[] apeach = dijkstra(b, n);  // 어피치 혼자

        System.out.println(Arrays.toString(share));
        System.out.println(Arrays.toString(muzi));
        System.out.println(Arrays.toString(apeach));

        // answer = Math.min(muzi, Math.min(apeach, Math.min(share1, share2)));
        answer = INF;
        for (int i = 1; i < n + 1; i++) {
            if(share[i] != INF || muzi[i] != INF || apeach[i] != INF){
                answer = Math.min(share[i] + muzi[i] + apeach[i], answer);
            }
        }

        return answer;
    }
    
    private static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.distance, node.distance);
        }
    }
    
    private static int[] dijkstra(int index, int n){
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(index, 0));
        dist[index] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIndex = node.index;
            int nodeDistance = node.distance;

            if(nodeDistance > dist[nodeIndex]){
                continue;
            }

            for(Node linkedNode : graph.get(nodeIndex)) { 
                if(nodeDistance + linkedNode.distance < dist[linkedNode.index]) {
                    dist[linkedNode.index] = nodeDistance + linkedNode.distance;
                    pq.offer(new Node(linkedNode.index, dist[linkedNode.index]));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) {
        int n1 = 6, s1 = 4, a1 = 6, b1 = 2;
        int[][] fares1 = {
            {4, 1, 10},
            {3, 5, 24},
            {5, 6, 2},
            {3, 1, 41},
            {5, 1, 24},
            {4, 6, 50},
            {2, 4, 66},
            {2, 3, 22},
            {1, 6, 25}
        };

        System.out.println(solution(n1, s1, a1, b1, fares1));


        int n2 = 7, s2 = 3, a2 = 4, b2 = 1;
        int[][] fares2 = {
            {5, 7, 9},
            {4, 6, 4},
            {3, 6, 1},
            {3, 2, 3},
            {2, 1, 6}
        };

        System.out.println(solution(n2, s2, a2, b2, fares2));

        int n3 = 6, s3 = 4, a3 = 5, b3 = 6;
        int[][] fares3 = {
            {2, 6, 6},
            {6, 3, 7},
            {4, 6, 7},
            {6, 5, 11},
            {2, 5, 12},
            {5, 3, 20},
            {2, 4, 8},
            {4, 3, 9}
        };

        System.out.println(solution(n3, s3, a3, b3, fares3));

    }
}