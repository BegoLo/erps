/**
 * 
 */
package org.cuatrovientos.customers;

import java.sql.*;



/**
 * @author BegoLo
 *
 */
public class Bd {
	/**
	 * 
	 */
	private Connection connection=null;
	private Statement statement=null ;
	
	public Bd() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		this.connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		this.statement = connection.createStatement();
		String sql ="";
		sql="drop table if exists customer";
		statement.executeUpdate(sql);
		sql = "create table customer (id integer, name varchar(40))";
		statement.executeUpdate(sql);
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void closeBD() throws SQLException{
		connection.close();
	}
	
	public void addCostumer(Customer customer) throws SQLException{
		if (customer.getName().length()<=40){
			String insertSql = "insert into customer values("+customer.getId()+", '"+customer.getName()+"')";
			
			statement.executeUpdate(insertSql);
		}
	}
	
	public void modifyCostumer(int id, String name) throws SQLException{
		String updateSql = "update customer set name='"+name+"' where id="+id+"";
		statement.executeUpdate(updateSql);
	}
	
	public void showAll() throws SQLException{
		String select = "select * from customer";
		ResultSet resultSet = statement.executeQuery(select);
		while (resultSet.next()) {
			System.out.print("ID: " + resultSet.getInt(1));
			System.out.println(" Name: " + resultSet.getString("name"));
		}
	}
	
	public void deleteCustomer(int id) throws SQLException{
		String deleteSql = "delete from customer where id="+id+"";
		statement.executeUpdate(deleteSql);
	}
	public void deleteAll() throws SQLException{
		String deleteSql = "delete from customer";
		statement.executeUpdate(deleteSql);
	}
}
