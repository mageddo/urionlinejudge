package iniciante.P1177;

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
		int i=0, j=0, n = Integer.parseInt(in.readLine());

		for(; i < 1000; i++){

			out.write(String.format("N[%d] = %d\n", i, j++).getBytes());
			if(n == j)
				j = 0;

		}
		out.flush();
	}
}
