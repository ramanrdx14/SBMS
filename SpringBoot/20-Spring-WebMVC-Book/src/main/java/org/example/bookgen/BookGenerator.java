package org.example.bookgen;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "BK-";
        String suffix = "";
        try {
            Connection con = session.getJdbcConnectionAccess().obtainConnection();
            String sql     = "select next_val from book_tbl_gen";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs          = pst.executeQuery();
            int val               = 0;
            while(rs.next()){
                val = rs.getInt(1);
            }
            suffix = Integer.toString(val);

            sql    = "update book_tbl_gen set next_val=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1,val+1);
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  prefix+suffix;
    }
}
