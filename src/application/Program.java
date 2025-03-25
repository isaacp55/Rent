package application;

<<<<<<< HEAD
import java.text.ParseException;
import java.time.LocalDateTime;
=======
import java.time.LocalDate;
>>>>>>> 659df38809444a8a972985bbb48a5d5a6b016df6
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

<<<<<<< HEAD
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args)  throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel: ");
		System.out.println("Modelo do carro: ");
		String carModel = scn.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(scn.nextLine(), fmt);
		System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(scn.nextLine(), fmt);
	    CarRental cr = new CarRental(start, finish, new Vehicle(carModel)); 
	    
	    System.out.println("Entre com o preço por hora:");
	    double pricePerHour = scn.nextDouble();
	    System.out.println("Entre com o preço por dia:");
	    double pricePerDay = scn.nextDouble();
	    
	    RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(cr);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento básico: " + cr.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + cr.getInvoice().getTax());
		System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());
		
		scn.close();
=======
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número:");
		int number = scn.nextInt();
		System.out.print("Data (dd/MM/yyyy):");
		LocalDate date = LocalDate.parse(scn.next(), fmt);
		System.out.print("Valor do contrato:");
		double totalValue = scn.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas:");
		int n = scn.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas:");
		for(Installment installment : obj.getInstalments()) {
			System.out.println(installment);
		}
		
>>>>>>> 659df38809444a8a972985bbb48a5d5a6b016df6
	}
}
