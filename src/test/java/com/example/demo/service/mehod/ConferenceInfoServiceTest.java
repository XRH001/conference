package com.example.demo.service.mehod;

import com.example.demo.entity.DO.ConferenceInfoDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferenceInfoServiceTest {
    @Autowired
    ConferenceInfoService conferenceInfoService;
    @Autowired
    ConferenceService conferenceService;
    ConferenceInfoDO conferenceInfoDO=new ConferenceInfoDO(5,1,"这是一个无情的备注");

    @Test
    public void saveConferenceInfo() {
        conferenceInfoService.saveConferenceInfo(conferenceInfoService.toConferenceInfo(conferenceInfoDO));
    }

    @Test
    public void deleteConferenceInfo() {
        conferenceInfoService.deleteConferenceInfo(5);
    }

    @Test
    public void queryConferenceInfoByID() {
        System.out.println(conferenceInfoService.queryConferenceInfoByID(4));
    }

    @Test
    public void queryConferenceInfos() {
        System.out.println(conferenceInfoService.queryConferenceInfos());
    }

    @Test
    public void queryForCountTotal() {
        System.out.println(conferenceInfoService.queryForCountTotal());
    }

    @Test
    public void queryPageItems() {
        System.out.println(conferenceInfoService.queryPageItems(0,3));
    }

    @Test
    public void queryConferenceInfoByConference(){
        Conference conference=conferenceService.queryConferenceByID(1);
        System.out.println(conferenceInfoService.queryConferenceInfoByConference(conference));
    }

    @Test
    public void toConferenceInfo() {
    }

    @Test
    public void toConferenceInfoDO() {
    }
}