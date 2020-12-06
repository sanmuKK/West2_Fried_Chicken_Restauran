import assign2.West2FriedChickenRestaurant;

public class RestaurantTest {
    public static void main(String[] args) {
        West2FriedChickenRestaurant restaurant1 = new West2FriedChickenRestaurant(134.4);//初始化
        System.out.println(restaurant1.getBeer_list());
        System.out.println(restaurant1.getJuice_list());//此时还未进货,两表为空
        restaurant1.bulk_purchase();//进货
        System.out.println(restaurant1.getBeer_list());
        System.out.println(restaurant1.getJuice_list());//进完货两表不为空
        System.out.println(restaurant1.getBalance());
        restaurant1.sale_package(restaurant1.getSet_meal_list().get(0));//出售余额增加,饮料减少,同时会调用use函数，删除过期的饮料
        System.out.println(restaurant1.getBalance());
        System.out.println(restaurant1.getJuice_list());
        System.out.println(restaurant1.getBeer_list());

        //下一句执行会抛出售尽异常
        //restaurant1.sale_package(restaurant1.getSet_meal_list().get(0));

        //West2FriedChickenRestaurant restaurant2 = new West2FriedChickenRestaurant(4.4);//不足以进货
        //下一句执行会抛出余额不足异常
        //restaurant2.bulk_purchase();
    }
}
