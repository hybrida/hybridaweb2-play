package rfid;

import java.nio.ByteBuffer;
import java.util.List;
import play.mvc.Controller;
import play.mvc.Result;

import models.HttpRequestData;
import renders.models.Renders;
import rfid.views.html.*;
import views.html.*;

public class RFIDReader extends Controller {

	public static Result index() {
		List<Renders> bedpresses = getBedpresses();
		return renderFrontPage(bedpresses);
	}

	public static Result indexContinue(String status, String number, String eventId) {
		List<Renders> bedpresses = getBedpresses();
		return renderOk(bedpresses, status, number, eventId);
	}

	public static Result read() {
		HttpRequestData htpdata = new HttpRequestData();
		Long rfidRead = htpdata.getLong("rfid");
		Long eventId = htpdata.getLong("eventId");
		rfidRead = reverseBitsInBytes(rfidRead);
		return redirect(rfid.routes.RFIDReader.indexContinue(
			"2", rfidRead.toString(), eventId.toString()));
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

	private static List<Renders> getBedpresses() {
		return Renders.find.setMaxRows(10).where(
			).eq("eventReference.bedpres", true).findList();
	}

	private static Result renderOk(List<Renders> bedpresses, String status, String number, String eventId) {
		return ok(layoutBoxPage.render(
			"RFID-Skanning", reader.render(
				bedpresses, Long.parseLong(eventId), Integer.parseInt(status), Long.parseLong(number))));
	}

	private static Result renderFrontPage(List<Renders> bedpresses) {
		return ok(layoutBoxPage.render(
				"RFID-Skanning", reader.render(
					bedpresses, -1L, 0, 0L)));
	}

}
