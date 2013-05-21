import java.util.List;


public class CustomerProcessor {
	public static void main(String[] args) {
		List<Customer> list = CustomerFactory.makeCustomerList("custlist.txt");
		
		for(Customer c : list){
			System.out.println(c);
		}
	}
}
