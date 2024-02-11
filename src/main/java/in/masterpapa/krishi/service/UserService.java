package in.masterpapa.krishi.service;

import java.util.List;

import in.masterpapa.krishi.dto.AppUserDTO;

public interface UserService {

	public List<AppUserDTO> getUserList();

	public AppUserDTO upsertUser(AppUserDTO appUserDTO);

}
