package com.trump.service.impl;

import com.trump.mapper.TesMapper;
import com.trump.domain.Resume;
import com.trump.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
