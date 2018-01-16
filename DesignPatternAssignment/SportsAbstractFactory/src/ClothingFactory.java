
public class ClothingFactory extends AbstractFactory {

	@Override
	Clothing getClothing(String clothing) {
		if(clothing == null) {
			return null;
		}
		
		if(clothing.equalsIgnoreCase("Shirt")) {
			return new Shirt();
		}
		else if(clothing.equalsIgnoreCase("Pant")) {
			return new Pant();
		}
		else if(clothing.equalsIgnoreCase("InnerWear")) {
			return new InnerWear();
		}
		
		return null;
	}

	@Override
	Goods getGoods(String goods) {
		return null;
	}

}
