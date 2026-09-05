package org.example.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassportGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Connection con = null;
        String prefix  = "PASS-";
        int suffix     = 0;
        try{
            con = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();
            PreparedStatement pst = con.prepareStatement("select next_val from passport_gen");
            ResultSet resultSet = pst.executeQuery();

            while(resultSet.next()){
                suffix = resultSet.getInt(1);
            }

            pst = con.prepareStatement("update passport_gen set next_val = ?");
            pst.setInt(1,(suffix+1));
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return prefix+""+suffix;
    }
}
