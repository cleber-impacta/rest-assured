package com.restassured.factory;

import com.restassured.dto.CepDto;

import io.restassured.response.ValidatableResponse;

public class CepFactory {

	public static CepDto buildCep(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf, String ibge, String gia, String ddd, String siafi) {
		return new CepDto(cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi);
	}

	public static CepDto buildCep(ValidatableResponse response) {
		return new CepDto(response.extract().path("cep"), response.extract().path("logradouro"),
				response.extract().path("complemento"), response.extract().path("bairro"),
				response.extract().path("localidade"), response.extract().path("uf"), response.extract().path("ibge"),
				response.extract().path("gia"), response.extract().path("ddd"), response.extract().path("siafi"));
	}
}
