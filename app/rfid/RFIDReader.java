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
		System.out.println(invertBytes(rfidRead));
		return redirect(rfid.routes.RFIDReader.index());
	}

	public static Long invertBytes(Long rfidIn) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
		byteBuffer.putLong(rfidIn);

		byte test = (byte) (((byte) (128)) >> 3);
		System.out.print("current: " + Integer.toBinaryString(
			test & 255 | 256).substring(1));


		// Try with: 004939781, or, 0004937373
		final byte nil = 0;
		final byte one = 1;
		final byte[] currentByte = byteBuffer.array();
		byte[] finalByte = new byte[Long.BYTES];

		for (byte j = 0; j < Long.BYTES; ++j) {
			for (byte i = 0; i < 8; ++i) {
				final short oneCopy = (short) (one << i);
				final short anded = (short) (currentByte[j] & oneCopy);
				short newByte = (short) (anded >>> i);
				if (newByte == -1) {
					System.out.print("current: " + Integer.toBinaryString(
						currentByte[j] & 255 | 256).substring(1));
					System.out.print("anded: " + Integer.toBinaryString(
						anded & 255 | 256).substring(1));
					System.out.print("onecopy: " + Integer.toBinaryString(
						oneCopy & 255 | 256).substring(1));
					System.out.print("newbte: " + Integer.toBinaryString(
						newByte & 255 | 256).substring(1));
				}
				finalByte[j] = (byte) (finalByte[j] |
					(byte) (newByte << (7 - i)));
			}
			System.out.println();
		}

		for (byte i = 0; i < Long.BYTES; ++i)
			System.out.println(Integer.toBinaryString(
				currentByte[i] & 255 | 256).substring(1));
		System.out.println();
		for (byte i = 0; i < Long.BYTES; ++i)
			System.out.println(Integer.toBinaryString(
				finalByte[i] & 255 | 256).substring(1));

		byteBuffer = ByteBuffer.wrap(finalByte);
		return byteBuffer.getLong();
	}

}
