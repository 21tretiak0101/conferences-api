package by.ttre16.tracker.repository.filter;

import by.ttre16.tracker.entity.Conference;
import lombok.Setter;

import java.util.List;

@Setter
public abstract class AbstractConferencesFilter {

    private AbstractConferencesFilter nextFilter;

    abstract List<Conference> filter(List<Conference> conferences);

    public List<Conference> getFilteredConferences(List<Conference> conferences) {

        List<Conference> filteredConferences = filter(conferences);

        if(nextFilter != null)
            filteredConferences = nextFilter.getFilteredConferences(filteredConferences);

        return filteredConferences;
    }
}
