package DisjointSet;

public class NumberOfProvinces {

    /*

    Input:
        [
         [1, 0, 1],
         [0, 1, 0],
         [1, 0, 1]
        ]

        Output:
        2
     */

    static class DisjointSet{

        private int size;
        private int[] parent;
        DisjointSet(int size){
            this.size = size;
            this.parent = new int[size];
            for(int i = 0; i  < size; i++){
                this.parent[i] = i;
            }
        }

        private int find(int num){
            if(parent[num] == num){
                return num;
            }
            return find(parent[num]);
        }

        public void union(int num1, int num2){
            int parent1 = find(num1);
            int parent2 = find(num2);

            if(parent1 != parent2){
                parent[parent1] = parent2;
                size -= 1;
            }
        }

        public int size(){
            return this.size;
        }

    }

    public static void main(String[] args) {

        int[][] matrix = { {1, 0, 1},{0, 1, 0},{1, 0, 1}};

        int nodes = matrix.length;
        DisjointSet set = new DisjointSet(nodes);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    set.union(i, j);
                }
            }
        }

       System.out.println("Result : "+ set.size());
    }


}
