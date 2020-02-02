package com.vlaur.project.eventsapp.model;

import javax.persistence.*;

@Entity(name = "Particpation")
@Table(name = "participations")
public class Participation {

    @EmbeddedId
    private ParticipationId id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Participation() {
    }


    public ParticipationId getId() {
        return id;
    }

    public void setId(ParticipationId id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participation that = (Participation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return event != null ? event.equals(that.event) : that.event == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }
}
