import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
    private static InputReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int curr;
        int temp1;
        int temp2;
        int sqrt;

        for (int i=1 ; i <= a ; i++) {
            for (int j=1 ; j <= b ; j++) {
                for (int k=1 ; k <= c ; k++) {
                    curr = i*j*k;
                    if (map.containsKey(curr)) {
                        sum = (sum + map.get(curr)) % 1073741824;
                        continue;
                    }
                    temp1 = 1;
                    sqrt = (int) Math.sqrt(curr);
                    for (int d : list) {
                        if (d > sqrt) break;
                        temp2 = 1;
                        while (curr % d == 0) {
                            temp2++;
                            curr /= d;
                        }
                        temp1 *= temp2;
                    }
                    if (curr > sqrt) {
                        list.add(curr);
                        temp1 *= 2;
                    }
                    sum = (sum + temp1) % 1073741824;
                    map.put(i*j*k, temp1);
                }
            }
        }

        out.println(sum);

        out.close();
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
