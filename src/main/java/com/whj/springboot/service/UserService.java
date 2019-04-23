package com.whj.springboot.service;

import com.whj.springboot.domain.User;

public interface UserService {

    Object select(String id);

    void insert(User user);
}
