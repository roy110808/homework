package edu.nf.homework.service;

import edu.nf.homework.dao.UserDao;
import edu.nf.homework.entity.Users;

import java.util.List;

/**
 * @author roy
 */
public class UserService {

    public List<Users> getUserList(){
        UserDao dao=new UserDao();
        return dao.getUserList();
    }

    public void addUsers(Users users){
        UserDao dao=new UserDao();
        dao.addUsers(users);
    }
}
