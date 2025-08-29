package com.telusko.SpringMVCBoot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coder")
public class Coder {
	@Id
	@Column(name = "coderid")
	public int coderId;
	@Column(name = "codername")
	public String coderName;
	
	public Coder() {
	}
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
