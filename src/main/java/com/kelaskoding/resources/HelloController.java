/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.resources;

import com.kelaskoding.dto.ResponseData;
import com.kelaskoding.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author jarvis
 */
@Path("/hello")
public class HelloController {
    
    
    @GET
    public String hello(){
        return "Hello World!";
    }
    
    @GET
    @Path("/data")
    public Response sayHello(){
        Map map = new HashMap();
        map.put("data", "Hello World!");
        return Response.ok(map).build();
    }
    
    @POST
    @Path("/nama")
    public Response sayHelloWorld(@FormParam("nama") String name, Person person){
        Map map = new HashMap();
        map.put("nama", name);
        map.put("email", person.getEmail());
        return Response.ok(map).build();
    }
    
    
    @GET
    @Path("/person")
    public Response findAllPerson(){
        Person p1 = new Person("Hendro", "hendro@gmail.com");
        Person p2 = new Person("Andi", "andi@gmail.com");
        Person p3 = new Person("Budi", "budi@gmail.com");
        
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        
        ResponseData data = new ResponseData();
        data.setStatus(true);
        data.getMessages().add("List of persons");
        
        Map map = new HashMap();
        map.put("data", persons);
        map.put("total", 1000);
        map.put("page", 1);
        
        data.setPayload(map);
        
        return Response.ok(data).build();
    }
    
}
