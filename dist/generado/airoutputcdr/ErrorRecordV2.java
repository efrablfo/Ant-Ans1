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


public class ErrorRecordV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private NodeType originNodeType = null;
	private IDString originHostName = null;
	private IDString originFileID = null;
	private TransactionID originTransactionID = null;
	private IDString originOperatorID = null;
	private TimeStamp originTimeStamp = null;
	private NodeID hostName = null;
	private LocalSequenceNumber localSequenceNumber = null;
	private TimeStamp timeStamp = null;
	private ServiceClass currentServiceClass = null;
	private OperationV2 operation = null;
	private TransactionType transactionType = null;
	private TransactionCode transactionCode = null;
	private VoucherString voucherSerialNumber = null;
	private NumberString accountNumber = null;
	private NumberString subscriberNumber = null;
	private BerInteger refillFraudCounter = null;
	private TimeStamp refillUnbarTimeStamp = null;
	private VoucherString activationCode = null;
	private ErrorCode errorCode = null;
	private MoneyAmount transactionAmount = null;
	private Currency transactionCurrency = null;
	private LocationNumber locationNumber = null;
	private RefillTypeV2 refillType = null;
	private BerBoolean voucherBasedRefill = null;
	private RegionType accountHomeRegion = null;
	private RegionType subscriberRegion = null;
	private RegionType voucherRegion = null;
	private RefillTypeV2 requestedRefillType = null;
	
	public ErrorRecordV2() {
	}

	public ErrorRecordV2(byte[] code) {
		this.code = code;
	}

	public void setOriginNodeType(NodeType originNodeType) {
		this.originNodeType = originNodeType;
	}

	public NodeType getOriginNodeType() {
		return originNodeType;
	}

	public void setOriginHostName(IDString originHostName) {
		this.originHostName = originHostName;
	}

	public IDString getOriginHostName() {
		return originHostName;
	}

	public void setOriginFileID(IDString originFileID) {
		this.originFileID = originFileID;
	}

	public IDString getOriginFileID() {
		return originFileID;
	}

	public void setOriginTransactionID(TransactionID originTransactionID) {
		this.originTransactionID = originTransactionID;
	}

	public TransactionID getOriginTransactionID() {
		return originTransactionID;
	}

	public void setOriginOperatorID(IDString originOperatorID) {
		this.originOperatorID = originOperatorID;
	}

	public IDString getOriginOperatorID() {
		return originOperatorID;
	}

	public void setOriginTimeStamp(TimeStamp originTimeStamp) {
		this.originTimeStamp = originTimeStamp;
	}

	public TimeStamp getOriginTimeStamp() {
		return originTimeStamp;
	}

	public void setHostName(NodeID hostName) {
		this.hostName = hostName;
	}

	public NodeID getHostName() {
		return hostName;
	}

	public void setLocalSequenceNumber(LocalSequenceNumber localSequenceNumber) {
		this.localSequenceNumber = localSequenceNumber;
	}

	public LocalSequenceNumber getLocalSequenceNumber() {
		return localSequenceNumber;
	}

	public void setTimeStamp(TimeStamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	public void setCurrentServiceClass(ServiceClass currentServiceClass) {
		this.currentServiceClass = currentServiceClass;
	}

	public ServiceClass getCurrentServiceClass() {
		return currentServiceClass;
	}

	public void setOperation(OperationV2 operation) {
		this.operation = operation;
	}

	public OperationV2 getOperation() {
		return operation;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionCode(TransactionCode transactionCode) {
		this.transactionCode = transactionCode;
	}

	public TransactionCode getTransactionCode() {
		return transactionCode;
	}

	public void setVoucherSerialNumber(VoucherString voucherSerialNumber) {
		this.voucherSerialNumber = voucherSerialNumber;
	}

	public VoucherString getVoucherSerialNumber() {
		return voucherSerialNumber;
	}

	public void setAccountNumber(NumberString accountNumber) {
		this.accountNumber = accountNumber;
	}

	public NumberString getAccountNumber() {
		return accountNumber;
	}

	public void setSubscriberNumber(NumberString subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}

	public NumberString getSubscriberNumber() {
		return subscriberNumber;
	}

	public void setRefillFraudCounter(BerInteger refillFraudCounter) {
		this.refillFraudCounter = refillFraudCounter;
	}

	public BerInteger getRefillFraudCounter() {
		return refillFraudCounter;
	}

	public void setRefillUnbarTimeStamp(TimeStamp refillUnbarTimeStamp) {
		this.refillUnbarTimeStamp = refillUnbarTimeStamp;
	}

	public TimeStamp getRefillUnbarTimeStamp() {
		return refillUnbarTimeStamp;
	}

	public void setActivationCode(VoucherString activationCode) {
		this.activationCode = activationCode;
	}

	public VoucherString getActivationCode() {
		return activationCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setTransactionAmount(MoneyAmount transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public MoneyAmount getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionCurrency(Currency transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public Currency getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setLocationNumber(LocationNumber locationNumber) {
		this.locationNumber = locationNumber;
	}

	public LocationNumber getLocationNumber() {
		return locationNumber;
	}

	public void setRefillType(RefillTypeV2 refillType) {
		this.refillType = refillType;
	}

	public RefillTypeV2 getRefillType() {
		return refillType;
	}

	public void setVoucherBasedRefill(BerBoolean voucherBasedRefill) {
		this.voucherBasedRefill = voucherBasedRefill;
	}

	public BerBoolean getVoucherBasedRefill() {
		return voucherBasedRefill;
	}

	public void setAccountHomeRegion(RegionType accountHomeRegion) {
		this.accountHomeRegion = accountHomeRegion;
	}

	public RegionType getAccountHomeRegion() {
		return accountHomeRegion;
	}

	public void setSubscriberRegion(RegionType subscriberRegion) {
		this.subscriberRegion = subscriberRegion;
	}

	public RegionType getSubscriberRegion() {
		return subscriberRegion;
	}

	public void setVoucherRegion(RegionType voucherRegion) {
		this.voucherRegion = voucherRegion;
	}

	public RegionType getVoucherRegion() {
		return voucherRegion;
	}

	public void setRequestedRefillType(RefillTypeV2 requestedRefillType) {
		this.requestedRefillType = requestedRefillType;
	}

	public RefillTypeV2 getRequestedRefillType() {
		return requestedRefillType;
	}

	public int encode(OutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(OutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (requestedRefillType != null) {
			codeLength += requestedRefillType.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 28
			os.write(0x9C);
			codeLength += 1;
		}
		
		if (voucherRegion != null) {
			codeLength += voucherRegion.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 27
			os.write(0x9B);
			codeLength += 1;
		}
		
		if (subscriberRegion != null) {
			codeLength += subscriberRegion.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 26
			os.write(0x9A);
			codeLength += 1;
		}
		
		if (accountHomeRegion != null) {
			codeLength += accountHomeRegion.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 25
			os.write(0x99);
			codeLength += 1;
		}
		
		if (voucherBasedRefill != null) {
			codeLength += voucherBasedRefill.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 24
			os.write(0x98);
			codeLength += 1;
		}
		
		if (refillType != null) {
			codeLength += refillType.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 23
			os.write(0x97);
			codeLength += 1;
		}
		
		if (locationNumber != null) {
			codeLength += locationNumber.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 22
			os.write(0x96);
			codeLength += 1;
		}
		
		if (transactionCurrency != null) {
			codeLength += transactionCurrency.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 21
			os.write(0x95);
			codeLength += 1;
		}
		
		if (transactionAmount != null) {
			codeLength += transactionAmount.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 20
			os.write(0x94);
			codeLength += 1;
		}
		
		codeLength += errorCode.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 19
		os.write(0x93);
		codeLength += 1;
		
		if (activationCode != null) {
			codeLength += activationCode.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 18
			os.write(0x92);
			codeLength += 1;
		}
		
		if (refillUnbarTimeStamp != null) {
			codeLength += refillUnbarTimeStamp.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 17
			os.write(0x91);
			codeLength += 1;
		}
		
		if (refillFraudCounter != null) {
			codeLength += refillFraudCounter.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 16
			os.write(0x90);
			codeLength += 1;
		}
		
		codeLength += subscriberNumber.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 15
		os.write(0x8F);
		codeLength += 1;
		
		if (accountNumber != null) {
			codeLength += accountNumber.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 14
			os.write(0x8E);
			codeLength += 1;
		}
		
		if (voucherSerialNumber != null) {
			codeLength += voucherSerialNumber.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 13
			os.write(0x8D);
			codeLength += 1;
		}
		
		if (transactionCode != null) {
			codeLength += transactionCode.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 12
			os.write(0x8C);
			codeLength += 1;
		}
		
		if (transactionType != null) {
			codeLength += transactionType.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 11
			os.write(0x8B);
			codeLength += 1;
		}
		
		codeLength += operation.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 10
		os.write(0x8A);
		codeLength += 1;
		
		if (currentServiceClass != null) {
			codeLength += currentServiceClass.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 9
			os.write(0x89);
			codeLength += 1;
		}
		
		codeLength += timeStamp.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 8
		os.write(0x88);
		codeLength += 1;
		
		codeLength += localSequenceNumber.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 7
		os.write(0x87);
		codeLength += 1;
		
		codeLength += hostName.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 6
		os.write(0x86);
		codeLength += 1;
		
		codeLength += originTimeStamp.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 5
		os.write(0x85);
		codeLength += 1;
		
		if (originOperatorID != null) {
			codeLength += originOperatorID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			os.write(0x84);
			codeLength += 1;
		}
		
		codeLength += originTransactionID.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 3
		os.write(0x83);
		codeLength += 1;
		
		if (originFileID != null) {
			codeLength += originFileID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
		}
		
		codeLength += originHostName.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		os.write(0x81);
		codeLength += 1;
		
		codeLength += originNodeType.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		os.write(0x80);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			originNodeType = new NodeType();
			subCodeLength += originNodeType.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			originHostName = new IDString();
			subCodeLength += originHostName.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			originFileID = new IDString();
			subCodeLength += originFileID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			originTransactionID = new TransactionID();
			subCodeLength += originTransactionID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			originOperatorID = new IDString();
			subCodeLength += originOperatorID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			originTimeStamp = new TimeStamp();
			subCodeLength += originTimeStamp.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
			hostName = new NodeID();
			subCodeLength += hostName.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
			localSequenceNumber = new LocalSequenceNumber();
			subCodeLength += localSequenceNumber.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
			timeStamp = new TimeStamp();
			subCodeLength += timeStamp.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9)) {
			currentServiceClass = new ServiceClass();
			subCodeLength += currentServiceClass.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 10)) {
			operation = new OperationV2();
			subCodeLength += operation.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 11)) {
			transactionType = new TransactionType();
			subCodeLength += transactionType.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 12)) {
			transactionCode = new TransactionCode();
			subCodeLength += transactionCode.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 13)) {
			voucherSerialNumber = new VoucherString();
			subCodeLength += voucherSerialNumber.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 14)) {
			accountNumber = new NumberString();
			subCodeLength += accountNumber.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 15)) {
			subscriberNumber = new NumberString();
			subCodeLength += subscriberNumber.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 16)) {
			refillFraudCounter = new BerInteger();
			subCodeLength += refillFraudCounter.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 17)) {
			refillUnbarTimeStamp = new TimeStamp();
			subCodeLength += refillUnbarTimeStamp.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 18)) {
			activationCode = new VoucherString();
			subCodeLength += activationCode.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 19)) {
			errorCode = new ErrorCode();
			subCodeLength += errorCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 20)) {
			transactionAmount = new MoneyAmount();
			subCodeLength += transactionAmount.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 21)) {
			transactionCurrency = new Currency();
			subCodeLength += transactionCurrency.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 22)) {
			locationNumber = new LocationNumber();
			subCodeLength += locationNumber.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 23)) {
			refillType = new RefillTypeV2();
			subCodeLength += refillType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 24)) {
			voucherBasedRefill = new BerBoolean();
			subCodeLength += voucherBasedRefill.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 25)) {
			accountHomeRegion = new RegionType();
			subCodeLength += accountHomeRegion.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 26)) {
			subscriberRegion = new RegionType();
			subCodeLength += subscriberRegion.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 27)) {
			voucherRegion = new RegionType();
			subCodeLength += voucherRegion.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 28)) {
			requestedRefillType = new RefillTypeV2();
			subCodeLength += requestedRefillType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream os = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (originNodeType != null) {
			sb.append("originNodeType: ").append(originNodeType);
		}
		else {
			sb.append("originNodeType: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (originHostName != null) {
			sb.append("originHostName: ").append(originHostName);
		}
		else {
			sb.append("originHostName: <empty-required-field>");
		}
		
		if (originFileID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("originFileID: ").append(originFileID);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (originTransactionID != null) {
			sb.append("originTransactionID: ").append(originTransactionID);
		}
		else {
			sb.append("originTransactionID: <empty-required-field>");
		}
		
		if (originOperatorID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("originOperatorID: ").append(originOperatorID);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (originTimeStamp != null) {
			sb.append("originTimeStamp: ").append(originTimeStamp);
		}
		else {
			sb.append("originTimeStamp: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (hostName != null) {
			sb.append("hostName: ").append(hostName);
		}
		else {
			sb.append("hostName: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (localSequenceNumber != null) {
			sb.append("localSequenceNumber: ").append(localSequenceNumber);
		}
		else {
			sb.append("localSequenceNumber: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (timeStamp != null) {
			sb.append("timeStamp: ").append(timeStamp);
		}
		else {
			sb.append("timeStamp: <empty-required-field>");
		}
		
		if (currentServiceClass != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("currentServiceClass: ").append(currentServiceClass);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (operation != null) {
			sb.append("operation: ").append(operation);
		}
		else {
			sb.append("operation: <empty-required-field>");
		}
		
		if (transactionType != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transactionType: ").append(transactionType);
		}
		
		if (transactionCode != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transactionCode: ").append(transactionCode);
		}
		
		if (voucherSerialNumber != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("voucherSerialNumber: ").append(voucherSerialNumber);
		}
		
		if (accountNumber != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("accountNumber: ").append(accountNumber);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subscriberNumber != null) {
			sb.append("subscriberNumber: ").append(subscriberNumber);
		}
		else {
			sb.append("subscriberNumber: <empty-required-field>");
		}
		
		if (refillFraudCounter != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("refillFraudCounter: ").append(refillFraudCounter);
		}
		
		if (refillUnbarTimeStamp != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("refillUnbarTimeStamp: ").append(refillUnbarTimeStamp);
		}
		
		if (activationCode != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("activationCode: ").append(activationCode);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (errorCode != null) {
			sb.append("errorCode: ").append(errorCode);
		}
		else {
			sb.append("errorCode: <empty-required-field>");
		}
		
		if (transactionAmount != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transactionAmount: ").append(transactionAmount);
		}
		
		if (transactionCurrency != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transactionCurrency: ").append(transactionCurrency);
		}
		
		if (locationNumber != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("locationNumber: ").append(locationNumber);
		}
		
		if (refillType != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("refillType: ").append(refillType);
		}
		
		if (voucherBasedRefill != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("voucherBasedRefill: ").append(voucherBasedRefill);
		}
		
		if (accountHomeRegion != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("accountHomeRegion: ").append(accountHomeRegion);
		}
		
		if (subscriberRegion != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("subscriberRegion: ").append(subscriberRegion);
		}
		
		if (voucherRegion != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("voucherRegion: ").append(voucherRegion);
		}
		
		if (requestedRefillType != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("requestedRefillType: ").append(requestedRefillType);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

