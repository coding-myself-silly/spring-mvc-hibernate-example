package stan.org.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import stan.org.springmvc.model.Automobile;

@Repository("automobileDao")
public class AutomobileDaoImpl extends AbstractDao<Integer, Automobile> implements AutomobileDao {

	public Automobile findById(Integer id) {
		return getByKey(id);
	}

	public void saveAutomobile(Automobile automobile) {
		persist(automobile);
	}
	
	public void update(Automobile automobile){
		super.update(automobile);
	}
	
	public void deleteAutomobileById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Automobile where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Automobile> findAllAutomobiles() {
		Criteria criteria = createEntityCriteria();
		return (List<Automobile>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Automobile> findAutomobilesByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (List<Automobile>) criteria.list();
	}
}
