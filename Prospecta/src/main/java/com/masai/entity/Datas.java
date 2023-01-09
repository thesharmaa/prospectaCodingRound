package com.masai.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datas {

	@Id
	@JsonProperty("API")
	private String api;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Auth")
	private String auth;

	@JsonProperty("HTTPS")
	private Boolean https;

	@JsonProperty("Cors")
	private String cors;

	@JsonProperty("Link")
	private String link;

	@JsonProperty("Category")
	private String category;

}
