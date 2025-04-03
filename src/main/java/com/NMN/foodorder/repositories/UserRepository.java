package com.NMN.foodorder.repositories;

import com.NMN.foodorder.entities.User;
import com.NMN.foodorder.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>
{
    public User findUserByUemail(String email);
}