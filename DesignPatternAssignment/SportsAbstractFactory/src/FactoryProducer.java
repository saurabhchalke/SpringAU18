public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
   
      if(choice.equalsIgnoreCase("Clothing")){
         return new ClothingFactory();
         
      }else if(choice.equalsIgnoreCase("Goods")){
         return new GoodsFactory();
      }
      
      return null;
   }
}