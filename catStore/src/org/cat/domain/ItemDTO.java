package org.cat.domain;

import java.sql.Date;

public class ItemDTO {
	private Integer ino;
	private String iname;
	private String iimg;
	private int price;
	private Date mregDate;
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(Integer ino, String iname, String iimg, int price, Date mregDate) {
		super();
		this.ino = ino;
		this.iname = iname;
		this.iimg = iimg;
		this.price = price;
		this.mregDate = mregDate;
	}
	public Integer getIno() {
		return ino;
	}
	public void setIno(Integer ino) {
		this.ino = ino;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	
	public String getIimg() {
		return iimg;
	}
	public void setIimg(String iimg) {
		this.iimg = iimg;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getMregDate() {
		return mregDate;
	}
	public void setMregDate(Date mregDate) {
		this.mregDate = mregDate;
	}
	@Override
	public String toString() {
		return "ItemDTO [ino=" + ino + ", iname=" + iname + ", price=" + price + ", mregDate=" + mregDate + "]";
	}
	
	
}
