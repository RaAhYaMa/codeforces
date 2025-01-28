import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    private static InputReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);

        String s = in.next();

        int length = s.length();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        for (i=0 ; i < length - 3 ; i += 3) {
            if (!s.substring(i, i+3).equals("WUB")) {
                for (j=i ; j < length && !s.substring(j, Math.min(j+3, length)).equals("WUB") ; j++) {
                    result.append(s.charAt(j));
                }
                result.append(' ');
                i = j - 3;
            }
        }
        if (!s.substring(i, length).equals("WUB")) {
            result.append(s.substring(i, length));
            result.append(' ');
        }
        out.println(result.substring(0, result.length() - 1));

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