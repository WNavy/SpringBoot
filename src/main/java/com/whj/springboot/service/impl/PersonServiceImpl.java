package com.whj.springboot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whj.springboot.domain.Person;
import com.whj.springboot.mapper.PersonMapper;
import com.whj.springboot.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author: wuhaijun
 * @Date: 2019/5/9 09:39
 * @Description:
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper mapper;

    @Override
    public void insert(Person person) {
        int insert = mapper.insert(person);
        log.info("插入后返回：{}",insert);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void update(Person person) {
        mapper.update(person);
    }

    @Override
    public Person selectById(Integer id) {
        log.info("执行selectById方法。。。。。");
        Person person = mapper.selectById(id);
        return person;
    }

    @Override
    public PageInfo<Person> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Person> list = mapper.selectByPage();
        PageInfo<Person> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
