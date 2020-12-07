package cn.kewei.bookadmin.service;

import cn.kewei.bookadmin.pojo.BookStock;

import java.util.List;

public interface IBookStockService {
    List<BookStock> findAll();

    void addTotalStock(Long id, Integer stock);
}
