package com.example.fincas_grupo3;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class FincasGrupo3ApplicationTests {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FincasGrupo3Application.class).profiles("test").run(args);
	}

}
