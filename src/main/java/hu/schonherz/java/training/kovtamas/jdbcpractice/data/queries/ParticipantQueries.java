package hu.schonherz.java.training.kovtamas.jdbcpractice.data.queries;

public final class ParticipantQueries {

    private ParticipantQueries() {
    }

    public static final String QUERY_FIND_ALL = "SELECT * FROM PROMOTION_TRACKER.PARTICIPANT";
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM PROMOTION_TRACKER.PARTICIPANT WHERE id = ?";
    public static final String QUERY_SAVE
            = "INSERT INTO PROMOTION_TRACKER.PARTICIPANT (name, email) VALUES(?,?)";

}
