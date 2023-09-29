package com.ashish.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashish.entity.StudentRecord;

@Component
public class StudentRecordManagement {

	@Autowired
	EntityManager em;

	public StudentRecord save(StudentRecord student) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();

		return student;
	}

	public StudentRecord delete(Integer id) {
		StudentRecord StudentDb = em.find(StudentRecord.class, id);

		if (StudentDb != null) {
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.remove(StudentDb);
			et.commit();
		}
		return StudentDb;
	}

	public StudentRecord fetchOne(Integer id) {
		return em.find(StudentRecord.class, id);

	}

	public List<StudentRecord> getAll() {
		
		Query q = em.createQuery("select s from StudentRecord s");
		List<StudentRecord> records = q.getResultList();
		
		return records;
	}
	
	public StudentRecord update(StudentRecord studentrecord)
	{
		StudentRecord sdb = em.find(StudentRecord.class, studentrecord.getId());
		
		if(sdb != null)
		{
		   EntityTransaction et = em.getTransaction();
		   
		   et.begin();
		   em.merge(studentrecord);
		   et.commit();
		   return studentrecord;
		}
		return null;
	}
}
