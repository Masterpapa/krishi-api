package in.masterpapa.krishi.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.masterpapa.krishi.dto.AppUserDTO;
import in.masterpapa.krishi.entity.AppUser;
import in.masterpapa.krishi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<AppUserDTO> getUserList() {
		return userRepository.findAll().stream().map(obj -> {
			AppUserDTO dto = new AppUserDTO();
			BeanUtils.copyProperties(obj, dto);
			return dto;
		}).sorted(Comparator.comparing(AppUserDTO::getUserName)).collect(Collectors.toList());
	}

	@Override
	public AppUserDTO upsertUser(AppUserDTO appUserDTO) {
		AppUser appUser = new AppUser();
		BeanUtils.copyProperties(appUserDTO, appUser);
		appUser.setUserName(appUserDTO.getEmail());
		appUser.setMaintainTS(LocalDateTime.now());
		appUser.setPassword("krishi123");
		AppUser savedUser = userRepository.save(appUser);
		appUserDTO.setUserId(savedUser.getUserId());
		return appUserDTO;
	}

}
