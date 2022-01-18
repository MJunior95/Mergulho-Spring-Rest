package com.algaworks.algalog.api.model.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputModel {

	@Valid
	@NotNull
	private ClienteIdInputModel cliente;
	
	@Valid
	@NotNull
	private DestinatarioInputModel destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
}
