package by.ttre16.tracker.service;

import by.ttre16.tracker.entity.Conference;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ConferencesService {

    Optional<Conference> getConferenceById(String id);

    List<Conference> getAllConferences();

    List<Conference> getConferencesByTagsAndParams(List<String> tags, Map<String, String> params);

}
