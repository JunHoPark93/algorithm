public class Main {
    public static void main(String[] args) {
        int[][] arr = { {0,0,1,1,0},
                        {1,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,1},
                        {0,0,0,0,0}};

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        for(int k = 0; k < 5; k++) {
            for(int i = 0; i < 5; i++) {
                for(int j =0 ; j < 5; j++) {
                    if(arr[i][k] == 0)
                        continue;
                    if(arr[k][j] == 1)
                        arr[i][j] = 1;
                }
            }
        }

        System.out.println();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }               
}