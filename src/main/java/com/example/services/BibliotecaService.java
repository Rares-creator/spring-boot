package com.example.services;

import com.example.dao.BibliotecaDAO;
import com.example.dao.BibliotecaDAOCustom;
import com.example.dto.BibliotecaDto;
import com.example.entities.Biblioteca;
import com.example.mappers.BibliotecaMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {
  @Autowired private BibliotecaDAO bibliotecaDAO;

  @Autowired private BibliotecaMapper bibliotecaMapper;

  @Autowired private BibliotecaDAOCustom bibliotecaDAOCustom;

  public void adaugaBiblioteca(BibliotecaDto bibliotecaDto) {
    bibliotecaDAO.save(
        bibliotecaMapper.bibliotecaDtoToEntity(bibliotecaDto, new CycleAvoidingMappingContext()));
  }

  public BibliotecaDto cautaBiblioteca(Integer id) {
    return bibliotecaMapper.bibliotecaToDto(
        bibliotecaDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<BibliotecaDto> loadallBibliotecas() {
    return bibliotecaMapper.bibliotecaToDto(
        (List<Biblioteca>) bibliotecaDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<BibliotecaDto> cautaBibliotecaDupaLocatie(String locatie) {
    return bibliotecaMapper.bibliotecaToDto(
        bibliotecaDAO.cautaBibliotecaDupaLocatie(locatie), new CycleAvoidingMappingContext());
  }

  public List<BibliotecaDto> cautaBiblioteci(BibliotecaDto bibliotecaCuFiltre) {
    return bibliotecaMapper.bibliotecaToDto(
        bibliotecaDAOCustom.cautaBiblioteci(bibliotecaCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeBiblioteca(Integer id) {
    bibliotecaDAO.delete(id);
  }

  public BibliotecaDto actualizareBiblioteca(BibliotecaDto bibliotecaPentruActualizare) {
    bibliotecaDAO.save(
        bibliotecaMapper.bibliotecaDtoToEntity(
            bibliotecaPentruActualizare, new CycleAvoidingMappingContext()));
    return bibliotecaPentruActualizare;
  }
}
