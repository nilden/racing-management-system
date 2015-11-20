package se.cag.labs.leaderboard;

import org.springframework.data.annotation.Id;
import se.cag.labs.usermanager.User;

public class UserResult {
    @Id
    private String id;
    private long created;
    private User user;
    private long time;
    private long middleTime;
    private java.lang.String result;

    public UserResult() {
        this.created = System.currentTimeMillis();
    }

    public UserResult(User user, long time, long middleTime, String result) {
        this.created = System.currentTimeMillis();
        this.user = user;
        this.time = time;
        this.middleTime = middleTime;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public long getCreated() {
        return created;
    }

    public User getUser() {
        return user;
    }

    public long getTime() {
        return time;
    }

    public long getMiddleTime() {
        return middleTime;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "created=" + created +
                ", user=" + ((user != null) ? user : "") +
                ", time=" + time +
                ", middleTime=" + middleTime +
                ", result='" + result + '\'' +
                '}';
    }
}
