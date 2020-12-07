package cn.kewei.bookadmin.service.impl;

import cn.kewei.bookadmin.mapper.CategoryMapper;
import cn.kewei.bookadmin.service.ICategoryService;
import cn.kewei.bookadmin.mapper.BookMapper;
import cn.kewei.bookadmin.pojo.Category;
import cn.kewei.bookadmin.util.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public void save(Category category) {
        categoryMapper.insertSelective(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
    @Override
    public void deleteById(Long id) {
        long count = bookMapper.selectCountByCategoryId(id);
        if (count > 0) {
            throw new AdminException("删除失败, 该分类被图书信息使用中");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }
}
