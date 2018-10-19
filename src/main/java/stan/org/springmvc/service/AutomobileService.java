package stan.org.springmvc.service;

import java.util.List;

import stan.org.springmvc.model.Automobile;

public interface AutomobileService {

    Automobile findById(int id);

    void saveAutomobile(Automobile automobile);
    
    public void updateAutomobile(Automobile automobile);
    
    void deleteAutomobileById(Integer id);
    
    List<Automobile> findAllAutomobiles();

    List<Automobile> findAutomobilesByName(String Name);
	
}
