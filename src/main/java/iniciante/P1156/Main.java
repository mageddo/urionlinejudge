package iniciante.P1156;

import java.io.IOException;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		int i=3, x=1;
		double s=1;

		for(; i <= 39; i+=2){
			s += i / (double)(x *= 2);
		}
		System.out.write(String.format("%.2f\n", s).getBytes());
	}

}
