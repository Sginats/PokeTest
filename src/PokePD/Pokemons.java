package PokePD;
/*/
Izstrādāt objektorientetas programmas risinājumu par temu „Pokemoni”. Prasībās ir noteikts, ka programma satur vismaz četras klases (nepieciešamības gadījumā, veidot papildus klases) Pokemons, ElektriskaisP, UdensP un Pokedatnis.
Klase Pokedatnis satur programmas main daļu, no tās veic jaunu Pokemonu izveidi, atributu aplūkošanu, metožu izsaukšanu, cīņas uzsākšanu, tiek nodrošinātas darbības ar jebkura tipa Pokemona objektiem.
Pokemons ir abstrakta bāzes klase, savukārt klases ElektriskaisP un UdensP ir apakšklases, kuras interprete jebkuram Pokemonam raksturīgās metodes.
Programmai ir jāatbilst sekojošäm prasïbäm:
»	klasēs ieviesti vismaz 4 atribūti un 4 metodes (vismaz víena no bāzes klases metodēm ír abstrakta)
•	Pokemons ir abstrakta klase un strādājot ar apakškalsem, tiek ieveroti polimorfisma pamatprincipi
•	tiek nodrošināta funkcionalitāte jauna Pokemona țElektriskaisP, UdensP) izveidei un uzglabāšanai
•		tiek nodrošināta iespēja izsaukt metodes izveletajam pokemona objektam (uzbrukt, izvairīties, dziedēt, attístīt, utml.)
»	ieviesta funkcionalitāte pokemonu turnīra rïkošanai, nodrošinot iespēju tiem savā starpā sacensties
•	maksimäli noversta nekorektu datu ievade un iespejamie kļudu gadījumi.
Kā papildus pluss tiks uzskatīta lietotāja grafiskä interfeisa izveide íformas, pogas, skanas u.tml).

 */
public abstract class Pokemons {
	protected String name;
	protected int health;
	protected int attackPower;
	protected int defense;

	public Pokemons(String name, int HP, int attackPower, int defense) {
		this.name = name;
		this.health = HP;
		this.attackPower = attackPower;
		this.defense = defense;
	}

	public String getVards() {
		return name;
	}

	public int getHP() {
		return health;
	}

	public void heal(int amount) {
		health += amount;
		System.out.println(name + " Izarstēts par " + amount + " HP!");
	}

	public void evolucija() {
		attackPower += 10;
		defense += 5;
		System.out.println(name + " ir evolucejis un tagad ir spēcīgāks!");
	}

	public abstract void attack(Pokemons opponent);

	public abstract void evade();
}
