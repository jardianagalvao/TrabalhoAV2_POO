package q2_JardianaGalvao;

import java.io.*;
import java.util.Scanner;

public class Login {
	private static final String ARQUIVO_DE_USUARIOS = "D:\\Temp\\ws-eclipse\\AV2_JardianaGalvao\\src\\q2_JardianaGalvao\\usuarios.txt";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem-vindo ao programa de login!");

		while (true) {
			System.out.println("\nEscolha uma opcao:");
			System.out.println("1 - Cadastrar um novo usuario");
			System.out.println("2 - Fazer login");
			System.out.println("3 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				fazerLogin();
				break;
			case 3:
				System.out.println("Obrigado por usar o programa!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opcao invalida. Tente novamente.");
			}
		}
	}

	private static void cadastrarUsuario() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_DE_USUARIOS, true))) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Digite o nome de usuario: ");
			String novoUsuario = scanner.nextLine();
			System.out.print("Digite a senha: ");
			String novaSenha = scanner.nextLine();

			// Escreve o novo usuário no arquivo
			writer.println(novoUsuario + ":" + novaSenha);
			System.out.println("Usuario cadastrado com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao cadastrar usuario: " + e.getMessage());
		}
	}

	private static void fazerLogin() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome de usuario: ");
		String usuario = scanner.nextLine();
		System.out.print("Digite a senha: ");
		String senha = scanner.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DE_USUARIOS))) {
			String linha;
			boolean loginBemSucedido = false;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(":");
				if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(senha)) {
					loginBemSucedido = true;
					break;
				}
			}

			if (loginBemSucedido) {
				System.out.println("SUCESSO! Login bem-sucedido.");
			} else {
				System.out.println("FRACASSO! Usuario ou senha incorretos. Tente novamente");
			}
		} catch (IOException e) {
			System.err.println("Erro ao fazer login: " + e.getMessage());
		}
	}
}