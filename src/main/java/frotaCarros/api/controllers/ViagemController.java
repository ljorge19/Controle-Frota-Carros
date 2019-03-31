package frotaCarros.api.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import frotaCarros.api.model.Carro;
import frotaCarros.api.model.Distancia;
import frotaCarros.api.model.Viagem;
import frotaCarros.api.modelEnum.Categoria;
import frotaCarros.api.modelEnum.Status;

@RestController

@RequestMapping("/frota")
public class ViagemController {

	// @Autowired
	// private MockService mockService;

	ArrayList<Carro> listacarros = new ArrayList<Carro>();
	
	

	@GetMapping("/mock")
	public void mock() {

		Carro carro1 = new Carro();
		Carro carro2 = new Carro();
		Carro carro3 = new Carro();
		Carro carro4 = new Carro();
		Carro carro5 = new Carro();

		carro1.setId(1);
		carro1.setModelo("CIVIC");
		carro1.setCategoria(Categoria.BASIC);
		carro1.setStatus(Status.WAITING_FOR_RACE);
		carro1.setLatitude(29.46786);
		carro1.setLongitude(-98.53506);

		carro2.setId(2);
		carro2.setModelo("HB20");
		carro2.setCategoria(Categoria.EXECUTIVE);
		carro2.setStatus(Status.FINISHING_RACE);
		carro2.setLatitude(29.46786);
		carro2.setLongitude(-99.53506);

		carro3.setId(3);
		carro3.setModelo("SANDERO");
		carro3.setCategoria(Categoria.SPECIAL);
		carro3.setStatus(Status.INACTIVE);
		carro3.setLatitude(29.46786);
		carro3.setLongitude(-98.53506);

		carro4.setId(4);
		carro4.setModelo("COROLA");
		carro4.setCategoria(Categoria.SHARED);
		carro4.setStatus(Status.UNDER_MAINTENANCE);
		carro4.setLatitude(29.46786);
		carro4.setLongitude(-98.53506);

		carro5.setId(5);
		carro5.setModelo("ASTRA");
		carro5.setCategoria(Categoria.SPECIAL);
		carro5.setStatus(Status.RUNNING_IN_PROGRESS);
		carro5.setLatitude(29.46786);
		carro5.setLongitude(-98.53506);

		listacarros.add(carro1);
		listacarros.add(carro2);
		listacarros.add(carro3);
		listacarros.add(carro4);
		listacarros.add(carro5);
	}

	@GetMapping("/listaCarros")
	public ArrayList<Carro> listaCarros() {
		return listacarros;
	}
	
	@GetMapping("/viagem")
	public Viagem retornarViagem(@RequestParam double latitude1,double longitude1) {
		
		Viagem viagem = new Viagem();
		ArrayList<Distancia> listaDistancia = new ArrayList<Distancia>();
		Distancia distancia;
		
		
		// listando os carros e calculando a quilometragem do carro até o cliente
		for (Carro carro : listacarros) {
			
			Double distanciaCalculada = distance(latitude1, longitude1, carro.getLatitude(), carro.getLongitude(), "K");
			distancia = new Distancia();
			distancia.setCarro(carro);
			distancia.setKm(distanciaCalculada);
			listaDistancia.add(distancia);
			
			
		}
		
		// achando o carro mais próximo do cliente
		for (Distancia distanciaCarro : listaDistancia) {
			
			if (distanciaCarro.getKm() < 1){
				viagem.setCarro(distanciaCarro.getCarro());
				viagem.setDistancia(distanciaCarro.getKm());
				viagem.setPreco(7);
				break;
			}
			else if (distanciaCarro.getKm() > 1 && distanciaCarro.getKm()  <5) {
				viagem.setCarro(distanciaCarro.getCarro());
				viagem.setDistancia(distanciaCarro.getKm());
				viagem.setPreco(15);
				break;
			}
            else if (distanciaCarro.getKm() > 5 && distanciaCarro.getKm()  <10) {
            	viagem.setCarro(distanciaCarro.getCarro());
				viagem.setDistancia(distanciaCarro.getKm());
				viagem.setPreco(20);	
			}
            else if (distanciaCarro.getKm() > 10 ) {
            	viagem.setCarro(distanciaCarro.getCarro());
				viagem.setDistancia(distanciaCarro.getKm());
				viagem.setPreco(50);	
			}
		}
		
		return viagem;
	}
	
	
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
	}
    
        
        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
        /*::    This function converts decimal degrees to radians                         :*/
        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
        private static double deg2rad(double deg) {
            return (deg * Math.PI / 180.0);
        }

        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
        /*::    This function converts radians to decimal degrees                         :*/
        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
        private static double rad2deg(double rad) {
            return (rad * 180 / Math.PI);
        }
	

}
