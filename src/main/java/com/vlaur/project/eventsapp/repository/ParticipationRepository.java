package com.vlaur.project.eventsapp.repository;

import com.vlaur.project.eventsapp.model.Participation;
import com.vlaur.project.eventsapp.model.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, ParticipationId> {
}
