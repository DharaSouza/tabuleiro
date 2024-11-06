package ArenaDosHerois;

public class Tabuleiro {
	
	private Personagens[] personagem;
	private int tamanho;
	
	public Tabuleiro(Personagens[] personagem, int tamanho) {
		this.personagem = personagem;
		this.tamanho = tamanho;
	}
	public void IniciarJogo() {
		System.out.println("Iniciando o jogo");
		for(int i = 0; i< personagem.length; i++) {
			personagem[i].mover(i*2);
		}
		exibirTabuleiro();
			}
	public void exibirTabuleiro(){
		System.out.println("\nPosições no Tabuleiro:");
		for(Personagens p : personagem) {
			if(p.getVida()> 0) {
				System.out.println(p.getNome() + " Está na posição " + p.getPosicao() + " com " + p.getVida() + " de vida. ");
			}
		}
		System.out.println();
	}
	public void movimentarPersonagens(Personagens p,int novaPosicao) {
		if(novaPosicao < 0 || novaPosicao >= tamanho) {
		}else {
			p.mover(novaPosicao);
			exibirTabuleiro();
		}
	}
	public boolean checarVencedor() {
		int vivos = 0;
		Personagens vencedor = null;
		for (Personagens p : personagem) {
			if (p.getVida() > 0) {
				vivos++;
				vencedor = p;
			}
		}
		if (vivos == 1) {
			System.out.println("O vencedor é " + vencedor.getNome() + "!");
			return true;
		}
		return false;
	}

}
