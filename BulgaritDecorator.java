
public class BulgaritDecorator extends ProductDecorator{

	public BulgaritDecorator(Product product) {
		super(product);
	}

	//Adding 8 to total price for each topping.
	@Override
	public double getTotal() {
		return this.decoratedProduct.getTotal() + 8;
	}

}
