
public class TomatoDecorator extends ProductDecorator{

	public TomatoDecorator(Product product) {
		super(product);
		// TODO Auto-generated constructor stub
	}
	
	//Adding 8 to total price for each topping.
	@Override
	public double getTotal() {
		return this.decoratedProduct.getTotal() + 8;
	}

}
