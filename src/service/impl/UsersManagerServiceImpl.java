package service.impl;

import dao.UserManagerDaoImpl;
import dao.UsersManagerDao;
import entry.UsersManager;
import service.UsersMangerService;

/**
 * @author 林敬舒
 * @create 2021-06-20-14:08
 */
public class UsersManagerServiceImpl implements UsersMangerService {

    UsersManagerDao usersManagerDao = new UserManagerDaoImpl();
    @Override
    public UsersManager findUsersManagerByLogin(String username, String password) {
        return usersManagerDao.findUsersManagerByLogin(username,password);
    }

    @Override
    public boolean changeUserManagerPwd(String password, int id) {
        return usersManagerDao.changeUserManagerPwd(password,id);
    }
}
