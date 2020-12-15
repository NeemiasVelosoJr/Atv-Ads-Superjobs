package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Worker;

public class Program {

	public static void main(String[] args) throws ParseException, InterruptedException  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Worker> wkList = new ArrayList<Worker>();
		
		wkList.add(new Worker(1001, sdf.parse("08/12/2020"), "Bob Oliveira", "bob@gmail.com", "9999-9999", "Pintor"));
		wkList.add(new Worker(1002, sdf.parse("09/12/2020"), "João Silva", "joao@gmail.com", "8888-8888", "Pintor"));
		wkList.add(new Worker(1003, sdf.parse("10/12/2020"), "Maria Santos", "maria@gmail.com", "7777-7777", "Eletricista"));
		wkList.add(new Worker(1004, sdf.parse("10/12/2020"), "Magno Oliveira", "magno@gmail.com", "6666-6666", "Encanador"));
		wkList.add(new Worker(1005, sdf.parse("10/12/2020"), "Borges Silva", "borges@gmail.com", "5555-5555", "Diarista"));
		wkList.add(new Worker(1006, sdf.parse("11/12/2020"), "Roberta Flores", "roberta@gmail.com", "4444-4444", "Babá"));
		wkList.add(new Worker(1007, sdf.parse("11/12/2020"), "Margarida Leal", "margarida@gmail.com", "3333-3333", "Diarista"));
		wkList.add(new Worker(1008, sdf.parse("11/12/2020"), "Emma Souza", "emma@gmail.com", "2222-2222", "Pintor"));
		wkList.add(new Worker(1009, sdf.parse("12/12/2020"), "Marisa Moraes", "marisa@gmail.com", "1111-1111", "Babá"));
		
		int count = 1010; 
		boolean logOut = false;
		
