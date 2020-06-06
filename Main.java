
public class Main {
	
	public static void main(String[] args) {
		//Question 1
		System.out.println("\nQuestion 1:\n");
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.search();
		
		
		//Question 2
		System.out.println("\nQuestion 2:\n");
		//Initializing pizza
		Product pp = new PersonalPizza("Personal Pizza", 500);
		Product fp = new FamilyPizza("Family Pizza",1000);
		Product hp = new HugePizza("Huge Pizza",2000);
		
		//Printing clean pizza price
		System.out.println("Personal Pizza : " + pp.getTotal());
		System.out.println("Family Pizza : " + fp.getTotal());
		System.out.println("Huge Pizza : " + hp.getTotal());
		
		//Initializing pizza with toppings.
		pp = new BulgaritDecorator(new TomatoDecorator(pp));
		fp = new TomatoDecorator(new MushroomDecorator(fp));
		hp = new MushroomDecorator(new OliveDecorator(hp));
		
		//Printing pizza with toppings price
		System.out.println("Personal Pizza With Tomatos and Bulgarit: " + pp.getTotal());
		System.out.println("Family Pizza With Mushrooms and Tomatos: " + fp.getTotal());
		System.out.println("Huge Pizza With Olives and Mushrooms: " + hp.getTotal());
		
	}
	
	
	
}
