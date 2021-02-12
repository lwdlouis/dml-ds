package com.dml.ds.databackup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsDataBackupApplication implements CommandLineRunner {

	public static void main(String[] args) {
		try {
			SpringApplication.run(DsDataBackupApplication.class, args);
			System.exit(0);
		} catch (Exception e) {
			System.exit(1);
		}
	}

	@Override
	public void run(String... args) throws Exception {
//		if (1 == 1) {
//			throw new RuntimeException("hahahah");
//		}
	}
}
