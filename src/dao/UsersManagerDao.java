package dao;

import entry.UsersManager;

/**
 * @author 林敬舒
 * @create 2021-06-18-13:57
 */
public interface UsersManagerDao {
    public UsersManager findUsersManagerByLogin(String username,String password);
    public boolean changeUserManagerPwd(String username,String oldPassword,String newPassword);
}
