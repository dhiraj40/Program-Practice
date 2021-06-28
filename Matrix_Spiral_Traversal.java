import java.io.*;
import java.util.*;
class Matrix_Spiral_Traversal
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}

class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> arr = new ArrayList<>(r*c);
        int lb = 0,rb = c-1,ub = 0,db = r-1;
        
        int loopcount = Math.min(r/2,c/2);
        
        for(int i =0;i<loopcount;i++){
            for(int col = lb;col<=rb;col++) {
                arr.add(matrix[ub][col]);
            }
            ub = ub + 1;
            
            for(int row = ub;row<=db;row++){
                arr.add(matrix[row][rb]);
            }
            rb = rb - 1;
            
            for(int col=rb;col>=lb;col--){
                arr.add(matrix[db][col]);
            }
            db = db - 1;
            
            for(int row=db;row>=ub;row--){
                arr.add(matrix[row][lb]);
            }
            lb = lb + 1;
            
        }
        
        if(arr.size() <r*c){
            for(int col = lb;col<=rb;col++) {
                arr.add(matrix[ub][col]);
            }
            ub = ub + 1;
            
            for(int row = ub;row<=db;row++){
                arr.add(matrix[row][rb]);
            }
            rb = rb - 1;
        }
        
        return arr;
        
    }
}
