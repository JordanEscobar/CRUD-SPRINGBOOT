
package com.example.HolaSpring.servicio;
import com.example.HolaSpring.dao.IPersonaDao;
import com.example.HolaSpring.Domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private IPersonaDao personadao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> ListarPersonas() {
       return (List<Persona>)personadao.findAll();
           }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personadao.save(persona);
           }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personadao.delete(persona);
         }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
       return personadao.findById(persona.getIdPersona()).orElse(null);
          }
}
