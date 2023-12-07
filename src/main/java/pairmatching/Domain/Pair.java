package pairmatching.Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Pair {

    private Set<String> members;

    public Pair(Crew crew1, Crew crew2) {
        this.members = Set.of(crew1.getName(), crew2.getName());
    }

    public Pair(Queue<Crew> crews){
        this.members = new HashSet<>();
        for (Crew crew : crews) {
            members.add(crew.getName());
        }
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
