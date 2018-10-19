package stan.org.springmvc.dao;

import java.util.List;

import stan.org.springmvc.model.Automobile;

public interface AutomobileDao {

	Automobile findById(Integer id);

	void saveAutomobile(Automobile automobile);
	
	public void update(Automobile automobile);
	
	void deleteAutomobileById(Integer id);
	
	List<Automobile> findAllAutomobiles();

	List<Automobile> findAutomobilesByName(String Name);

}
