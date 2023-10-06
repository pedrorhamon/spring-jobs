package com.starking.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.batch.model.Contract;

/**
 * @author pedroRhamon
 */
public interface ContractRepository extends JpaRepository<Contract, String> {

}
