package com.trump.mapper;

import com.trump.domain.Resume;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TesMapper {

    Resume getResumeByUid(String uid);

}
