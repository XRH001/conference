package com.example.demo.entity.VO;

import java.util.ArrayList;
import com.example.demo.entity.VO.Alter;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddConfence {
    private ArrayList<Integer> meetingIdList;
    private String hotelId;



    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }



    public ArrayList<Integer> getMeetingIdList() {
        return meetingIdList;
    }

    public void setMeetingIdList(ArrayList<Integer> meetingIdList) {
        this.meetingIdList = meetingIdList;
    }

    private String userId;
    private String meetingId;

    private String remark;
    private String memberId;
    private Alter alter;

    public Alter getAlter() {
        return alter;
    }

    public void setAlter(Alter alter) {
        this.alter = alter;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRemark() {
        return remark;
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


    @Override
    public String toString() {
        return "UserAddConfence{" +
                "meetingIdList=" + meetingIdList +
                ", hotelId='" + hotelId + '\'' +
                ", userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", remark='" + remark + '\'' +
                ", memberId='" + memberId + '\'' +
                ", alter=" + alter +
                '}';
    }

}
