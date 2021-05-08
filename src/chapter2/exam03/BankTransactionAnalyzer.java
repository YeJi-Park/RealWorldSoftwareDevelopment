package chapter2.exam03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzer {
	private static final String RESOURCES = "resources/";

	public static void main(String[] args) throws IOException {
		final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
		
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES + fileName); // 파일 시스템의 경로
		final List<String> lines = Files.readAllLines(path); // 행 목록 반환
		
		final List<BankTransaction> bankTransactions 
			= bankStatementCSVParser.parseLinesFromCSV(lines);
		
		System.out.println("Total amount: "+calculateTotalAmount(bankTransactions));
		System.out.println("Transactions of January: "+selectInMonth(bankTransactions, Month.JANUARY));
	}
	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d; 
		for(final BankTransaction bankTransaction: bankTransactions) {
			 total += bankTransaction.getAmount();
		}
		return total;
	}
	
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
			final Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		
		return bankTransactionsInMonth;
	}

}
