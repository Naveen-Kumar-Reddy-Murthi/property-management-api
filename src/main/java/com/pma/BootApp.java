package com.pma;

import com.pma.model.OccupancyStatus;
import com.pma.model.Property;
import com.pma.model.PropertyType;
import com.pma.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class BootApp implements CommandLineRunner {
	@Autowired
	private PropertyRepository propertyRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Property property = Property.builder()
				.name("Naveen's Paradise")
				.address("Calgary")
				.propertyType(PropertyType.INDEPENDENT)
				.occupancyStatus(OccupancyStatus.VACANT)
				.authorized(false)
				.createdAt(Instant.now())
				.build();
		Property property1 = Property.builder()
				.name("Naveen's Gardenia")
				.address("Ayodhya")
				.propertyType(PropertyType.BUILDER)
				.occupancyStatus(OccupancyStatus.OCCUPIED)
				.authorized(false)
				.createdAt(Instant.now())
				.build();

		Property property3 = Property.builder()
				.name("Naveen's Penthouse")
				.address("Dhwarka")
				.propertyType(PropertyType.APARTMENT)
				.occupancyStatus(OccupancyStatus.BOOKED)
				.authorized(false)
				.createdAt(Instant.now())
				.build();

		propertyRepository.save(property);
		propertyRepository.save(property1);
		propertyRepository.save(property3);

	}
}