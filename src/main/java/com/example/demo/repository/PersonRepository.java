package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonRepository{

   @Autowired
   private MongoTemplate mongoTemplate;

   public Person findByFirstName(String firstName) {
      Query query = new Query();
      query.addCriteria(Criteria.where("firstName").is(firstName));
      return mongoTemplate.findOne(query, Person.class);
   }

   public List<Person> findByAge(int age) {
      return null;
   }

   public Person save(Person person) {
      mongoTemplate.save(person);
      return person;
   }

   public List<Person> findAll() {
      return mongoTemplate.findAll(Person.class);
   }

   public void deleteAll() {
      mongoTemplate.dropCollection(Person.class);
   }

   public void delete(Person person) {

   }

   public void update(Person person) {
      Query query = new Query();
      query.addCriteria(Criteria.where("firstName").is(person.getFirstName()));

      Update update = new Update();
      update.set("age", person.getAge());
      mongoTemplate.updateFirst(query, update, Person.class);
   }

}
