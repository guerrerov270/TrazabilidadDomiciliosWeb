package co.uq.pmvpedidos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import co.uq.pmvpedidos.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootPmvPedidosApplication extends SpringBootServletInitializer {

	@Autowired
	IUploadFileService uploadFileService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPmvPedidosApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootPmvPedidosApplication.class);
	}

}
