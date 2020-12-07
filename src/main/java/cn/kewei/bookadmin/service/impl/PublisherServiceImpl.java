package cn.kewei.bookadmin.service.impl;

import cn.kewei.bookadmin.mapper.PublisherMapper;
import cn.kewei.bookadmin.pojo.Publisher;
import cn.kewei.bookadmin.service.IPublisherService;
import cn.kewei.bookadmin.util.AdminException;
import cn.kewei.bookadmin.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    private PublisherMapper publisherMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Publisher> findAll() {
        return publisherMapper.findAll();
    }

    @Override
    public void save(Publisher publisher) {
        publisherMapper.insertSelective(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Publisher publisher) {
        publisherMapper.updateByPrimaryKeySelective(publisher);
    }
    @Override
    public void deleteById(Long id) {
        long count = bookMapper.selectCountByPublisherId(id);
        if (count > 0) {
            throw new AdminException("删除失败, 该出版社被图书信息使用中");
        }
        publisherMapper.deleteByPrimaryKey(id);
    }
}
