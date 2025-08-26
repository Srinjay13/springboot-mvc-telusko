package com.telusko.SpringMVCBoot.model;

public class Coder {
	public int coderId;
	public String coderName;
	@Override
	public String toString() {
		return "Coder [coderId=" + coderId + ", coderName=" + coderName + "]";
	}
	public int getCoderId() {
		return coderId;
	}
	public Coder(int coderId, String coderName) {
		super();
		this.coderId = coderId;
		this.coderName = coderName;
	}
	public void setCoderId(int coderId) {
		this.coderId = coderId;
	}
	public String getCoderName() {
		return coderName;
	}
	public void setCoderName(String coderName) {
		this.coderName = coderName;
	}
	
}
