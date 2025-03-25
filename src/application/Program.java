package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

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
		
	}
}
