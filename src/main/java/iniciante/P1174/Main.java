package iniciante.P1174;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double x;

		for(int i=0; i < 100; i++){
			x = Double.parseDouble(in.readLine());
			if(x <= 10){
				out.write(String.format("A[%d] = %.1f\n", i, x).getBytes());
			}
		}
		out.flush();

	}
}
