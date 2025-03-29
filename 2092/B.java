import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
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
            String a = in.next();
            String b = in.next();
            String c = "";
            int i;
            int x = 0;
            int y = 0;
            for (i = 0 ; i < n ; i++) {
                if (i % 2 == 0) {
                    x += (int) (a.charAt(i) - '0');
                    y += (int) (b.charAt(i) - '0');
                }
                else {
                    y += (int) (a.charAt(i) - '0');
                    x += (int) (b.charAt(i) - '0');
                }
            }

            if (x <= (n - n % 2) / 2 && y <= (n + n % 2) / 2) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
            
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
