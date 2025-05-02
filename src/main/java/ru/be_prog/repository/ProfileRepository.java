package ru.be_prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.be_prog.model.Profile;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
}
