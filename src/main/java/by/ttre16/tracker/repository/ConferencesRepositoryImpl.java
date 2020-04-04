package by.ttre16.tracker.repository;

import by.ttre16.tracker.entity.Conference;
import by.ttre16.tracker.repository.filter.ParamsFilter;
import by.ttre16.tracker.repository.filter.TagsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ConferencesRepositoryImpl implements ConferencesRepository {

    private List<Conference> conferencesList;
    private TagsFilter tagsFilter;
    private ParamsFilter paramsFilter;

    @Autowired
    public ConferencesRepositoryImpl(List<Conference> conferencesList,
                                     TagsFilter tagsFilter,
                                     ParamsFilter paramsFilter) {
        this.conferencesList = conferencesList;
        this.tagsFilter = tagsFilter;
        this.paramsFilter = paramsFilter;
    }

    @Override
    public Conference findById(String id) {
        return conferencesList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Conference> findAll() {
        return conferencesList;
    }

    @Override
    public List<Conference> findByTagsAndParams(List<String> tags, Map<String, String> params) {
        tagsFilter.setTags(tags);
        paramsFilter.setParams(params);
        tagsFilter.setNextFilter(paramsFilter);
        return tagsFilter.getFilteredConferences(conferencesList);
    }
}
