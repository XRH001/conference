package com.example.demo.service.mehod;

import com.example.demo.entity.DO.ConferenceUserDO;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.enumValue.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferenceUserServiceTest {
    @Autowired
    ConferenceUserService conferenceUserService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    UserService userService;
    ConferenceUserDO conferenceUserDO=new ConferenceUserDO(4,1,2,"普通用户",2,4,"这是一个无情的备注");


    @Test
    public void saveConferenceUser() {
        ConferenceUser conferenceUser=conferenceUserService.toConferenceUser(conferenceUserDO);
        System.out.println(conferenceUserService.saveConferenceUser(conferenceUser));
    }

    @Test
    public void deleteConferenceUser() {
        conferenceUserService.deleteConferenceUser(3);
    }

    @Test
    public void queryConferenceUserByID() {
        System.out.println(conferenceUserService.queryConferenceUserByID(3));
    }

    @Test
    public void queryConferenceUsers() {
        System.out.println(conferenceUserService.queryConferenceUsers());
    }

    @Test
    public void queryConferenceUsersByUser() {
        System.out.println(conferenceUserService.queryConferenceUsersByUser(userService.queryUserByID(1)));
    }

    @Test
    public void queryConferenceUsersByConference() {
        System.out.println(conferenceUserService.queryConferenceUsersByConference(conferenceService.queryConferenceByID(1)));
    }

    @Test
    public void queryConferenceUsersByUserAndPosition() {
        System.out.println(conferenceUserService.queryConferenceUsersByUserAndPosition(userService.queryUserByID(1), Position.choose("创建者")));
    }

    @Test
    public void queryConferenceUsersByUserAndInvitationStatus() {
    }

    @Test
    public void queryConferenceUsersByUserAndOrderStatus() {
    }

    @Test
    public void queryConferenceUsersByConferenceAndPosition() {
    }

    @Test
    public void queryConferenceUsersByConferenceAndInvitationStatus() {
    }

    @Test
    public void queryConferenceUsersByConferenceAndOrderStatus() {
    }

    @Test
    public void queryForCountTotal() {
    }

    @Test
    public void queryForPageItems() {
    }

    @Test
    public void toConferenceUser() {
    }

    @Test
    public void toConferenceUserDO() {
    }
}