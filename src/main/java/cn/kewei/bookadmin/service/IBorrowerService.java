package cn.kewei.bookadmin.service;

import cn.kewei.bookadmin.pojo.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<Borrower> findAll();

    void updateStatusById(Long id, Integer status);

    List<Long> findNewReaderBeforeDate(List<String> dates);
}
