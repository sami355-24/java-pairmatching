package pairmatching.Domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Pair {

    private Set<String> members;

    public Pair(List<String> members) {
        this.members = Set.copyOf(members);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair otherPair = (Pair) obj;
        return members.equals(otherPair.members);
    }

    @Override
    public int hashCode() {
        return members.hashCode();
    }

    public Set<String> getMembers() {
        return Collections.unmodifiableSet(members);
    }
}
