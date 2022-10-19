package com.johnoro.cpm.repository;

import com.johnoro.cpm.model.FakeUser;

import java.util.Optional;

public interface FakeUserRepository extends BaseRepository<FakeUser> {
    Optional<FakeUser> findByUsername(String username);
}
