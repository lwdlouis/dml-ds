package com.dml.ds.webapi.repository;

import com.dml.ds.webapi.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    public Mono<User> findByStaffId(String staffId);
}
