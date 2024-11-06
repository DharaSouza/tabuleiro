package ArenaDosHerois;

public class Mago extends Personagens{

	private int mana;

	public Mago(String nome) {
		super(nome, 100, 25);
		this.mana = 50;
	}

	public void atacar (Personagens oponente) {
		if (mana>= 10) {
			oponente.receberDano(this.getDanoBase()+ 15);
			mana -= 10;
			System.out.println(getNome() + "Lançou o feitiço em " + oponente.getNome() + "à distância.");
		}else {
			System.out.println(getNome() + " Não tem mana suficiente para atacar!");
		}
	}


}


