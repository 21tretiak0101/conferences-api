package by.ttre16.tracker.repository.filter;

import by.ttre16.tracker.entity.Conference;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Setter
public class TagsFilter extends AbstractConferencesFilter {

    private List<String> tags;

    @Override
    public List<Conference> filter(List<Conference> conferences) {
        if (tags.isEmpty()) return conferences;

        return conferences.stream()
                .filter(c -> c.getTags().containsAll(tags))
                .collect(Collectors.toList());
    }
}
