package com.soloproject_codestates.To_Do_App_soloproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int todoOrder;

    @Column(nullable = false)
    private boolean completed;

    public int getTodoOrder() {
        return todoOrder;
    }
}
