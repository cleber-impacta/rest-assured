package com.restassured;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.restassured.dto.CepDto;
import com.restassured.factory.CepFactory;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

class RestAssuredApplicationTests {
	
	private CepDto cepDtoExpected;
	
    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = "https://viacep.com.br/ws/";
    }

    @Test
    public void testBuscaCepSucess09360660() {
    	ValidatableResponse response = get("09360-660/json/").then().statusCode(200);
    	cepDtoExpected = CepFactory.buildCep("09360-660", "Rua Joaquim Pereira dos Santos", "", "Vila Assis Brasil", "Mauá", "SP", "3529401", "4420", "11", "6689");
    	CepDto cepDto = CepFactory.buildCep(response);
    	assertEquals(cepDtoExpected.getCep(), cepDto.getCep());
    	assertEquals(cepDtoExpected.getLogradouro(), cepDto.getLogradouro());
    	assertEquals(cepDtoExpected.getComplemento(), cepDto.getComplemento());
    	assertEquals(cepDtoExpected.getBairro(), cepDto.getBairro());
    	assertEquals(cepDtoExpected.getLocalidade(), cepDto.getLocalidade());
    	assertEquals(cepDtoExpected.getUf(), cepDto.getUf());
    	assertEquals(cepDtoExpected.getIbge(), cepDto.getIbge());
    	assertEquals(cepDtoExpected.getGia(), cepDto.getGia());
    	assertEquals(cepDtoExpected.getDdd(), cepDto.getDdd());
    	assertEquals(cepDtoExpected.getSiafi(), cepDto.getSiafi());
    }
    
    @Test
    public void testBuscaCepSucess08250720() {
    	ValidatableResponse response = get("08250-720/json/").then().statusCode(200);
    	cepDtoExpected = CepFactory.buildCep("08250-720", "Rua José Melani", "", "Conjunto Residencial José Bonifácio", "São Paulo", "SP", "3550308", "1004", "11", "7107");
    	CepDto cepDto = CepFactory.buildCep(response);
    	assertEquals(cepDtoExpected.getCep(), cepDto.getCep());
    	assertEquals(cepDtoExpected.getLogradouro(), cepDto.getLogradouro());
    	assertEquals(cepDtoExpected.getComplemento(), cepDto.getComplemento());
    	assertEquals(cepDtoExpected.getBairro(), cepDto.getBairro());
    	assertEquals(cepDtoExpected.getLocalidade(), cepDto.getLocalidade());
    	assertEquals(cepDtoExpected.getUf(), cepDto.getUf());
    	assertEquals(cepDtoExpected.getIbge(), cepDto.getIbge());
    	assertEquals(cepDtoExpected.getGia(), cepDto.getGia());
    	assertEquals(cepDtoExpected.getDdd(), cepDto.getDdd());
    	assertEquals(cepDtoExpected.getSiafi(), cepDto.getSiafi());
    }
    
    @Test
    public void testBuscaCepError() {
    	ValidatableResponse response = get("09399-999/json/").then().statusCode(200);
    	assertEquals(true, response.extract().path("erro"));
    }
    
    @Test
    public void testBuscaCepBadRequest() {
    	assertEquals(400, get("950100100/json/").then().statusCode(400).extract().response().getStatusCode());
    }
}
