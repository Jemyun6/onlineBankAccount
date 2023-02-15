package repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>();

	public List<Transaction> findAll() { 
		return transactions;
	}
	
	
	@SuppressWarnings("unchecked")
	// I really don't understand why is using "FileInputStream","ObjectInputStream" here
	public void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
				 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){
			this.transactions = (List<Transaction>) objectInputStream.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
