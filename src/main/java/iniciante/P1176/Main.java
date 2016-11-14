package iniciante.P1176;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String args[]) throws IOException {
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i=0, j, v, count = Integer.parseInt(in.readLine()), f, last, tmp;

		for(; i < count; i++){
			v = Integer.parseInt(in.readLine());
			f = 0;
			last = 1;
			for(j=1; j <= v; j++){
				tmp = f;
				f += last;
				last = tmp;
			}
			out.write(String.format("Fib(%d) = %d\n", v, f).getBytes());
		}
		out.flush();
	}
}
