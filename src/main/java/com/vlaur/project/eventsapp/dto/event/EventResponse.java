package com.vlaur.project.eventsapp.dto.event;

import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.model.Access;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EventResponse {

    private Long id;
    private LocalDate date;
    private String name;
    private String address;
    private Access access;
    private UserResponse organiser;

    public EventResponse() {
    }

    public EventResponse(Long id, LocalDate date, String name, String address, Access access, UserResponse organiser) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.access = access;
        this.organiser = organiser;
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

    public UserResponse getOrganiser() {
        return organiser;
    }

    public void setOrganiser(UserResponse organiser) {
        this.organiser = organiser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventResponse that = (EventResponse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (access != that.access) return false;
        return organiser != null ? organiser.equals(that.organiser) : that.organiser == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (access != null ? access.hashCode() : 0);
        result = 31 * result + (organiser != null ? organiser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", access=" + access +
                ", organiser=" + organiser +
                '}';
    }
}
