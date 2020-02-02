package com.vlaur.project.eventsapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipationId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "event_id")
    private Long eventId;

    public ParticipationId() {
    }

    public ParticipationId(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipationId that = (ParticipationId) o;

        if (!userId.equals(that.userId)) return false;
        return eventId.equals(that.eventId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + eventId.hashCode();
        return result;
    }
}
