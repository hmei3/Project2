package com.hmei.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String description = "Brought to you by Whole Foods Market\n" + 
				"Unbleached and enriched with vitamins and minerals\n" + 
				"Milled for baking quality and consistency\n" + 
				"The ideal choice for all your recipes that call for flour";
		
		Grocery grocery = new Grocery(
				"365 Everyday Value, All-Purpose Flour, 5 lb", description, 3.29, 100);
		
		grocery.setIngredients("UNBLEACHED ENRICHED WHEAT FLOUR, NIACIN, REDUCED IRON, THIAMINE MONONITRATE, RIBOFLAVIN, FOLIC ACID.");
		grocery.setDirections("—");
		grocery.setImage("/resources/images/groceries/365_Everyday_Value,_All-Purpose_Flour,_5_lb.jpg");

		session.save(grocery);
//		Product book = session.get(Product.class, 65l);
//		session.delete(book);
		tx.commit();
		session.close();
		sf.close();

	}
}
