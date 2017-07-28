package com.trump.dao.impl;

import com.trump.dao.TestDao;
import com.trump.domain.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Override
    public Resume getResumeByUid(String uid) {
        String sql = "select * from rc_resume where uid = ?";
        RowMapper<Resume> rowMapper = new BeanPropertyRowMapper<>(Resume.class);
        return mJdbcTemplate.queryForObject(sql, rowMapper, uid);
    }
}
