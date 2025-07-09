@Reqres
Feature: Reqres Api

  @getListUser
  Scenario: Obtener lista de usuarios
    Given consulto el endpoint "https://reqres.in" con path "/api/users?page=2"
    And   con header "x-api-key":"reqres-free-v1"
    And   con header "Content-Type":"application/json"
    When  obtengo el response
    Then  valido que el status sea 200

  @getSingleUser
  Scenario Outline: Obtener usuario con id <id>
    Given consulto el endpoint "https://reqres.in" con path "/api/users/<id>"
    And   con header "x-api-key":"reqres-free-v1"
    And   con header "Content-Type":"application/json"
    When  obtengo el response
    Then  valido que el status sea <status>
    Examples:
      | id | status |
      | 1  | 200    |
      | 2  | 200    |
      | 3  | 200    |
      | 23 | 404    |