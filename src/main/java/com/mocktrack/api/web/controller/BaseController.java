package com.mocktrack.api.web.controller;


import static com.mocktrack.api.business.constant.GenericConstanst.BASE_URL;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BaseController
{

}
