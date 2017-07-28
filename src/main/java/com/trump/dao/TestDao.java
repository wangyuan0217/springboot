package com.trump.dao;

import com.trump.domain.Resume;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface TestDao {

    Resume getResumeByUid(String uid);

}
