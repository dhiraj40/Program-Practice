import java.util.*;

/*
Input format
    first line is n -> no. of nodes
    next n-1 lines contains pair of integer u and v as edge of graph
    q contains number f queries
    next q lines contains u(source) and v(destination) for which we have to find path
    
Sample Input 1
6
1 2
3 1
1 4
4 5
4 6
3
5 2
5 3
4 4

Sample Input 2
10
10 2
2 5
3 5
5 6
5 7
7 1
6 4
7 9
4 8
2
10 9
8 6
*/
class  Main
{
    static  List<List<Integer>> adjacency = new ArrayList<>();

    static boolean getPath(int u,int v,List<Integer> path,Set<Integer> visited){
        visited.add(u);
        if(u==v){
            return true;
        }
        boolean ispath = false;
        for(Integer x:adjacency.get(u)){
            if(!visited.contains(x)){
                path.add(x);
                boolean t_ispath = getPath(x,v,path,visited);
                if(!t_ispath){
                    path.remove(x);
                }
                ispath = ispath||t_ispath;
            }
        }
        return ispath;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0;i<=n;i++) adjacency.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjacency.get(a).add(b);
            adjacency.get(b).add(a);
        }
        
        System.out.println(adjacency);
        int q = sc.nextInt();
        
        while(q-- > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
        
            List<Integer> path = new ArrayList<>();
            path.add(u);
            
            getPath(u,v,path,new HashSet<>());
            System.out.println(path);
        }

    }
}
