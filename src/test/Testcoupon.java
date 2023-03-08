package test;

import java.sql.SQLException;
import java.util.List;

import entities.Coupon;
import services.CouponService;

/**

Test class for CouponService
*/
public class Testcoupon {
public static void main(String[] args) {
try {
CouponService cs = new CouponService();


     Coupon c1 = new Coupon(0, 10.0f, "ABC123");
     cs.ajouter(c1);

     // Retrieve all coupons
     List<Coupon> coupons = cs.recuperer();
     System.out.println("Liste des coupons:");
     for (Coupon coupon : coupons) {
         System.out.println(coupon.toString());
     }

     // Update an existing coupon
     Coupon c2 = new Coupon(1, 20.0f, "DEF456");
     cs.modifier(c2);

     

     // Delete a coupon
     Coupon c4 = new Coupon(1, 20.0f, "DEF456");
     cs.supprimer(c4);

     // Retrieve all coupons
     coupons = cs.recuperer();
     System.out.println("Liste des coupons après suppression:");
     for (Coupon coupon : coupons) {
         System.out.println(coupon.toString());
     }
 } catch (SQLException ex) {
     System.out.println(ex.getMessage());
 }
}
}