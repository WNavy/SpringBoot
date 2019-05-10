package com.whj.springboot.controller;

import com.whj.springboot.common.BaseResult;
import com.whj.springboot.domain.Person;
import com.whj.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wuhaijun
 * @Date: 2019/5/9 10:17
 * @Description:
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/insert")
    public BaseResult insert(@RequestBody Person person){
        personService.insert(person);
        return BaseResult.success();
    }

    @PostMapping("/delete")
    public BaseResult delete(@RequestParam Integer id){
        personService.delete(id);
        return BaseResult.success();
    }

    @PostMapping("/update")
    public BaseResult update(@RequestBody Person person){
        personService.update(person);
        return BaseResult.success();
    }

    @PostMapping("/selectById")
    public BaseResult selectById(@RequestParam Integer id){
        Person person = personService.selectById(id);
        return BaseResult.success(person);
    }

    @PostMapping("/selectByPage")
    public BaseResult selectByPage(@RequestParam Integer pageNum,Integer pageSize){
        return BaseResult.success(personService.selectByPage(pageNum,pageSize));
    }

}
