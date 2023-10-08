package com.ds.algorithms.datastructure;

public enum EnumSinlgeTon {

	INSTANCE("Enum SingleTon");
	
	private String singleTon;
	
	private EnumSinlgeTon(String value) {
		this.singleTon = value;
	}
	
	public EnumSinlgeTon getInstance() {
		return INSTANCE;
	}

	public String getSingleTon() {
		return singleTon;
	}

	public void setSingleTon(String singleTon) {
		this.singleTon = singleTon;
	}
	
	public static void main (String args[]) {
		EnumSinlgeTon single = EnumSinlgeTon.INSTANCE.getInstance();
		System.out.println("Enum singleTon value   "+ single.getSingleTon());
		
		EnumSinlgeTon single2 = EnumSinlgeTon.INSTANCE.getInstance();
		System.out.println("Enum singleTon2 value before setting   "+ single2.getSingleTon());
		single2.setSingleTon("Enum singleTon2");
		System.out.println("Enum singleTon2 value   "+ single2.getSingleTon());
		System.out.println("Enum singleTon value   "+ single.getSingleTon());
		
	}
}
