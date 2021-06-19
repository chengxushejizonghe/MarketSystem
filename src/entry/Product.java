package entry;

import java.util.Date;

public class Product {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品价格
	 */
	private double price;
	/**
	 * 商品类型
	 */
	private String type;
	/**
	 * 生产日期
	 */
	private Date productionDate;
	/**
	 * 商品数量
	 */
	private int quantity;
	/**
	 * 商品销量
	 */
	private int salesVolume;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", productName='" + productName + '\'' +
				", price=" + price +
				", type='" + type + '\'' +
				", productionDate=" + productionDate +
				", quantity=" + quantity +
				", salesVolume=" + salesVolume +
				'}';
	}
}
