package net.fajarachmad.common.constant;

public enum RecordStatus {
	ACTIVE(1),
	DELETED(2);
	
	private int value;
	
	private RecordStatus(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
