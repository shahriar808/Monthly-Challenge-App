package com.shahriar.ChallengeApp.controller;

import com.shahriar.ChallengeApp.entity.Challenge;
import com.shahriar.ChallengeApp.service.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
@CrossOrigin(origins = "http://localhost:3000")
public class MyController {
    private final ChallengeService challengeService;

    public MyController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getChallenges() {
        return this.challengeService.getAllChallenges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable Long id) {
        Challenge challenge = this.challengeService.getChallenge(id);
        if (challenge != null) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<Challenge> getChallengeByTitle(@PathVariable String month) {
        Challenge challenge = this.challengeService.getChallengeByMonth(month);
        if (challenge != null) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createChallenge(@RequestBody Challenge challenge) {
        boolean isAdded = this.challengeService.addChallenge(challenge);
        if (isAdded) {
            return ResponseEntity.ok("Challenge created");
        } else {
            return ResponseEntity.badRequest().body("Challenge not created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        boolean isUpdated = challengeService.updateChallenge(id, updatedChallenge);
        if (isUpdated) {
            return ResponseEntity.ok("Challenge updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Challenge not updated");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id) {
        boolean isDeleted = challengeService.deleteChallenge(id);
        if (isDeleted) {
            return ResponseEntity.ok("Challenge deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
