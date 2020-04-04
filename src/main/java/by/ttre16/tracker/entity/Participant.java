package by.ttre16.tracker.entity;

import lombok.Data;

@Data
public class Participant {

    private String name;
    private String type;
    private String status;
    private boolean invited;
}
