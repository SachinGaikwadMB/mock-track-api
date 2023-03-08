package com.mocktrack.api.web.controller;


import static com.mocktrack.api.business.constant.GenericConstanst.AUTH;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AUTH)
public class AuthController extends BaseController
{

}
