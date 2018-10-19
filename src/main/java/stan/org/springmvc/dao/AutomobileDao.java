package stan.org.springmvc.dao;

import java.util.List;

import stan.org.springmvc.model.Automobile;

public interface AutomobileDao {

	Automobile findById(Integer id);
	
	public void saveOrUpdate(Automobile automobile);
	
	void deleteAutomobileById(Integer id);
	
	List<Automobile> findAllAutomobiles();

	List<Automobile> findAutomobilesByName(String Name);

}
