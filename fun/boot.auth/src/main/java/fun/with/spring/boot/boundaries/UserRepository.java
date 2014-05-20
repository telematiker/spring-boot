package fun.with.spring.boot.boundaries;

import org.springframework.data.mongodb.repository.MongoRepository;

import fun.with.spring.boot.impl.User;

public interface UserRepository extends MongoRepository<User, String> {



}
