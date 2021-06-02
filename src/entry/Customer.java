package entry;

import java.util.Date;

public class Customer {
	/**用户名*/
	String username;
	/**用户编号*/
	String id;
	/**用户余额*/
	int balance;
	/**用户密码*/
	String password;
	/**真实姓名*/
	String realName;
	/**注册时间*/
	Date creationTime;
	/**联系电话*/
	String phone;
	/**
	 * 会员等级：0,1,2,3
	 * 会员等级为0为普通用户，创建新用户时默认为0级
	 */
	int level;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
