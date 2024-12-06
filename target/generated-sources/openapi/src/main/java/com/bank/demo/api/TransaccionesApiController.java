package com.bank.demo.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import com.bank.demo.model.Transaccion;
import com.bank.demo.model.TransaccionRequest;
import com.bank.demo.model.TransferenciaRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:13:07.956297400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
@Controller
@RequestMapping("${openapi.transactionService.base-path:}")
public class TransaccionesApiController implements TransaccionesApi {

    private final TransaccionesApiDelegate delegate;

    public TransaccionesApiController(@Autowired(required = false) TransaccionesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new TransaccionesApiDelegate() {});
    }

    @Override
    public TransaccionesApiDelegate getDelegate() {
        return delegate;
    }

}
