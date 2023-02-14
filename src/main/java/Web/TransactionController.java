package Web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import domain.Transaction;
import service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService txnService;

	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		
		List<Transaction> transactions = txnService.findAll();
		
		model.put("transactions", transactions);
		
		return "transactions";
	}
	
	@GetMapping("/transactions/{txnId}")
	public String GetTransaction(ModelMap model,@PathVariable Long txnId) {
		
		Transaction txn = txnService.findById(txnId);
		model.put("transaction", txn);
		
		return "transaction";
	}

}