		while (!logOut) {
			
			System.out.println("** SISTEMA SUPERJOBS! **\n");
			System.out.println("[1] - Cadastrar");
			System.out.println("[2] - Exibir");
			System.out.println("[3] - Consultar");
			System.out.println("[4] - Remover");
			System.out.println("[5] - Alterar");
			System.out.println("[6] - Sair");
			System.out.print("\nQual a opção desejada: ");
			int mainOpt = sc.nextInt();
			clear();
			
			switch(mainOpt) {
			
			case 1:
				int id = count;
				count ++;
				System.out.println("** CADASTRAR TRABALHADOR **\n");
				System.out.print("Digite o nome: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Digite o email: ");
				String email = sc.nextLine();
				System.out.print("Digite o n° do telefone: ");
				String phoneNumber = sc.nextLine();
				System.out.print("Digite a ocupação: ");
				String occupation = sc.nextLine();
				Worker worker = new Worker(id, new Date(), name, email, phoneNumber, occupation);
				wkList.add(worker);
				System.out.println();
				System.out.println(worker);
				Thread.sleep(4000);
				break;
			
			case 2:
				System.out.println("** EXIBIR TRABALHADORES **\n");
				for (Worker wk : wkList) {
					System.out.println(wk);
					Thread.sleep(1000);
				}
				Thread.sleep(2000);
				break;
			
			case 3:
				boolean logOut2 = false;
				
				while(!logOut2) {
					System.out.println("** CONSULTAR **\n");
					System.out.println("[1] - Id");
					System.out.println("[2] - Descrição de Serviço");
					System.out.println("[3] - Sair da Consulta");
					System.out.print("Digite a Opção: ");
					int opt = sc.nextInt();
					clear();
					
					switch(opt) {
					
					case 1:
						boolean findId = false;
						System.out.print("Digite o Id que deseja consultar: ");
						int idSearch = sc.nextInt();
						clear();
						for (Worker item : wkList) {
							if (item.getId().equals(idSearch)) {
									System.out.println(item);
									Thread.sleep(1500);
									findId = true;
								}
						}
						if (!findId) {
							System.out.println("Esse Id não Existe!\n");
							Thread.sleep(1500);
						}
						break;
						
						
						
					case 2:
						boolean find = false;
						System.out.print("Digite o serviço que deseja pesquisar: ");
						sc.nextLine();
						String sevSearch = sc.nextLine();
						clear();
						for (Worker item : wkList) {
							if (item.getOccupation().equals(sevSearch)) {
									System.out.println(item);
									Thread.sleep(1000);
									find = true;
								}
						}
						if (!find) {
							System.out.println("Serviço não ofertado\n");
							Thread.sleep(1500);
						}
						break;
						
					case 3:
						System.out.println("Voltando para o menu principal\n");
						Thread.sleep(1500);
						logOut2 = true;
						break;
						
					default:
						System.out.println("OPÇÃO INVÁLIDA!\n");
						Thread.sleep(1500);
						break;
						
					}
				}
				break;
			
			case 4:
				System.out.println("** REMOVER TRABALHADOR **\n");
				System.out.print("Digite o Id do trabalhador que deseja remover: ");
				int idRemove = sc.nextInt();
				clear();
				Worker wk = wkList.stream().filter(x -> x.getId() == idRemove).findFirst().orElse(null);
				if (wk == null) {
					System.out.println("Id não encontrado!\n");
					Thread.sleep(1500);
				}
				else {
					System.out.println(wk);
					System.out.print("Certeza que quer excluir esse trabalhador [y/n]: ");
					char choice = sc.next().charAt(0);
					clear();
					if (choice == 'y') {
						wkList.remove(wk);
						System.out.println("Excluído com sucesso!\n");
						Thread.sleep(1500);
					}
					else {
						break;
					}
				}
				
				break;
				
			case 5: 
				System.out.println("** ALTERAR DADOS **\n");
				System.out.print("Digite o Id do Trabalhador que deseja alterar: ");
				int idSet = sc.nextInt();
				clear();
				Worker wk2 = wkList.stream().filter(x -> x.getId() == idSet).findFirst().orElse(null);
				if (wk2 == null) {
					System.out.println("Id não encontrado!\n");
					Thread.sleep(1000);
				}
				else {
					boolean logOut3 = false;
					Thread.sleep(1000);
					System.out.println(wk2);
					Thread.sleep(1000);
					while(!logOut3) {
						System.out.println("Qual Campo Deseja Alterar:");
						System.out.println("[1] - Nome");
						System.out.println("[2] - Email");
						System.out.println("[3] - Telefone");
						System.out.println("[4] - Ocupação");
						System.out.println("[5] - Retornar ao Menu Principal");
						System.out.print("Digite a Opção: ");
						int opt2 = sc.nextInt();
						clear();
						
						switch(opt2) {
						
						case 1:
							System.out.print("Digite o novo nome: ");
							sc.nextLine();
							String newName = sc.nextLine();
							wk2.setName(newName);
							clear();
							Thread.sleep(1000);
							System.out.println(wk2);
							Thread.sleep(1000);
							break;
							
						case 2:
							System.out.print("Digite o novo email: ");
							sc.nextLine();
							String newEmail = sc.nextLine();
							wk2.setEmail(newEmail);
							clear();
							Thread.sleep(1000);
							System.out.println(wk2);
							Thread.sleep(1000);
							break;
							
						case 3:
							System.out.print("Digite o novo Telefone: ");
							sc.nextLine();
							String newPhone = sc.nextLine();
							wk2.setPhoneNumber(newPhone);
							clear();
							Thread.sleep(1000);
							System.out.println(wk2);
							Thread.sleep(1000);
							break;
							
						case 4:
							System.out.print("Digite a nova Ocupação: ");
							sc.nextLine();
							String newOccupation = sc.nextLine();
							wk2.setOccupation(newOccupation);;
							clear();
							Thread.sleep(1000);
							System.out.println(wk2);
							Thread.sleep(1000);
							break;
							
						case 5:
							System.out.println("Retornando ao Menu Inicial!\n");
							Thread.sleep(1000);
							logOut3 = true;
							break;
						
						default:
							System.out.println("OPÇÃO INVÁLIDA!\n");
							Thread.sleep(1000);
							break;
							
						}
					}
						
				}
				break;
			
			case 6:
				System.out.println("OBRIGADO, ESTAMOS ENCERRANDO!");
				Thread.sleep(1000);
				logOut = true;
				break;
				
			default:
				System.out.println("OPÇÃO INVÁLIDA!\n");
				Thread.sleep(1000);
				break;
				
			}
			
		}
		
		sc.close();
	
	}
	public static void clear() {
		for (int i=0; i<1; i++) {
			System.out.println();
		}
	}

}

