public class Intro{
    public static void main(String[] args){
        // int[] strg = new int[n+1];
        // int n = 45;
        // long startTime = System.currentTimeMillis();
        // // System.out.println(fib(40));

        // System.out.println(fibBtr(40,strg));
        // long endTime = System.currentTimeMillis();
        // System.out.println(endTime-startTime);

        // System.out.println(climbDown(5));
        // int[] strg = new int[6];
        // System.out.println(climbDownBtr(5,strg));
        // System.out.println(climbDownTabulation(5));
        System.out.println(mazePaths(2, 2));
        System.out.println(mazePaths2(2, 2));

    }

    public static int fib(int n){

        if(n==1||n==2){
            return n-1;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);

        int fibn = fibnm1 +fibnm2;
        return fibn;
    }

    public static int fibBtr(int n, int[] strg){
        if(n==1||n==2){
            return n-1;
        }

        if(strg[n]!=0){
            return strg[n];
        }
        int fibnm1 = fibBtr(n-1,strg);
        int fibnm2 = fibBtr(n-2,strg);

        int fibn = fibnm1 +fibnm2;
        strg[n] = fibn;
        return fibn;
    }

    // H.w. Print All the paths
    public static int climbDown(int n){

        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        return climbDown(n-1)+climbDown(n-2)+climbDown(n-3);
    }

    // Memoisation
    public static int climbDownBtr(int n,int [] strg){

        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }

        if(strg[n]!=0){
            return strg[n];
        }
        return strg[n] = climbDownBtr(n-1,strg)+climbDownBtr(n-2,strg)+climbDownBtr(n-3,strg);
    }

    // public static int climbDownBtr(int n,int [] strg){

    //     if(n==1){
    //         return 1;
    //     }
    //     if(n==2){
    //         return 2;
    //     }
    //     if(n==3){
    //         return 4;
    //     }

    //     if(strg[n]!=0){
    //         return strg[n];
    //     }
    //     strg[n-1] = climbDownBtr(n-1,strg);
    //     strg[n-2] = climbDownBtr(n-2,strg);
    //     strg[n-3] = climbDownBtr(n-3,strg);
    //     strg[n] = strg[n-1]+strg[n-2]+strg[n-3];
    //     return strg[n];
    // }

    public static int climbDownTabulation(int n){
        int[] strg=new int[n+1];    
        strg[1] = 1;
        strg[2] = 2;
        strg[3] = 4;
        for(int i=4;i<=n;i++){
            strg[i] = strg[i-1]+strg[i-2]+strg[i-3];
        }

        return strg[n];
    }

    public static int mazePaths(int dr,int dc){
        int[][] strg= new int[dr+1][dc+1];  
        for(int i=0;i<=dr;i++){
            for(int j=0;j<=dc;j++){
                if(i==0&&j==0){
                    strg[i][j] = 1;
                }else if(i==0){
                    strg[i][j] = strg[i][j-1];
                }else if(j==0){
                    strg[i][j] = strg[i-1][j];
                }else{
                    strg[i][j] = strg[i-1][j]+strg[i][j-1];
                }
            }
        }  
        return strg[dr][dc];
    }

    public static int mazePaths2(int dr,int dc){
        int[][] strg= new int[dr+1][dc+1];  
        for(int i=dr;i>=0;i--){
            for(int j=dc;j>=0;j--){
                if(i==dr&&j==dc){
                    strg[i][j] = 1;
                }else if(i==dr){
                    strg[i][j] = strg[i][j+1];
                }else if(j==dc){
                    strg[i][j] = strg[i+1][j];
                }else{
                    strg[i][j] = strg[i+1][j]+strg[i][j+1];
                }
            }
        }  
        return strg[0][0];
    }
}