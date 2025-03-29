import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    private static InputReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        long a = in.nextLong();
        long mul;
        long curr;
        long result = 1;
        for (long i=a ; i >= Math.max(a-1, 1) ; i--) {
            mul = i;
            curr = mul;
    
            for (long b=i ; b >= 1 ; b--) {
                curr = Math.max(curr, mul / gcd(b, mul) * b);
            }
    
            mul = curr;
    
            for (long c=i ; c >= 1 ; c--) {
                curr = Math.max(curr, mul / gcd(c, mul) * c);
            }
            result = Math.max(result, curr);
        }

        out.println(result);

        out.close();
    }

    static long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
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
