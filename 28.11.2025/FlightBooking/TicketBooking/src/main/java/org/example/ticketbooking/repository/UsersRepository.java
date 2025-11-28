package org.example.ticketbooking.repository;

import org.example.ticketbooking.model.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByEmail(String email);
}
