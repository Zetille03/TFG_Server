package com.tfgserver.tfgserver;

import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = TfgServerApplication.class)
class TfgServerApplicationTests {

	@Autowired
	private ConsumidorDAO consumidorDAO;

	@Test
	void addConsumidorTest() {
		Consumidor consumidor = new Consumidor();

		consumidor.setEmail("ricardogarcia@gmail.com");
		consumidor.setUsername("ricardo");
		consumidor.setPassword("1234");
		consumidorDAO.save(consumidor);

	}

//	@Test
	void getAllConsumidores(){
		List<Consumidor> consumidores = consumidorDAO.getAllConsumidores();
		System.out.println(consumidores.getFirst());

	}

//	@Test
	void deleteAllConsumidores(){
		List<Consumidor> consumidores = consumidorDAO.getAllConsumidores();
		for(Consumidor c : consumidores){
			consumidorDAO.delete(c);
		}
	}

}
