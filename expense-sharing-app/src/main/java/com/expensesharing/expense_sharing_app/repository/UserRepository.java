package com.expensesharing.expense_sharing_app.repository;

import com.expensesharing.expense_sharing_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
