package com.bank.transaccionesms.repository;

import com.bank.transaccionesms.model.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String> {

}
