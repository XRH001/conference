package com.example.demo.service.mehod;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.enumValue.OrderStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferenceServiceTest {
    @Autowired
    ConferenceService conferenceService;
    Conference conference=new Conference("第五次会议","主教楼", OrderStatus.Running,20, LocalDateTime.now(),LocalDateTime.now(),
                                            LocalDateTime.now(),true);

    @Test
    public void saveConference() {
        System.out.println(conferenceService.saveConference(conference));
    }

    @Test
    public void deleteConference() {
        System.out.println(conferenceService.deleteConference(999));
    }

    @Test
    public void queryConferenceByID() {
        System.out.println(conferenceService.queryConferenceByID(1));
    }

    @Test
    public void queryConferences() {
        System.out.println(conferenceService.queryConferences());
    }

    @Test
    public void queryConferencesByName() {
        System.out.println(conferenceService.queryConferencesByName("第jiu次会议"));
    }

    @Test
    public void queryConferencesByAddress() {
        System.out.println(conferenceService.queryConferencesByAddress("主教楼"));
    }

    @Test
    public void queryConferencesByOrderStatus() {
        System.out.println(conferenceService.queryConferencesByOrderStatus(OrderStatus.Running));
    }

    @Test
    public void queryConferencesByCreateTimeBetween() {
        System.out.println(conferenceService.queryConferencesByCreateTimeBetween(LocalDate.of(2020,1,1),LocalDate.of(2020,12,12)));
    }

    @Test
    public void queryConferencesByBeginTimeBetween() {
    }

    @Test
    public void queryConferencesByEndTimeBetween() {
    }

    @Test
    public void test(){
        System.out.println(conferenceService.queryForPageItems(0,3));
    }

    @Test
    public void queryConferencesByNameLike(){
        System.out.println(conferenceService.queryConferenceDOSByNameContaining("会议"));
    }
}