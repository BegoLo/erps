/**
 * 
 */
package org.cuatrovientos.customers;

/**
 * @author BegoLo
 *
 */
public class Customer {
	private int id;
	private String name;
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @return id of the customer
	 */
	public int getId() {
		return id;
	}
	/**
	 * set the customer id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return customer name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set customer name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
