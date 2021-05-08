package chapter2.exam01;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * CSV 파일을 받아 거래내역의 총합을 계산<br>
 * 파일이나 데이터에 문제가 있는 경우의 예외처리 되어있지 않음
 * @author yeji
 */
public class BankTransactionAnalyzerSimple {
	private static final String RESOURCES = "resources/";

	/**
	 * 
	 * @param args Path of CSV file
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final Path path = Paths.get(RESOURCES + args[0]); // 파일 시스템의 경로
		final List<String> lines = Files.readAllLines(path); // 행 목록 반환
		
		double total = 0d;
		for(final String line: lines) {
			final String[] cols = line.split(","); // 콤마로 열 분리
			final double amount = Double.parseDouble(cols[1]); // 금액 추출 후 파싱
			
			total += amount;
		}
		
		System.out.println("Total amount: "+total);
	}

}
