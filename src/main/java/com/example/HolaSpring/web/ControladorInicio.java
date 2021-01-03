package com.example.HolaSpring.web;
import com.example.HolaSpring.Domain.Persona;
import com.example.HolaSpring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller  
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var personas = personaService.ListarPersonas();
        log.info("ejecutando un controlador de tipo springMVC");
        model.addAttribute("personas",personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String Agregar(Persona persona){       
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona){
    personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model)
    {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona,Model model){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
