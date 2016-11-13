package iniciante.P1046;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by elvis on 13/11/16.
 */
public class MainTest {

	@Test
	public void main1() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(IOUtils.toInputStream("16 2\n"));
		System.setOut(new PrintStream(out));
		new Main().main(new String[]{});
		Assert.assertEquals("O JOGO DUROU 10 HORA(S)\n", new String(out.toByteArray()));

	}

	@Test
	public void main2() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(IOUtils.toInputStream("0 0\n"));
		System.setOut(new PrintStream(out));
		new Main().main(new String[]{});
		Assert.assertEquals("O JOGO DUROU 24 HORA(S)\n", new String(out.toByteArray()));

	}
	@Test
	public void main3() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(IOUtils.toInputStream("2 16\n"));
		System.setOut(new PrintStream(out));
		new Main().main(new String[]{});
		Assert.assertEquals("O JOGO DUROU 14 HORA(S)\n", new String(out.toByteArray()));

	}
}