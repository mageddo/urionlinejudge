package iniciante.P1165;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by elvis on 13/11/16.
 */
public class MainTest {

	@Test
	public void main1() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1165/1.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("8 nao eh primo\n51 nao eh primo\n7 eh primo\n", new String(out.toByteArray()));

	}

	@Test
	public void main2() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1165/4.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("49 nao eh primo\n", new String(out.toByteArray()));

	}


	private Main getInstance() {
		return new Main();
	}

}