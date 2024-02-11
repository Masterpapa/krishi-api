package in.masterpapa.krishi.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppUserDTO {

	private Long userId;

	private String userName;

	private String email;

	private String mobile;

	private LocalDateTime maintainTS;

	private String maintainID;
}
