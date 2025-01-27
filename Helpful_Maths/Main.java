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
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i=0 ; i < s.length() ; i += 2) {
            switch (s.charAt(i)) {
                case '1': one++; break;
                case '2': two++; break;
                case '3': three++; break;
            }
        }
        StringBuilder res = new StringBuilder();
        while (one > 0) {
            res.append('1');
            res.append('+');
            one--;
        }
        while (two > 0) {
            res.append('2');
            res.append('+');
            two--;
        }
        while (three > 0) {
            res.append('3');
            res.append('+');
            three--;
        }

        out.println(res.substring(0, res.length() - 1));

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