
public class MushroomDecorator extends ProductDecorator{

	public MushroomDecorator(Product product) {
		super(product);
	}

	//Adding 8 to total price for each topping.
	@Override
	public double getTotal() {
		return this.decoratedProduct.getTotal() + 8;
	}
	

}
