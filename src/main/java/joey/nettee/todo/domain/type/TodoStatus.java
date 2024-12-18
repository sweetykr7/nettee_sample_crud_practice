package joey.nettee.todo.domain.type;

import java.util.EnumSet;
import java.util.Set;

public enum TodoStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    REMOVED;

    private static final Set<TodoStatus> GENERAL_QUERY_STATUS = EnumSet.of(PENDING, COMPLETED);

    public static Set<TodoStatus> getGeneralQueryStatus() {
        return GENERAL_QUERY_STATUS;
    }
}
