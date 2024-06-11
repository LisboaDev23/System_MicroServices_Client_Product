package com.gbLisboa.produtoService.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Produto", description = "Produto" )
public class Produto {

	@Id
	@Schema(description = "Identificador único")
	private String id;
	@NotNull
	@Size(min = 1, max = 100)
	@Schema(description = "Nome do Produto",nullable = false, minLength = 1,maxLength = 100)
	private String nome;
	@NotNull
	@Schema(description = "Preço do Produto",nullable = false)
	private Double valor;
	@NotNull
	@Indexed(unique = true,background = true)
	@Schema(description = "Código em barras do produto")
	private Long codigo;
	@Schema(description = "Descrição do Produto")
	private String descricao;
	
}
