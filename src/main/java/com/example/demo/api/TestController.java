package com.example.demo.api;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.TestJpaRepository;
import com.example.demo.spring1.TestApplicationContext;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestJpaRepository testJpaRepository;

    @Autowired
    private TestApplicationContext testApplicationContext;


    @ApiOperation(value = "Places a new transaction on the system.", notes = "Creates a new transaction in the system. See the schema of the Transaction parameter for more information ", tags = {"transaction"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Another transaction with the same messageId already exists in the system. No transaction was created."),
            @ApiResponse(code = 201, message = "The transaction has been correctly created in the system"),
            @ApiResponse(code = 400, message = "The transaction schema is invalid and therefore the transaction has not been created.", response = String.class),
            @ApiResponse(code = 415, message = "The content type is unsupported"),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. The error has been logged and is being investigated.")})
    @GetMapping("/test")
    public List<User> test() {
        return testJpaRepository.getAllUsers();
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
//        testRepository.testInsert();
//        return testRepository.count();
        return testJpaRepository.getAllRoles();
    }

    @GetMapping("/save-user")
    public void saveUser() {
        testJpaRepository.saveUser();
    }

    @GetMapping("/context")
    public void testContext() {
//        testApplicationContext.testExistingAppContext();
//        testApplicationContext.testNewAppContext();
//        testApplicationContext.testBeanScopePrototype();
//        testApplicationContext.testBeanScopeSingleton();
    }

    @GetMapping("/test-not-found-exception")
    public void testException() {
        testJpaRepository.testNotFoundException();
    }

    @GetMapping("/test-exists-exception")
    public void testNotFound() {
        testJpaRepository.testExistsException();
    }
}
