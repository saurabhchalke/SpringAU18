package com.accolite.hibernate.HibernateSession;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student();
        student.setName("Saurabh Chalke");
        student.setSid(1);
        student.setMarks(75);
        student.setAge(20);
        
        Laptop laptop1 = new Laptop();
        laptop1.setLid(111);
        laptop1.setBrand("Potato");
        laptop1.setModel("Inspiron");
        laptop1.setPrice(66);
        
        student.setlaptop(laptop1);
        
        Expense expense1 = new Expense();
        expense1.setBillId(25);
        expense1.setDescription("Food");
        expense1.setAmount(200);
        
        Expense expense2 = new Expense();
        expense2.setBillId(26);
        expense2.setDescription("Movie");
        expense2.setAmount(150);
        
        
        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(expense1);
        expenseList.add(expense2);
        
        student.setexpenseList(expenseList);
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Expense.class);
        SessionFactory sf = con.buildSessionFactory();
        
        Session session1 = sf.openSession();
        
        Transaction tx = session1.beginTransaction();
        session1.save(student);
        session1.save(laptop1);
        session1.save(expense1);
        session1.save(expense2);
        tx.commit();
        session1.close();
        
        Session session2 = sf.openSession();
        tx = session2.beginTransaction();
        Student stu = session2.get(Student.class, 1);
        System.out.println("Student details: " + stu.getName() + " " + stu.getSid() + " " + stu.getAge() + " "); 
        System.out.println("Student's bill:");
        
        List<Expense> resultexpenseList = stu.getexpenseList();
        for(Expense exp : resultexpenseList) {
        	System.out.println(exp.getBillId() + " " + exp.getDescription() + " " + exp.getAmount());
        }
        Laptop laptop = stu.getlaptop();
        
        System.out.println("Laptop info:");
        System.out.println(laptop.getLid() + " " + laptop.getBrand() + " " + laptop.getModel() + " " + laptop.getPrice());        
        
    }
}