
public class Customer {
	int id;
	String name;
	String email;
	String mobile;

	public Customer(int id, String name, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer: id="+ id +" name=" + name + " email="+ email+ " mobile="+mobile;
	}	
}
