package org.example.customgen;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Connection con =null;
        String prefix  = "CI-";
        String suffix  = "";
        int value      = 0;
        try {
            con = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();
            PreparedStatement pst = con.prepareStatement("select next_val from contact_gen");
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                suffix = Integer.toString(resultSet.getInt(1));
                value  = resultSet.getInt(1);
            }
            pst    = con.prepareStatement("update contact_gen set next_val = ?");
            pst.setString(1,Integer.toString((value+1)));
            int i = pst.executeUpdate();
            System.out.println("Updated :: "+i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return prefix+suffix;
    }
}
