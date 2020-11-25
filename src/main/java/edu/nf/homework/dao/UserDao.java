package edu.nf.homework.dao;

import edu.nf.homework.entity.Users;
import edu.nf.homework.util.ConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author roy
 */
public class UserDao {

    public List<Users> getUserList(){
        String sql="select u_id,u_name,age,tel from user_info2";
        List<Users> list=new ArrayList<>();
        try(Connection conn= ConnUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Users u=new Users();
                    u.setUid(rs.getInt(1));
                    u.setUname(rs.getString(2));
                    u.setAge(rs.getInt(3));
                    u.setTel(rs.getString(4));
                    list.add(u);
                }
            }catch (SQLException e){
                throw e;
            }
        }catch (SQLException e){
            e.fillInStackTrace();
            throw new RuntimeException("查询失败",e);
        }
        return list;
    }

    public void addUsers(Users users){
        String sql="insert into user_info2(u_name, age, tel) values (?,?,?)";
        try(Connection conn=ConnUtils.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUname());
            ps.setInt(2,users.getAge());
            ps.setString(3,users.getTel());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败",e);
        }
    }
}
