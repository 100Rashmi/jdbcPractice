package beans;

import java.sql.Date;

public class Customer {
	
		int customer_id;
		int store_id;
		String address;
		String email;
		String firstName;
		String lastName;
		Date createdate;
		public Customer(int c_id, int store_id, String address_id, String email, String firstName, String lastName,
				Date createdate) {
			super();
			this.customer_id = c_id;
			this.store_id = store_id;
			this.address = address_id;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.createdate = createdate;
		}
		public int getId() {
			return customer_id;
		}
		public void setId(int id) {
			this.customer_id = id;
		}
		public int getStore_id() {
			return store_id;
		}
		public void setStore_id(int store_id) {
			this.store_id = store_id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String addr) {
			this.address = addr;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getCreatedate() {
			return createdate;
		}
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
				
		
	}


