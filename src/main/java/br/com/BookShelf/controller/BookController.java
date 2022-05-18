package br.com.BookShelf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.BookShelf.entity.Author;
import br.com.BookShelf.entity.Book;
import br.com.BookShelf.service.AuthorService;

@Controller
public class BookController {
	
	// É utilizado esse método para quando o usuário for cadastrar um livro, ele ter uma lista
	// de autores já cadastrados no sistema previamente.
	@Autowired
	private AuthorService authorService;

	@GetMapping("/book/form/add")
	public ModelAndView getFormAdd() {
		
		ModelAndView mv = new ModelAndView("bookform");
		// devolvendo a lista de autores para a variavel authorList
		List<Author> authorList = this.authorService.getAuthorList();
		mv.addObject("authorlist", authorList);
		
		return mv;
	}
	
	@PostMapping("/book/form/save")
	public String saveBook(@Valid Book book, BindingResult result, 
								RedirectAttributes redirect) {
		
		
		if(result.hasErrors()) {
			// Caso ele volte para o form inicial, vai mostrar o motivo do retorno.
			redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios!");
			return "redirect:/book/form/add";
		}
		
		return "redirect:/lista";
		
	}
	
}
