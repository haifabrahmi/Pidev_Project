package services;

import entities.Coupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * TODO: Add class description here
 *
 */
public class CouponService implements IService_1<Coupon> {

    Connection cnx;

    public CouponService() {
        cnx = MyDB.getInstance().getCnx();
    }

   @Override
public void ajouter(Coupon c) throws SQLException {
    String res = "INSERT INTO Coupon (id_coupon, reduction, coupon) VALUES (?, ?, ?)";
    PreparedStatement ps = cnx.prepareStatement(res);
    ps.setInt(1, c.getId_coupon());
    ps.setFloat(2, c.getReduction());
    ps.setString(3, c.getCoupon());
    ps.executeUpdate();
    System.out.println("Coupon ajouté");
}


   @Override
public void modifier(Coupon c) throws SQLException {
    String req = "UPDATE Coupon SET reduction=?, coupon=? WHERE id_coupon=?";
    PreparedStatement ps = cnx.prepareStatement(req);
    ps.setFloat(1, c.getReduction());
    ps.setString(2, c.getCoupon());
    ps.setInt(3, c.getId_coupon());
    ps.executeUpdate();
    System.out.println("Coupon modifié");
}


   @Override
public void supprimer(Coupon c) throws SQLException {
    String req = "DELETE FROM Coupon WHERE id_coupon=?";
    PreparedStatement ps = cnx.prepareStatement(req);
    ps.setInt(1, c.getId_coupon());
    ps.executeUpdate();
    System.out.println("Coupon supprimé avec succès");
}


    @Override
public List<Coupon> recuperer() throws SQLException {
    List<Coupon> coupons = new ArrayList<>();
    String req = "SELECT * FROM Coupon";
    PreparedStatement ps = cnx.prepareStatement(req);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Coupon coupon = new Coupon();
        coupon.setId_coupon(rs.getInt("id_coupon"));
        coupon.setReduction(rs.getFloat("reduction"));
        coupon.setCoupon(rs.getString("coupon"));
        coupons.add(coupon);
    }
    return coupons;
}

}
 
