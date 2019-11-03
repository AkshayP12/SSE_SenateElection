package com.onlinevotingsystem.ovs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevotingsystem.ovs.model.User;
@Repository
public interface voteRepository extends JpaRepository<vote, Integer> {
    //Send Acknowledgement
    public User sendByEmail(String email);
}