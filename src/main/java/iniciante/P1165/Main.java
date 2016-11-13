package iniciante.P1165;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	private static final byte[] NOT_PRIME = " nao eh primo\n".getBytes();
	private static final byte[] PRIME = " eh primo\n".getBytes();

	public static void main(String[] args) throws IOException {

		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()), x, at, i;

		proximo:
		for(; n > 0; n--){

			x = Integer.parseInt(in.readLine());
			out.write(Integer.toString(x).getBytes());
			if(x < 2 || (x != 2 && x % 2 == 0)){
				out.write(NOT_PRIME);
				continue;
			}

			at = (int) Math.ceil(Math.sqrt(x));
			for(i=3; i <= at; i+= 2){
				if(x % i == 0){
					out.write(NOT_PRIME);
					continue proximo;
				}
			}
			out.write(PRIME);
		}
		out.flush();
	}
}
