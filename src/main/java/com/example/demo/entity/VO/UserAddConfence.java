package com.example.demo.entity.VO;

public class UserAddConfence {
    private String userId;
    private String meetingId;
    private String remark;
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "UserAddConfence{" +
                "userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", remark='" + remark + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
