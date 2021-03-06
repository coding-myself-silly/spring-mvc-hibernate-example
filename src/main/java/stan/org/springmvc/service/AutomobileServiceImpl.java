package stan.org.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stan.org.springmvc.dao.AutomobileDao;
import stan.org.springmvc.model.Automobile;

@Service("automobileService")
@Transactional
public class AutomobileServiceImpl implements AutomobileService {

	@Autowired
	private AutomobileDao dao;
	
	public Automobile findById(int id) {
		return dao.findById(id);
	}

	public void saveAutomobile(Automobile automobile) {
		dao.saveOrUpdate(automobile);
	}
	
	public void updateAutomobile(Automobile automobile) {
		dao.saveOrUpdate(automobile);
	}

	public void deleteAutomobileById(Integer id) {
		dao.deleteAutomobileById(id);
	}
	
	public List<Automobile> findAllAutomobiles() {
		return dao.findAllAutomobiles();
	}

	public List<Automobile> findAutomobilesByName(String name) {
		return dao.findAutomobilesByName(name);
	}
		
}
