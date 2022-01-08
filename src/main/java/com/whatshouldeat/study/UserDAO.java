package com.whatshouldeat.study;

import com.whatshouldeat.study.model.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static UserEntity selChkNaver(UserEntity param){
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = " SELECT * FROM t_user where uid = ? ";

        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1, param.getUid());
            rs = pr.executeQuery();
            if(rs.next()){
                UserEntity entity = new UserEntity();
                entity.setEmail(rs.getString("email"));
                entity.setUid(rs.getString("uid"));
                entity.setUpw(rs.getString("upw"));
                entity.setNm(rs.getString("nm"));
                entity.setRdt(rs.getString("rdt"));
                entity.setIuser(rs.getInt("iuser"));
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr,rs);
        }
        return null;
    }

    public static int join(UserEntity entity){
        Connection con = null;
        PreparedStatement pr = null;
        String sql = " INSERT into t_user "+
                " (uid, upw, nm, email) "+
                " VALUES "+
                " (?,?,?,?) ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1,entity.getUid());
            pr.setString(2,entity.getUpw());
            pr.setString(3,entity.getNm());
            pr.setString(4,entity.getEmail());
            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr);
        }
        return 0;
    }
}
