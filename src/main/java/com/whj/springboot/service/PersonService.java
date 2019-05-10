package com.whj.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.whj.springboot.domain.Person;

/**
 * @Author:whj
 */
public interface PersonService {

    /**
     * 保存数据
     * @param person
     */
    void insert(Person person);

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
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Person> selectByPage(Integer pageNum, Integer pageSize);
}
