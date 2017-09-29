package org.cat.domain;

public class PreOrderDTO {
	private String ino;
	private int amount;
	
	public PreOrderDTO(String ino, int amount) {
		super();
		this.ino = ino;
		this.amount = amount;
	}

	public String getIno() {
		return ino;
	}

	public void setIno(String ino) {
		this.ino = ino;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PreOrderDTO [ino=" + ino + ", amount=" + amount + "]";
	}
	
	public int getInoInt() {
		return Integer.parseInt(ino);
	}

}
