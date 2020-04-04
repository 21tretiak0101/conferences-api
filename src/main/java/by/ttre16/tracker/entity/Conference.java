package by.ttre16.tracker.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conference {

    private String id;
    private String title;
    private List<String> projects;
    private Location location;
    private List<String> tags;
    private Date dateStart;
    private Date dateFinish;
    private List<Participant> participants;
    private String ytLink;
    private Integer attendance;
    private List<String> comments;
    private String status;
    private String link;
}
