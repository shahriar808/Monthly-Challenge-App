package com.shahriar.ChallengeApp.dao;

import com.shahriar.ChallengeApp.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeDao extends JpaRepository<Challenge, Long> {
    Challenge findByMonthIgnoreCase(String title);
}
