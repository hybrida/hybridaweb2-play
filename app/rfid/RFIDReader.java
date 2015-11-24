package rfid;

import java.nio.ByteBuffer;

import play.mvc.Controller;
import play.mvc.Result;

import rfid.views.html.*;
import models.HttpRequestData;

public class RFIDReader extends Controller {

	public static Result index() {
		return ok(reader.render());
	}

	public static Result read() {
		HttpRequestData htpdata = new HttpRequestData();
		System.out.println(
			htpdata.get("rfid"));
		Long rfidRead = htpdata.getLong("rfid");
		System.out.println(reverseBitsInBytes(rfidRead));
		return redirect(rfid.routes.RFIDReader.index());
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
