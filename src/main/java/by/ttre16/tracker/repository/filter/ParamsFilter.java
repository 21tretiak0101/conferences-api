package by.ttre16.tracker.repository.filter;

import by.ttre16.tracker.entity.Conference;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Setter
public class ParamsFilter extends AbstractConferencesFilter {

    private Map<String, String> params;

    @Override
    public List<Conference> filter(List<Conference> conferences) {
        return conferences.stream()
                .filter(c ->
                        c.getStatus().contains(params.get("status"))
                                && c.getLocation().getCity().contains(params.get("city"))
                                && c.getLocation().getCountry().contains(params.get("country"))
                                && c.getTitle().contains(params.get("title")))
                .collect(Collectors.toList());
    }
}
