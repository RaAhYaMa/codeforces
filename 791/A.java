import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    private static InputReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        int a = in.nextInt();
        int b = in.nextInt();

        int result = (int) (Math.log(Double.valueOf(b) / Double.valueOf(a)) / Math.log(1.5)) + 1;

        out.println(result);

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
