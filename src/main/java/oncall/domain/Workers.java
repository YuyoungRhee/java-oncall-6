package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Workers {
    private final List<String> persons;

    public Workers(List<String> persons) {
        this.persons = new ArrayList<>(persons);
        validateDulicate(persons);
        validateWorkerNumber(persons);
        validateNameLength(persons);
    }

    private void validateDulicate(List<String> persons) {
        Set<String> personSet = new HashSet<>(persons);
        if (personSet.size() != persons.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 편성이 있습니다. 다시 입력해 주세요.");
        }
    }

    private void validateNameLength(List<String> persons) {
        for (String name : persons) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 닉네임이 5자가 넘어가는 근무자가 있습니다. 다시 입력해 주세요.");
            }
        }
    }

    private void validateWorkerNumber(List<String> persons) {
        if (persons.size() < 5) {
            throw new IllegalArgumentException("[ERROR] 근무자는 최소 5명 이상이어야합니다.");
        }
        if (persons.size() > 35) {
            throw new IllegalArgumentException("[ERROR] 근무자는 최대 35명 이하이어야합니다.");
        }
    }

    public String getWorker(int index) {
        return persons.get(index);
    }

    public int getSzie() {
        return persons.size();
    }

    public List<String> getPersons() {
        return new ArrayList<>(persons);
    }
}
