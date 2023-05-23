package com.igchesno.CrudSpringBoot.repository;

import com.igchesno.CrudSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}

