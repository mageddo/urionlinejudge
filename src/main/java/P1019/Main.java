package P1019;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		int n = new Scanner(System.in).nextInt();
		double h = (double) n / 60.0 / 60.0, m = (h - (int) h) * 60.0, s = (m - (int) m) * 60.0;
		System.out.printf("%d:%d:%d\n", (int)h, (int)m, Math.round(s));

	}
}
