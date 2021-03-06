package cn.kewei.bookadmin.service;

import cn.kewei.bookadmin.pojo.Publisher;

import java.util.List;

public interface IPublisherService {
    List<Publisher> findAll();

    Publisher findById(Long id);

    void deleteById(Long id);

    void updateById(Publisher publisher);

    void save(Publisher publisher);
}
