
public class UnionFind {
    private final int[] parent;

    // Constructor
    public UnionFind(int size) {
      
        // Initialize the parent array with each 
        // element as its own representative
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find the representative (root) of the 
    // set that includes element i
    public int find(int i) {
      
        // if i itself is root or representative
        if (parent[i] == i) {
            return i;
        }
      
        // Else recursively find the representative
        // of the parent 
        return find(parent[i]);
    }

    // Unite (merge) the set that includes element 
    // i and the set that includes element j
    public void union(int i, int j) {
      
        // Representative of set containing i
        int irep = find(i);

        // Representative of set containing j
        int jrep = find(j);

        // Make the representative of i's set be 
        // the representative of j's set
        parent[irep] = jrep;
    }

    public static void main(String[] args) {
        int size = 5;
        UnionFind uf  = new UnionFind(size);
        uf.union(1, 2);
        uf.union(3, 4);
        boolean inSameSet = uf.find(1) == uf.find(2);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);

        inSameSet = uf.find(1) == uf.find(3);
        System.out.println("Are 1 and 3 in the same set? " + inSameSet);

        uf.union(1, 4);
        inSameSet = uf.find(1) == uf.find(3);
        System.out.println("Are 1 and 3 in the same set? " + inSameSet);

        inSameSet = uf.find(2) == uf.find(3);
        System.out.println("Are 2 and 3 in the same set? " + inSameSet);

    }
}