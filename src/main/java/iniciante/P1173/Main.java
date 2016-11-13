package iniciante.P1173;

import java.io.*;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int initial = Integer.parseInt(in.readLine());

		for(int i=0; i < 10; i++){
			out.write('N');
			out.write('[');
			out.write(Integer.toString(i).getBytes());
			out.write(']');
			out.write(' ');
			out.write('=');
			out.write(' ');
			out.write(Integer.toString(initial).getBytes());
			out.write('\n');
			initial *= 2;
		}


		out.flush();

	}
}
