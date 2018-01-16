public class RetailShop {
	
   public static void main(String[] args) {

      AbstractFactory ClothingFactory = FactoryProducer.getFactory("Clothing");

      Clothing cloth1 = ClothingFactory.getClothing("Shirt");

      cloth1.purchase();

      Clothing cloth2 = ClothingFactory.getClothing("Pant");

      cloth2.purchase();
      
      Clothing cloth3 = ClothingFactory.getClothing("InnerWear");

      cloth3.purchase();

      AbstractFactory GoodsFactory = FactoryProducer.getFactory("Goods");

      Goods good1 = GoodsFactory.getGoods("Ball");

      good1.purchase();

      Goods good2 = GoodsFactory.getGoods("Net");

      good2.purchase();

      Goods good3 = GoodsFactory.getGoods("Bat");

      good3.purchase();
   }
}