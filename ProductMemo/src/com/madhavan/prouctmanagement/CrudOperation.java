package com.madhavan.prouctmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperation {

	Connection connection;
	String url = "jdbc:mysql://localhost:3306/product_db";
	String user = "root";
	String pass = "";

	public CrudOperation() throws SQLException {
		connection = DriverManager.getConnection(url, user, pass);
	}

	// Create
	public String add(Product product) throws SQLException {

		String query = "insert into product values (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setInt(3, product.getPrice());

		int result = preparedStatement.executeUpdate();

		if (result == 1)
			return "Product Added";
		else
			return "Product not Added - Give vaild inputs to add";

	}

	// Read
	public Product view(int id) throws SQLException {

		String query = "select * from product where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Product product = new Product();
		while (resultSet.next()) {

			product.setId(resultSet.getInt(1));
			product.setName(resultSet.getString(2));
			product.setPrice(resultSet.getInt(3));

		}

		return product;
	}

	// update
	public String modify(int id, int price, String name) throws SQLException {

		int result;

		String qurey = "update product set name=? , price =? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(qurey);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, price);
		preparedStatement.setInt(3, id);
		result = preparedStatement.executeUpdate();

		if (result == 1)
			return "/n" + id + " had been updated";
		else
			return "/nUpdation Failed";

	}

	// delete
	public String remove(int id) throws SQLException {
		int result;

		String qurey = "delete from product where id =?";
		PreparedStatement preparedStatement = connection.prepareStatement(qurey);
		preparedStatement.setInt(1, id);
		result = preparedStatement.executeUpdate();
		System.out.println("almost resched");

		if (result == 1)
			return "" + id + " had been removed";
		else
			return "" + id + "is Not Found";

	}

}
