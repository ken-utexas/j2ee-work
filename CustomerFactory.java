import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Exceptions.NewCustomerException;


public class CustomerFactory {
	static int i;
	
	static { //not actually needed, but useful for complex initiation
		i=0; //perhaps fetching the total # of customers from db when loading
	}
	
	public static boolean isLong(String s) {
	    try { 
	        Long.parseLong(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	static Customer makeCustomer(String name, String email, String mob) throws NewCustomerException{
		if( !isLong(mob) || Long.parseLong(mob) < 1000000000 || mob.length() != 10 ){
			throw new NewCustomerException("Bad mobile # format");
			//return null;
		}
		
		return new Customer(++i ,name.trim(), email.trim(), mob.trim());
	}
	
	static List<Customer> makeCustomerList(String filename){
		BufferedReader br;
		String line;
		String[] tokens;
		LinkedList<Customer> clist = new LinkedList<Customer>();
		
		try {
			br = new BufferedReader(new FileReader(filename));
			try {
				while ( (line=br.readLine()) != null){
					tokens = line.split(",");
					try {
						if(tokens.length !=3)
							throw new NewCustomerException ("Parse Line Bad format");
						//only if format ok
						clist.add(makeCustomer(tokens[0].trim(), tokens[1].trim(), tokens[2].trim()));
					} catch (NewCustomerException ne) {
						ne.printStackTrace();
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 			
		return clist;
	}
	
	
}
