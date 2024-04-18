package in.harshita.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3 ,max = 15, message="Name should have only 3 to 15 Characters")
	private String name;
	
	@NotNull(message = "Price is mandatory")
	@Postive(message = "Price should be positive number")
	private Double price;
	
	@NotNull(message = "Qty is mandatory")
	@Postive(message = "Qty should be positive number")
	private Integer qty;

}
