package iniciante.P1046;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by elvis on 12/11/16.
 */
public class Main {
	public static void main(String[] args) throws IOException {

//		long times = System.currentTimeMillis();

		final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final StringTokenizer tokenizer = new StringTokenizer(r.readLine());
		int start = Integer.parseInt(tokenizer.nextToken()), end = Integer.parseInt(tokenizer.nextToken()), result=0;

		result = end - start;
		if(result < 1){
			result = end + 24 - start;
		}

		out.write(String.format("O JOGO DUROU %d HORA(S)\n", result).getBytes());
		out.flush();

//		System.out.println(System.currentTimeMillis() - times);
	}
}
