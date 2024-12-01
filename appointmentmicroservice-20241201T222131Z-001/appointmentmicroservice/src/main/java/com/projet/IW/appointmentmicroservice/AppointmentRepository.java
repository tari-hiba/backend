package com.projet.IW.appointmentmicroservice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByProfessionalId(Long professionalId);

    List<Appointment> findByClientId(Long clientId);

    List<Appointment> findByStatus(String status);
}