package in.masterpapa.krishi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.masterpapa.krishi.dto.AppUserDTO;
import in.masterpapa.krishi.exception.ServiceException;
import in.masterpapa.krishi.service.UserService;
import in.masterpapa.krishi.util.ResponseUtil;

@RestController
@RequestMapping("/v1/users")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ResponseUtil responseUtil;

	@GetMapping(path = "/userList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserList() {
		return responseUtil.deterMineListResp(userService.getUserList());
	}

	@PostMapping(path = "/userDetails", 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upsertUser(@RequestBody AppUserDTO appUserDTO) {
		try {
			return new ResponseEntity(userService.upsertUser(appUserDTO), HttpStatus.OK);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

}
