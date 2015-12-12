package net.fajarachmad.security.constant;

public enum UserSourceType {
	REGISTRATION(1);
	
	private int typeId;
	
	private UserSourceType(int typeId) {
		this.typeId = typeId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
