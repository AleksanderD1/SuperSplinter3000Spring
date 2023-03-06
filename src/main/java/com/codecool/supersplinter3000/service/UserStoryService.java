package com.codecool.supersplinter3000.service;

import com.codecool.supersplinter3000.entity.UserStory;
import com.codecool.supersplinter3000.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStoryService {
    private final UserStoryRepository userStoryRepository;

    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }


    public List<UserStory> getAllUsersStories() {
        return userStoryRepository.findByOrderById();
    }
    public void addOrUpdateNewUserStory(UserStory userStory) {
        userStoryRepository.save(userStory);
    }

    public Optional<UserStory> getUserStory(Long id) {
        return userStoryRepository.findById(id);
    }
}
