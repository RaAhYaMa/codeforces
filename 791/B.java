import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B {
    private static InputReader in;
    private static PrintWriter out;
    static HashMap<Integer, HashSet<Integer>> map;
    static HashSet<Integer> set;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        map = new HashMap<>(n, 1.0f);
        set = new HashSet<>(n, 1.0f);

        for (int i=1 ; i <= n ; i++) {
            map.put(i, new HashSet<>(Math.min(n, 16), 1.0f));
        }

        while (m > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
            m--;
        }

        boolean result = true;

        for (int i=1 ; i <= n && result ; i++) {
            if (!set.contains(i)) {
                if (!BFS(i)) {
                    result = false;
                }
            }
        }

        if (result) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }

        out.close();
    }

    static boolean BFS(int start) {
        boolean result = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        int nodeCount = 0;
        int edgeCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (set.contains(node)) {
                continue;
            }
            set.add(node);
            nodeCount++;
            for (int neighbor : map.get(node)) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                }
                edgeCount++;
            }
        }

        result = edgeCount == nodeCount * (nodeCount - 1);

        return result;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public char nextChar() {
            return next().charAt(0);
        }
 
        public Long nextLong() {
            return Long.parseLong(next());
        }
    }
}
