package com.vlaur.project.eventsapp.dto.event;

import com.vlaur.project.eventsapp.model.Access;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

;

@Component
public class EventRequest {

    private LocalDate date;
    private String name;
    private String address;
    private Access access;
    private Long organiserId;

    public EventRequest() {
    }

    public EventRequest(LocalDate date, String name, String address, Access access, Long organiserId) {
        this.date = date;
        this.name = name;
        this.address = address;
        this.access = access;
        this.organiserId = organiserId;
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

    public Long getOrganiserId() {
        return organiserId;
    }

    public void setOrganiserId(Long organiserId) {
        this.organiserId = organiserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventRequest that = (EventRequest) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (access != that.access) return false;
        return organiserId != null ? organiserId.equals(that.organiserId) : that.organiserId == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (access != null ? access.hashCode() : 0);
        result = 31 * result + (organiserId != null ? organiserId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventRequest{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", access=" + access +
                ", organiserId=" + organiserId +
                '}';
    }
}
