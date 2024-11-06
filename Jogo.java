package ArenaDosHerois;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Personagens mago = new Mago("Mago");
		Personagens gigante= new Gigante("Gigante");
		Personagens guerreiro = new Guerreiro("Guerreiro");
		Personagens arqueiro = new Arqueiro("Arqueiro");
		
		Personagens[] personagem = {mago, gigante,guerreiro,arqueiro};
		Tabuleiro tabuleiro = new Tabuleiro(personagem, 10);
		
		tabuleiro.IniciarJogo();
		
		while(!tabuleiro.checarVencedor()) {
			for(Personagens p : personagem) {
				if (p.getVida() > 0) {
					System.out.println(p.getNome() + "(1)Atacar ou (2)Mover?");
					int escolha = scanner.nextInt();
					
					if (escolha == 1) {
						System.out.println("Escolha um oponente para atacar:");
						for (int i = 0; i < personagem.length; i++) {
							if(personagem[i] != p && personagem[i].getVida() > 0);
							System.out.println(i + ": " + personagem[i].getNome());
						}
					}
					int oponenteEscolhido;
					while(true) {
						oponenteEscolhido = scanner.nextInt();
						if(oponenteEscolhido >= 0 &&oponenteEscolhido < personagem.length && personagem[oponenteEscolhido] != p && personagem [oponenteEscolhido].getVida()> 0) {
							break;
						}else {
							System.out.println("Escolha inválida, tente novamente.");
						}
					}
					p.atacar(personagem [oponenteEscolhido]);
				}else {
					System.out.println("Escolha uma nova posição (0 a9): ");
					int novaPosicao = scanner.nextInt();
					tabuleiro.movimentarPersonagens(p, novaPosicao);
				}
			}
		}
	}
}
