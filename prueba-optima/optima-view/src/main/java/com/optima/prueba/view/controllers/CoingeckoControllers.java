package com.optima.prueba.view.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.optima.prueba.commons.domain.ClientData;
import com.optima.prueba.commons.domain.Root;
import com.optima.prueba.commons.exceptions.OptimaExceptions;
import com.optima.prueba.view.service.ICoingeckoService;


@Controller
public class CoingeckoControllers {
	
	@Autowired
	ICoingeckoService coingeckoService;
	
	@GetMapping("/list")
	public String list(Model model,@RequestParam("page") 
			Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		
		try {
			
			int currentPage = page.orElse(1);
	        int pageSize = size.orElse(20);
			
			
	        Page<Root> rootPage = coingeckoService.getListPaginated(PageRequest.of(currentPage - 1, pageSize));
			
			model.addAttribute("rootPage",rootPage);
			
			
			
			int totalPages = rootPage.getTotalPages();
	        if (totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	            model.addAttribute("pageNumbers", pageNumbers);
	        }
			
			
			return "home";
			
		}catch(OptimaExceptions e) {
			model.addAttribute("textoError", e.getMessage());
			return "error-page";
		}
		
	}
	
	
	@PostMapping("/save")
	public String guardar(ClientData client, BindingResult result, RedirectAttributes attributes, Model model) {

		try {
			coingeckoService.save(client);
			attributes.addFlashAttribute("msg", "Registro Guardado");

			return "redirect:/list";
		} catch (OptimaExceptions e) {
			model.addAttribute("textoError", e.getMessage());
			return "error-page";
		}
	}
	
	
	
	
	

}
