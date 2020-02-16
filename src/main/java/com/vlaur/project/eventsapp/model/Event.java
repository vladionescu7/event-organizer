package com.vlaur.project.eventsapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Event")
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate date;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    @Enumerated(EnumType.STRING)
    private Access access;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;


    public Event() {
    }

    public Event(Long id, LocalDate date, String name, String address, Access access, User organizer) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.access = access;
        this.organizer = organizer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        return name != null ? name.equals(event.name) : event.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
