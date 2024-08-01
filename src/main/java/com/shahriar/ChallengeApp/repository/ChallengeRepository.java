package com.shahriar.ChallengeApp.repository;

import com.shahriar.ChallengeApp.entity.Challenge;

import java.util.List;
import java.util.Optional;

public interface ChallengeRepository {
    public Challenge getChallenge(Long id);
    public List<Challenge> getAllChallenges();
    public Challenge getChallengeByTitle(String title);
    public boolean addChallenge(Challenge challenge);
    public boolean updateChallenge(Long id, Challenge challenge);
    public boolean deleteChallenge(Long id);

}
