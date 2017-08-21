package com.trump.mapper;

import com.trump.domain.Resume;
import com.trump.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TesMapper {

    Resume getResumeByUid(String uid);

    List<User> getUsers();

    int getUserCount();

}
