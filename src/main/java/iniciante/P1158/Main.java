package iniciante.P1158;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		int n, x, y;
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		for(; n > 0; n--){
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int sum=0;
			x = Integer.parseInt(tokenizer.nextToken());
			y = Integer.parseInt(tokenizer.nextToken());
			for(;y > 0; x++){
				if(x % 2 == 1){
					y--;
					sum += x;
				}
			}
			out.write(Integer.toString(sum).getBytes());
			out.write('\n');

		}
		out.flush();
	}
}
