public class Main {
    public static void main(String[] args) {
        int INF = 1000000000;
        int dist[][] = {{0,7,INF,INF,3,10,INF},
                 {7,0,4,10,2,6,INF},
                 {INF,4,0,2,INF,INF,INF},
                 {INF,10,2,0,11,9,4},
                 {3,2,INF,11,0,INF,5},
                 {10,6,INF,9,INF,0,INF},
                 {INF,INF,INF,4,5,INF,0}};
        
        for(int k = 0; k < 7; k++) {
            for(int i = 0; i < 7; i++) {
                for(int j = 0; j < 7; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(dist[i][j] + "        ");
            }
            System.out.println();
        }

    }
}