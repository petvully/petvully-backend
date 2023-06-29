package com.hackathon.petvully.dto.QuestDTO;

import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestSaveDTO {
    private boolean water;
    private boolean food;
    private boolean walk;
    private boolean shower;

    public Quest toEntity(User userId) {
        return Quest.builder()
                .userId(userId)
                .water(water)
                .food(food)
                .walk(walk)
                .shower(shower)
                .build();
    }
}