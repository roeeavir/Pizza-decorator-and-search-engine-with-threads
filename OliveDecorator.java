
public class OliveDecorator extends ProductDecorator{

	public OliveDecorator(Product product) {
		super(product);
		// TODO Auto-generated constructor stub
	}
	//Adding 8 to total price for each topping.
	@Override
	public double getTotal() {
		return this.decoratedProduct.getTotal() + 8;
	}
	
}
