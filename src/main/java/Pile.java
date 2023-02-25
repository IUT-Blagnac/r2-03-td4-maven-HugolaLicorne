
public class Pile {
	int[] pile;
	int sommet = -1;
	
	Pile(int pfTaille){
		this.pile = new int[pfTaille];
	}

	public boolean est_vide() {
		if(this.sommet == -1)
		{
			return true;
		}
		return false;
	}
	public void empiler(int pfElement) {
		this.sommet++;
		this.pile[sommet] = pfElement;
	}

	public int depiler() throws Exception {
		if(this.est_vide()) {
			throw new Exception("La pile est vide");
		}
		this.sommet--;
		return this.pile[sommet + 1];
	}
	
	public int sommet() {
		return this.pile[this.sommet];
	}
	
	public void vider(){
		this.sommet = -1;
	}

}
