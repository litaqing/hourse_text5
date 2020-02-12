package com.myssm.paul.pojo;

public class Houselist {
  private Integer id;

	@Override
	public String toString() {
		return "Houselist{" +
				"id=" + id +
				", houseid='" + houseid + '\'' +
				", address='" + address + '\'' +
				", area=" + area +
				", price=" + price +
				", status='" + status + '\'' +
				", x=" + x +
				", y=" + y +
				", content='" + content + '\'' +
				'}';
	}

	private String houseid;
  private String address;
  private double area;
  private double price;
  private String status;
  private double x;
  private double y;
  private String content;
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getHouseid() {
	return houseid;
}
public void setHouseid(String houseid) {
	this.houseid = houseid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
  
}
