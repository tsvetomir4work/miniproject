package com.saproject.project;

import static com.saproject.project.entity.Action.actionType.email;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.saproject.project.entity.Action;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActionControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testListAllActions() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/action",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetActionById() {
        Action action = restTemplate.getForObject(getRootUrl() + "/action/1", Action.class);
        System.out.println(action.getId());
        assertNotNull(action);
    }

    @Test
    public void testCreateAction() {
        Action action = new Action();
        action.setId(1);
        action.setName("admin");
        action.setDescription("admin description");
        action.setAttribute("admin attribute");
        action.setType(email);

        ResponseEntity<Action> postResponse = restTemplate.postForEntity(getRootUrl() + "/action", action, Action.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

//    @Test
//    public void testUpdateEmployee() {
//        int id = 1;
//        Action action = restTemplate.getForObject(getRootUrl() + "/action/" + id, Action.class);
//        action.setName("new_admin");
//        restTemplate.put(getRootUrl() + "/action/" + id, action);
//        Action updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Action.class);
//        assertNotNull(updatedEmployee);
//    }

    @Test
    public void testDeleteAction() {
        int id = 2;
       Action action = restTemplate.getForObject(getRootUrl() + "/action/" + id, Action.class);
        assertNotNull(action);
        restTemplate.delete(getRootUrl() + "/action/" + id);
        try {
            action = restTemplate.getForObject(getRootUrl() + "/action/" + id, Action.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
