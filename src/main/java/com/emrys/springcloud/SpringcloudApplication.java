package com.emrys.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableTask
public class  SpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApplication.class, args);
	}


	@Bean
	public TollProcessingTask tollProcessingTask(){
		return new TollProcessingTask();
	}

	public class TollProcessingTask implements CommandLineRunner{

		@Override
		public void run(String... strings) throws Exception {

			//parameters stationid, license plate, timestamp
			if(null !=strings){
				System.out.println("parameter length is " + strings.length);

				String stationId = strings[0];
				String licensePlate = strings[1];
				String timeStamp = strings[2];

				System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timeStamp);
			}
		}
	}

}
