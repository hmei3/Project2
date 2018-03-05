package com.hmei.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hmei.hibernate.entity.Product;
import com.hmei.hibernate.model.CategoryConverter;
import com.hmei.hibernate.model.SearchForm;
import com.hmei.spring.exceptionhandler.ProductConversionException;

@Repository
public class ProductDaoImp implements ProductDao {

	@Autowired
	private HibernateTemplate ht;

	// called for a specific product
	@Override
	public Product getById(String category, long id) {
		Class theClass = CategoryConverter.converterStringToProduct(category);

		return (Product) ht.get(theClass, id);

	}

	public Product getById(long id) {
		return ht.get(Product.class, id);
	}

	// called for generating the product list
	@Override
	public Set<Product> getPage(SearchForm searchForm, int firstResult, int maxResult)
			throws ProductConversionException {
		String category = searchForm.getCategory();
		String keyword = searchForm.getKeyword();
		Class<?> theClass;
		theClass = CategoryConverter.converterStringToProduct(category);
		System.out.println(theClass.getName());

		DetachedCriteria criteria = DetachedCriteria.forClass(theClass)
				.add(Restrictions.disjunction()
						.add((Restrictions.like("name", keyword.toLowerCase(), MatchMode.ANYWHERE).ignoreCase()))
						.add((Restrictions.like("description", keyword.toLowerCase(), MatchMode.ANYWHERE).ignoreCase()))
						.add((Restrictions.like("category", keyword.toLowerCase(), MatchMode.ANYWHERE).ignoreCase())))// .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

				.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("name"), "name").add(Projections.property("category"), "category")
						.add(Projections.property("image"), "image").add(Projections.property("price"), "price")));// .setResultTransformer(Transformers.aliasToBean(theClass));
		List result = ht.findByCriteria(criteria, firstResult, maxResult);
		Set<Product> set = mapResultSetToProduct(result);
		return set;
	}

	private Set<Product> mapResultSetToProduct(List<Object[]> result) throws ProductConversionException {
		Set<Product> set = new HashSet<Product>();
		for (Object[] o : result) {
			set.add(Product.convertObjectArrToProduct(o));
		}
		return set;
	}

	public long countRow(SearchForm searchForm) {
		String category = searchForm.getCategory();
		String keyword = searchForm.getKeyword();
		String sqlString = "";
		if (keyword.equals(""))
			sqlString = "select count(*) from " + category;
		else
			sqlString = "select count(*) from " + category + " where lower(name) like '%' || lower('" + keyword
					+ "') || '%' or " + "lower(description) like '%' || lower('" + keyword + "') || '%' or "
					+ "lower(category) like '%' || lower('" + keyword + "') || '%'";
		return DataAccessUtils.intResult(ht.find(sqlString));
	}

	@Override
	public void update(long pId, int amount) {
		Product p = getById(pId);
		p.setAmount(p.getAmount() - amount);
		ht.update(p);

	}
}
