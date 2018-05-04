package co.uq.pmvpedidos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import co.uq.pmvpedidos.app.models.service.IUploadFileService;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootPmvPedidosApplication {

	@Autowired
	IUploadFileService uploadFileService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPmvPedidosApplication.class, args);
	}

}
