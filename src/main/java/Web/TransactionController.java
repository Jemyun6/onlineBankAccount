package Web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService txnService;

	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		List<Transaction> transactions = transactions.findAll();
		model.put("transactions", transactions);
		return "transactions";
	}

}
