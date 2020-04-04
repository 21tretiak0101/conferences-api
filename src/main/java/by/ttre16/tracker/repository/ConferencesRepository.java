package by.ttre16.tracker.repository;

import by.ttre16.tracker.entity.Conference;

import java.util.List;
import java.util.Map;

public interface ConferencesRepository {

    List<Conference> findAll();

    Conference findById(String id);

    List<Conference> findByTagsAndParams(List<String> tags, Map<String, String> params);

}
