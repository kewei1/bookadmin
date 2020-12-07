package cn.kewei.bookadmin.service;

import cn.kewei.bookadmin.pojo.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void updateById(Category category);

    void deleteById(Long id);
}
