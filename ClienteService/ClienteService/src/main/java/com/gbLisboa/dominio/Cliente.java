package com.gbLisboa.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection ="cliente") //mapeando dizendo que essa classe pertence a coleção do database chamada cliente
@Getter
@Setter
@AllArgsConstructor //annotation para definir que tem construtor com todos os argumentos 
@NoArgsConstructor //annotation para definir que pode instanciar sem argumentos
@Builder //annotation para definir que a classe tem o construtor
@Schema(name = "Cliente",description = "Cliente")
public class Cliente {
	@Id
	@Schema(description = "Identificador único")
	private String id; //no MongoDB para gerarmos ID, ele só é gerado no formato String
	@NotNull
	@Size(min = 1,max = 50)
	private String nome;
	@NotNull
	@Indexed(unique = true, background = true)
	@Schema(description = "CPF", nullable = false)
	private Long cpf;
	@NotNull
	@Schema(description = "Telefone",nullable = false)
	private Long telefone;
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Email", nullable = false, minLength = 1, maxLength = 50)
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	@NotNull
	@Size(min = 1,max = 50)
	@Schema(description = "Endereço",minLength = 1, maxLength = 50, nullable = false)
	private String endereco;
	@NotNull
	@Schema(description = "Numero residencial")
	private Integer numero;
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Cidade", minLength = 1,maxLength = 50,nullable = false)
	private String cidade;
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Estado",minLength = 1,maxLength = 50, nullable = false)
	private String estado;
	
	
}
