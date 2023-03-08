package com.codecool.supersplinter3000.controller;

import com.codecool.supersplinter3000.entity.UserStory;
import com.codecool.supersplinter3000.entity.UserStoryStatus;
import com.codecool.supersplinter3000.service.UserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class UserStoryController {
    private final UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }


    @GetMapping("/")
    public String allUserStories(Model model){
        model.addAttribute("userStory", userStoryService.getAllUsersStories());
        return "index";
    }
    @GetMapping("/story/{id}")
    public String userStoryPage(@PathVariable Long id, Model model){
        Optional<UserStory> userStory = userStoryService.getUserStory(id);
        if(userStory.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Story not found");
        }


        model.addAttribute("userStory", userStory.get());
        return "new_user_story";
    }

    @GetMapping("/new-story")
    public String newUserStory(UserStory userStory ){
        return "new_user_story";
    }

    @PostMapping("/new-user-story")
    public String saveOrUpdateNewUserStory(@Valid UserStory userStory, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new_user_story";
        }
        userStoryService.addOrUpdateNewUserStory(userStory);
        return "redirect:/";
    }

    @ModelAttribute("dropDownAllStatuses")
    private List<String> getUserStoriesStatuses(){
        return Arrays.stream(UserStoryStatus.values())
                .map(Enum::name)
                .toList();
    }
}
