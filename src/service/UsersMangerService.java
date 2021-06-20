package service;

import entry.UsersManager;

/**
 * @author 林敬舒
 * @create 2021-06-20-14:09
 */
public interface UsersMangerService {

    public UsersManager findUsersManagerByLogin(String username, String password);
    public boolean changeUserManagerPwd(String password,int id);
}
