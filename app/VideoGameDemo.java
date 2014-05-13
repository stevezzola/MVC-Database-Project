package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.Game;
import model.Purchase;
import view.VideoGameView;

public class VideoGameDemo {
	
	public static Statement stmt;
	public static final String OS = System.getProperty("os.name");

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/VideoGameDatabase";
			String username = "root";
			String password = "qwerty";
			
			Connection conn = DriverManager.getConnection(url, username, password); //Connect to the Database
			System.out.println("Connected!");
			stmt = conn.createStatement();
			
			Customer.createTable(); //Create the Tables if not exist
			Game.createTable();
			Purchase.createTable();
			new VideoGameView();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/* SQL TEST CODE
INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) 
VALUES ('Steven Mazzola', '12345678','Male', 19, '1994-08-07', 'Expert');
INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) 
VALUES ('Bob Smith', '12341234','Male', 24, '1989-05-14', 'Hardcore');
INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) 
VALUES ('Mary Jane', '11223344','Female', 15, '1999-10-12', 'Casual');
INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) 
VALUES ('Sally Brown', '12344321','Female', 32, '1981-01-21', 'Expert');
INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) 
VALUES ('John Doe', '11221122','Male', 47, '1966-12-30', 'Beginner');

INSERT INTO Game (title, id, company, console, price) 
VALUES ('Super Mario', '12-12-3434','Nintendo', 'Wii U', '$49.99');
INSERT INTO Game (title, id, company, console, price) 
VALUES ('Halo', '10-01-1000','Bungie', 'Xbox One', '$55.99');
INSERT INTO Game (title, id, company, console, price)
VALUES ('Call of Duty', '10-22-3344','Activision', 'Xbox One', '$59.99');
INSERT INTO Game (title, id, company, console, price) 
VALUES ('Call of Duty', '01-22-3344','Activision', 'PS4', '$59.99');
INSERT INTO Game (title, id, company, console, price) 
VALUES ('Portal 2', '01-10-1010','Valve', 'PC', '$29.99');

INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12345678', '12-12-3434','2014-02-17', 4.0);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12345678', '01-10-1010','2013-09-06', 4.5);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12345678', '10-22-3344','2013-11-15', 3.5);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12341234', '10-22-3344','2013-12-05', 4.0);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12341234', '10-01-1000','2014-02-01', 4.5);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('11223344', '01-10-1010','2014-04-23', 5.0);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12344321', '12-12-3434','2014-03-14', 2.0);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12344321', '01-22-3344','2014-03-14', 3.5);
INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) 
VALUES ('12344321', '10-22-3344','2013-07-27', 4.0);
 */

