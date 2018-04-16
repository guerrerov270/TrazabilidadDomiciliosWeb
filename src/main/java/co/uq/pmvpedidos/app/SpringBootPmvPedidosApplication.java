package co.uq.pmvpedidos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.uq.pmvpedidos.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootPmvPedidosApplication {

	@Autowired
	IUploadFileService uploadFileService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPmvPedidosApplication.class, args);
	}

	// @Override // implements CommandLineRunner //Borrar uploads al inicio
	// public void run(String... args) throws Exception {
	// // TODO Auto-generated method stub
	// uploadFileService.deleteAll();
	// uploadFileService.init();
	// }
}
