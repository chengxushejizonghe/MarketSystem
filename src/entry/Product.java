package entry;

import java.util.Date;

public class Product {
	/**
	 * 编号
	 */
	int id;
	/**
	 * 商品名称
	 */
	String productName;
	/**
	 * 商品价格
	 */
	double price;
	/**
	 * 商品类型
	 */
	String type;
	/**
	 * 生产日期
	 */
	Date productionDate;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
}
