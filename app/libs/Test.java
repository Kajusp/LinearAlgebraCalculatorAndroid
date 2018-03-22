import org.jblas.DoubleMatrix;
import org.jblas.Solve;

public class Test{
	
public static void main(String args[]){

	double M[][]={{55,67,70},{70,70,81},{72,80,69}};
	
	
	
	DoubleMatrix DM = DoubleMatrix.zeros(M.length,M[0].length);

        for (int i=0; i<M.length; i++){
            for (int j=0; j<M[i].length; j++){
                DM.put(i,j, M[i][j]);
            }
        }
	
		
	DoubleMatrix DMinverse = Solve.solve(DM, DoubleMatrix.eye(DM.rows));
	
	for (int i=0; i<M.length; i++){
            for (int j=0; j<M[i].length; j++){
                M[i][j]=DM.get(i,j);
            }
        }
        
        for (int i=0; i<M.length; i++){
            for (int j=0; j<M[i].length; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.print("\n");
        }
}
		
}
