package cn.kewei.bookadmin.service;

import cn.kewei.bookadmin.pojo.User;

import java.util.List;

/**
 * @Author: 柯伟
 * @Date: 2020-11-28 15:32
 * 
 */
public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    void updateById(User user);

    void save(User user);

    void updateStatusById(Long id, Integer status);

    void updatePassword(String username, String oldPassword, String newPassword);
}
