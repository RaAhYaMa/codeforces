import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class C {
    private static InputReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            LinkedList<Long> odd = new LinkedList<>();
            LinkedList<Long> even = new LinkedList<>();
            // long odd = 0;
            // long even = 0;
            long max = Long.MIN_VALUE;
            while (n > 0) {
                long x = in.nextLong();
                if (x % 2 == 0) {
                    even.add(x);
                }
                else {
                    odd.add(x);
                }
                max = Math.max(max, x);
                n--;
            }
            boolean isOdd = max % 2 == 1;
            long result = max;
            if (isOdd) {
                odd.remove(max);
            }
            else {
                even.remove(max);
            }
            while (true) {
                if (isOdd) {
                    if (even.isEmpty()) {
                        break;
                    }
                    isOdd = false;
                    long x = even.poll();
                    x--;
                    if (x > 0) {
                        odd.add(x);
                    }
                }
                else {
                    if (odd.isEmpty()) {
                        break;
                    }
                    isOdd = true;
                    long x = odd.poll();
                    x--;
                    if (x > 0) {
                        even.add(x);
                    }
                }
                result++;
            }
            out.println(result);
            t--;
        }

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
