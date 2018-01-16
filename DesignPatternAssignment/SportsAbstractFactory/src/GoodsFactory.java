
public class GoodsFactory extends AbstractFactory {

	@Override
	Goods getGoods(String goods) {
		if(goods == null) {
			return null;
		}
		
		if(goods.equalsIgnoreCase("Ball")) {
			return new Ball();
		}
		else if(goods.equalsIgnoreCase("Net")) {
			return new Net();
		}
		else if(goods.equalsIgnoreCase("Bat")) {
			return new Bat();
		}
		
		return null;
	}

	@Override
	Clothing getClothing(String clothing) {
		return null;
	}

	
	
}
