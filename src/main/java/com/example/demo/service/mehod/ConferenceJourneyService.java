package com.example.demo.service.mehod;

import com.example.demo.dao.ConferenceJourneyDAO;
import com.example.demo.entity.DO.ConferenceJourneyDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.VO.ConferenceJourney;
import com.example.demo.entity.DTO.Journey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConferenceJourneyService {
    @Autowired
    ConferenceJourneyDAO conferenceJourneyDAO;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    JourneyService journeyService;
    List<ConferenceJourney> list=new ArrayList<>();
    List<ConferenceJourneyDO> conferenceJourneyDOList;

    public ConferenceJourneyDO saveConferenceJourney(ConferenceJourney conferenceJourney){
        if (conferenceJourney!=null){
            return conferenceJourneyDAO.save(toConferenceJourneyDO(conferenceJourney));
        }else {
            return null;
        }
    }

    public int deleteConferenceJourneyByID(int conferenceJourneyID){
        try {
            conferenceJourneyDAO.deleteById(conferenceJourneyID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    public ConferenceJourney queryConferenceJourneyByID(int conferenceJourneyID){
        try {
            return toConferenceJourney(conferenceJourneyDAO.queryConferenceJourneyDOByID(conferenceJourneyID));
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public List<ConferenceJourney> queryConferenceJourneys(){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.findAll();
        if (conferenceJourneyDOList.size()!=0){
            for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
                list.add(toConferenceJourney(conferenceJourneyDO));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<ConferenceJourney> queryConferenceJourneysByConference(Conference conference){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.queryConferenceJourneyDOSByConferenceID(conference.getID());
        if (conferenceJourneyDOList.size()!=0){
            for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
                list.add(toConferenceJourney(conferenceJourneyDO));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<ConferenceJourney> queryConferenceJourneysByJourney(Journey journey){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.queryConferenceJourneyDOSByConferenceID(journey.getID());
        if (conferenceJourneyDOList.size()!=0){
            for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
                list.add(toConferenceJourney(conferenceJourneyDO));
            }
            return list;
        }else {
            return null;
        }
    }

    public int queryForCountTotal(){
        return (int) conferenceJourneyDAO.count();
    }

    public List<ConferenceJourney> queryForPageItems(int begin,int pageSize){
        try {
            list.clear();
            conferenceJourneyDOList=conferenceJourneyDAO.queryForPageItems(begin,pageSize);
            if (conferenceJourneyDOList.size()!=0){
                for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
                    list.add(toConferenceJourney(conferenceJourneyDO));
                }
                return list;
            }else {
                return null;
            }

        }catch (Exception e){
            return null;
        }

    }


    public ConferenceJourney toConferenceJourney(ConferenceJourneyDO conferenceJourneyDO){
        ConferenceJourney conferenceJourney=new ConferenceJourney();

        conferenceJourney.setID(conferenceJourneyDO.getID());
        conferenceJourney.setConference(conferenceService.queryConferenceByID(conferenceJourneyDO.getConferenceID()));
        conferenceJourney.setJourney(journeyService.queryJourneyByID(conferenceJourneyDO.getJourneyID()));

        return conferenceJourney;
    }

    public ConferenceJourneyDO toConferenceJourneyDO(ConferenceJourney conferenceJourney){
        ConferenceJourneyDO conferenceJourneyDO=new ConferenceJourneyDO();

        conferenceJourneyDO.setID(conferenceJourney.getID());
        conferenceJourneyDO.setConferenceID(conferenceJourney.getConference().getID());
        conferenceJourneyDO.setJourneyID(conferenceJourney.getJourney().getID());

        return conferenceJourneyDO;
    }
}
