public class PureRecursion{
 public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for(int i = 0; i<=matrix.length-1 ; i++){
          for(int j = 0; j<=matrix[i].length-1 ; j++){
          int x = getLongestPath(matrix, i, j);
          if(x > max) max = x;
          }
        }
        return max;
    }
  public int getLongestPath(int[][] matrix, int i, int j){
    int length = 1;
    int top = 0;
    int bottom = 0;
    int right = 0;
    int left = 0;

    //top
    if(j>=0 && i > 0 && i< matrix.length && j<matrix[i].length && matrix[i-1][j] > matrix[i][j]){
       top = length + getLongestPath(matrix,i-1,j);
    }

    //left
    if(j>0 && i >= 0 && i< matrix.length && j<matrix[i].length && matrix[i][j-1] > matrix[i][j]){
     left = length + getLongestPath(matrix,i,j-1);
   }

   //bottom
   if(j >= 0 && i >= 0 && i<matrix.length-1 && j<matrix[i].length && matrix[i+1][j] > matrix[i][j]){
     bottom = length + getLongestPath(matrix,i+1,j);
   }

   //right
   if(j>=0 && i >=0 && i< matrix.length && j<matrix[i].length - 1 && matrix[i][j+1] > matrix[i][j]){
     right = length + getLongestPath(matrix,i,j+1);
   }
   int max1 = Math.max(top,bottom);
   int max2 = Math.max(left,right);
  int max3 = Math.max(Math.max(max1,max2),length);
  return max3;

  }
  public static void main(String[] args) {
    Main m = new Main();
    int[][] matrix = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1}
    };

    System.out.println(m.longestIncreasingPath(matrix));
  }
}
