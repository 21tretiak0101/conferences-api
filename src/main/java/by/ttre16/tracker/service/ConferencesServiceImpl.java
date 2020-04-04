package by.ttre16.tracker.service;

import by.ttre16.tracker.entity.Conference;
import by.ttre16.tracker.repository.ConferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConferencesServiceImpl implements ConferencesService {

    private ConferencesRepository repository;

    @Autowired
    public ConferencesServiceImpl(ConferencesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Conference> getConferenceById(String id) {
       return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public List<Conference> getAllConferences() {
        return repository.findAll();
    }

    @Override
    public List<Conference> getConferencesByTagsAndParams(List<String> tags, Map<String, String> params) {
        return repository.findByTagsAndParams(tags, params);
    }
}
