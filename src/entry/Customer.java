package entry;

import java.util.Date;

public class Customer {
	/**用户名*/
	private String username;
	/**用户编号*/
	private int id;
	/**用户余额*/
	private double balance;
	/**用户密码*/
	private String password;
	/**真实姓名*/
	private String realName;
	/**注册时间*/
	private Date creationTime;
	/**联系电话*/
	private String contactPhone;
	/**邮箱*/
	private String email;
	/**
	 * 会员等级：0,1,2,3
	 * 会员等级为0为普通用户，创建新用户时默认为0级
	 */
	private int level;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"username='" + username + '\'' +
				", id=" + id +
				", balance=" + balance +
				", password='" + password + '\'' +
				", realName='" + realName + '\'' +
				", creationTime=" + creationTime +
				", contactPhone='" + contactPhone + '\'' +
				", email='" + email + '\'' +
				", level=" + level +
				'}';
	}
}
