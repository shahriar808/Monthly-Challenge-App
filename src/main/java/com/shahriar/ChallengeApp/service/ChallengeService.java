package com.shahriar.ChallengeApp.service;

import com.shahriar.ChallengeApp.dao.ChallengeDao;
import com.shahriar.ChallengeApp.entity.Challenge;
import com.shahriar.ChallengeApp.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ChallengeService implements ChallengeRepository {
    Long nextId = 1L;
    public final ChallengeDao challengeDao;
    @Autowired
    public ChallengeService(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @Override
    public Challenge getChallenge(Long id) {
        Optional<Challenge> challenge = challengeDao.findById(id);
        return challenge.orElse(null);
    }

    @Override
    public List<Challenge> getAllChallenges() {
        return challengeDao.findAll();
    }

    @Override
    public Challenge getChallengeByMonth(String month) {
        Optional<Challenge> challenge = Optional.ofNullable(challengeDao.findByMonthIgnoreCase(month));
        return challenge.orElse(null);
    }

    @Override
    public boolean addChallenge(Challenge challenge) {
        if (challenge != null){
            challenge.setId(nextId++);
            challengeDao.save(challenge);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateChallenge(Long id, Challenge Updatechallenge){
        Optional<Challenge> challenge = challengeDao.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(Updatechallenge.getMonth());
            challengeToUpdate.setDescription(Updatechallenge.getDescription());
            challengeDao.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeDao.findById(id);
        if(challenge.isPresent()){
            challengeDao.delete(challenge.get());
            return true;
        }
        return false;
    }
}
