package cn.kewei.bookadmin.mapper;

import cn.kewei.bookadmin.pojo.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);

    List<Publisher> findAll();
}