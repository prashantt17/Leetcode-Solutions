package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangles {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		//		   2
		//		  3 4
		//		 6 5 7
		//		4 1 8 3
			
		triangle.add(0, new ArrayList<>(Arrays.asList(2)));
			triangle.add(1, new ArrayList<>(Arrays.asList(3,4)));
			triangle.add(2, new ArrayList<>(Arrays.asList(6,5,7)));
			triangle.add(3, new ArrayList<>(Arrays.asList(4,1,8,3)));
		
		int minimumTotal = minimumTotal(triangle);
			System.out.println("minimumTotal: " + minimumTotal);
	}
	

	
	
	public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int self = triangle.get(i).get(j);
                
                int a = triangle.get(i + 1).get(j);
                int b = triangle.get(i + 1).get(j + 1);
                int res = Math.min(a,b) + self;
                triangle.get(i).set(j, res);
            }
        }
        
        return triangle.get(0).get(0);
    }

}
