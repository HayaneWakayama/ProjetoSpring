package projetoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import projetoSpring.bo.ClienteBO;
import projetoSpring.bo.NotaSaidaBO;
import projetoSpring.bo.NotaSaidaItemBO;
import projetoSpring.bo.ProdutoBO;
import projetoSpring.model.NotaSaida;
import projetoSpring.model.NotaSaidaItem;

@Controller
@RequestMapping("/nota-saida")
public class NotaSaidaController {
	
	@Autowired
	private NotaSaidaBO notaSaidaBO;
	
	@Autowired
	private ClienteBO clienteBO;
	
	@Autowired
	private ProdutoBO produtoBO;
	
	@RequestMapping(value="/novo", method =RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		Long clienteId = null;
		model.addAttribute("notaSaida", new NotaSaida());
		model.addAttribute("clientes", clienteBO.lista());
		return new ModelAndView("/nota-saida/formulario", model);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String salva(@Valid @ModelAttribute NotaSaida notaSaida,
			BindingResult result, RedirectAttributes attr, ModelMap model) {
		if (notaSaida.getCliente().getId() == null) {
			result.rejectValue("cliente", "field.required");
		}
		
		if (result.hasErrors()) {
			return "/nota-saida/formulario";
		}
		
		if (notaSaida.getId() == null) {
			notaSaidaBO.insere(notaSaida);
			attr.addAttribute("feedback", "A nota de saída foi cadastrada com sucesso");
		} else {
			notaSaidaBO.atualiza(notaSaida);
			attr.addAttribute("feedback", "A nota de saída foi atualizada com sucesso");
		}
		return "redirect:/nota-saida";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("notas", notaSaidaBO.lista());
		return new ModelAndView("/nota-saida/lista", model);
	}
	
	@RequestMapping(value="{id}/item", method=RequestMethod.GET)
	public ModelAndView produto(@PathVariable("id")Long id, ModelMap model) {
		NotaSaidaItem nsi = new NotaSaidaItem();
		NotaSaida ns = notaSaidaBO.pesquisaPeloId(id);
		nsi.setNotaSaida(ns);
		model.addAttribute("notaSaidaItem",nsi);
		model.addAttribute("produtos", produtoBO.lista());
		return new ModelAndView("/nota-saida-item/formulario",model);
	}
	
	@RequestMapping(value="/edita/{id}", method=RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("notaSaidaItem", new NotaSaidaItem());
		model.addAttribute("clientes", clienteBO.lista());
		model.addAttribute("notaSaida",notaSaidaBO.pesquisaPeloId(id));
		return new ModelAndView("/nota-saida/formulario", model);
		
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		NotaSaida ns = notaSaidaBO.pesquisaPeloId(id);
		notaSaidaBO.remove(ns);
		attr.addFlashAttribute("feedback", "Nota de saída removida com sucesso");
		return "redirect:/nota-saida";
	}

}
