package chapter2.exam02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * CSV ������ �޾� �ŷ������� ������ ���<br>
 * �����̳� �����Ϳ� ������ �ִ� ����� ����ó�� �Ǿ����� ����
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
		final Path path = Paths.get(RESOURCES + args[0]); // ���� �ý����� ���
		final List<String> lines = Files.readAllLines(path); // �� ��� ��ȯ
		
		double total = 0d;
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		for(final String line: lines) {
			final String[] cols = line.split(","); // �޸��� �� �и�
			final LocalDate date = LocalDate.parse(cols[0], DATE_PATTERN);
			if(date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(cols[1]); // �ݾ� ���� �� �Ľ�
				total += amount;				
			}
			
		}
		
		System.out.println("Total amount of January: "+total);
	}

}
