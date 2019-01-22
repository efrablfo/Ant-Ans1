/**
 * This class file was automatically generated by jASN1 v1.9.0 (http://www.openmuc.org)
 */

package airoutputcdr;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class TreeDefinedFieldType implements Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	private BerBoolean boolean_ = null;
	private Integer64 integer64 = null;
	private BerUTF8String string = null;
	
	public TreeDefinedFieldType() {
	}

	public TreeDefinedFieldType(byte[] code) {
		this.code = code;
	}

	public void setBoolean(BerBoolean boolean_) {
		this.boolean_ = boolean_;
	}

	public BerBoolean getBoolean() {
		return boolean_;
	}

	public void setInteger64(Integer64 integer64) {
		this.integer64 = integer64;
	}

	public Integer64 getInteger64() {
		return integer64;
	}

	public void setString(BerUTF8String string) {
		this.string = string;
	}

	public BerUTF8String getString() {
		return string;
	}

	public int encode(OutputStream os) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (string != null) {
			codeLength += string.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
			return codeLength;
		}
		
		if (integer64 != null) {
			codeLength += integer64.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			return codeLength;
		}
		
		if (boolean_ != null) {
			codeLength += boolean_.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			boolean_ = new BerBoolean();
			codeLength += boolean_.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			integer64 = new Integer64();
			codeLength += integer64.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			string = new BerUTF8String();
			codeLength += string.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream os = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(os);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (boolean_ != null) {
			sb.append("boolean_: ").append(boolean_);
			return;
		}

		if (integer64 != null) {
			sb.append("integer64: ").append(integer64);
			return;
		}

		if (string != null) {
			sb.append("string: ").append(string);
			return;
		}

		sb.append("<none>");
	}

}

