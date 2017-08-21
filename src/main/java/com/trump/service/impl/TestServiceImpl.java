package com.trump.service.impl;

import com.github.pagehelper.PageHelper;
import com.trump.domain.PageBean;
import com.trump.domain.Resume;
import com.trump.domain.User;
import com.trump.mapper.TesMapper;
import com.trump.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TesMapper mTestDao;

    @Override
    public Resume getResumeByUid(String uid) {
        return mTestDao.getResumeByUid(uid);
    }

    @Override
    public PageBean<User> getUsers(int pageNumber, int pageSize) {
        int total = mTestDao.getUserCount();

        PageHelper.startPage(pageNumber, pageSize);
        List<User> users = mTestDao.getUsers();
        return new PageBean<User>(total, users);
    }
}
