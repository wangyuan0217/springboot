package com.trump.service;

import com.trump.domain.PageBean;
import com.trump.domain.Resume;
import com.trump.domain.User;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface TestService {

    Resume getResumeByUid(String uid);

    PageBean<User> getUsers(int pageNumber, int pageSize);

    PageBean<User> getUsers2();
}
