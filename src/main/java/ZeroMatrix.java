
public class ZeroMatrix {

public static int[][] setMatrixZeroes(int[][] matrix, Integer n, Integer m) {

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix,i, m);
                    markColm(matrix,j,n);
                }
            }
        }
       return markZero(matrix, n, m);
    }
    public static void markRow(int[][] matrix, int i, Integer n){
        for(int j=0; j< n; j++){
            if(matrix[i][j]!= 0){
            matrix[i][j]= -1;
            }
        }
    }
    public static void markColm(int[][] matrix, int j, Integer m){
        for(int i=0; i< m; i++){
            if(matrix[i][j]!= 0){
            matrix[i][j]= -1;
            }
        }
    }

    public static int[][] markZero(int[][] matrix, Integer n, Integer m){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
              if(matrix[i][j]== -1){
                  matrix[i][j]= 0;
              }     
            }
            
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
 
        // Function call
        setMatrixZeroes(matrix, matrix.length, matrix[0].length);
 
        // Print the modified matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
