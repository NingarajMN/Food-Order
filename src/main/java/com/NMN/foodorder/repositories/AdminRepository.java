package com.NMN.foodorder.repositories;

import com.NMN.foodorder.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Admin findByAdminEmail(String email);


}
