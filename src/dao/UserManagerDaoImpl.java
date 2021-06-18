package dao;

import entry.UsersManager;

/**
 * @author 林敬舒
 * @create 2021-06-18-14:09
 */
public class UserManagerDaoImpl implements UsersManagerDao{
    @Override
    public UsersManager findUsersManagerByLogin(String username, String password) {
        return null;
    }

    @Override
    public boolean changeUserManagerPwd(String password, int id) {
        return false;
    }
}
