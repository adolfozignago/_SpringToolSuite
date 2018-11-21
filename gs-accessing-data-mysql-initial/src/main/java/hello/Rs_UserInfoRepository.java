package hello;

import org.springframework.data.repository.CrudRepository;

import hello.rs_userinfo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Rs_UserInfoRepository extends CrudRepository<rs_userinfo, Integer> {

}