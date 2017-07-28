package com.trump.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class Resume {

    private String nickName;
    private String id;
    private String uid;
    private String sign;
    private String introduce;
    private int point;
    private String save_time;
    private String time;
    private List<WorkExper> mWorkExperList;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<WorkExper> getWorkExperList() {
        return mWorkExperList;
    }

    public void setWorkExperList(List<WorkExper> workExperList) {
        mWorkExperList = workExperList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSave_time() {
        return save_time;
    }

    public void setSave_time(String save_time) {
        this.save_time = save_time;
    }

    class WorkExper {
        private String id;
        private String resume_id;
        private String cname;
        private String work_name;
        private String begin_time;
        private String end_time;
        private String detail;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getResume_id() {
            return resume_id;
        }

        public void setResume_id(String resume_id) {
            this.resume_id = resume_id;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getWork_name() {
            return work_name;
        }

        public void setWork_name(String work_name) {
            this.work_name = work_name;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
