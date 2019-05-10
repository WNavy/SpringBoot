package com.whj.springboot.mapper;

import com.github.pagehelper.Page;
import com.whj.springboot.domain.Person;
import java.util.List;

/**
 * @Author:whj
 */
public interface PersonMapper {

    /**
     * 保存数据
     * @param person
     * @return
     */
    int insert(Person person);

    /**
     * 根据id删除数据
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新数据
     * @param person
     */
    void update(Person person);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Person selectById(Integer id);

    /**
     * 分页查询
     * @return
     */
    List<Person> selectByPage();
}
