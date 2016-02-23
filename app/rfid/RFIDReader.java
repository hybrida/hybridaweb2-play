package rfid;

import java.nio.ByteBuffer;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;

import rfid.views.html.*;
import views.html.*;
import models.HttpRequestData;
import renders.models.Renders;

public class RFIDReader extends Controller {

	private static HttpRequestData htpdata =
		new HttpRequestData();

	public static Result index() {
		List<Renders> bedpresses = getBedpresses();
		return renderFrontPage(bedpresses);
	}

	private static List<Renders> getBedpresses() {
		return Renders.find.setMaxRows(10).where(
			).eq("eventReference.bedpres", true).findList();
	}
	private static Result renderFrontPage(List<Renders> bedpresses) {
		return ok(layoutBoxPage.render(
				"RFID-Skanning", reader.render(
					bedpresses, -1L, 0, 0L)
				)
			);
	}

	public static Result indexContinue(String status, String number) {
		List<Renders> bedpresses =
			Renders.find.setMaxRows(10).where(
				).eq("eventReference.bedpres", true).findList();
		return ok(layoutBoxPage.render(
			"RFID-Skanning", reader.render(
				bedpresses, -1L, Integer.parseInt(status), Long.parseLong(number))));
	}

	public static Result read() {
		HttpRequestData htpdata = new HttpRequestData();
		System.out.println(
			htpdata.get("rfid"));
		Long rfidRead = htpdata.getLong("rfid");
		rfidRead = reverseBitsInBytes(rfidRead);
		return redirect(rfid.routes.RFIDReader.indexContinue(
			"2", rfidRead.toString()));
	}

	public static Long reverseBitsInBytes(Long rfidIn) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
		byteBuffer.putLong(rfidIn);

		final byte nil = 0;
		final byte one = 1;
		final byte[] currentByte = byteBuffer.array();
		byte[] finalByte = new byte[Long.BYTES];

		for (byte j = 0; j < Long.BYTES; ++j) {
			for (byte i = 0; i < 8; ++i) {
				final short oneCopy = (short) (one << i);
				final short anded = (short) (currentByte[j] & oneCopy);
				short newByte = (short) (anded >>> i);
				finalByte[j] = (byte) (finalByte[j] |
					(byte) (newByte << (7 - i)));
			}
		}

		byteBuffer = ByteBuffer.wrap(finalByte);
		return byteBuffer.getLong();
	}

}
