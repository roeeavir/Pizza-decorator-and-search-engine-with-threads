//Decorator of product (pizza in our case)
public abstract class ProductDecorator implements Product{
	
	protected Product decoratedProduct;

	public ProductDecorator(Product product) {
		this.decoratedProduct = product;
	}
	
	

}
