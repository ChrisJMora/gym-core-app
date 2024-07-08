package com.example.gym.gym_core_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.MiembroDTO;
import com.example.gym.gym_core_service.dto.PutMiembroDTO;
import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.repository.MiembroRepository;
import com.example.gym.gym_core_service.utils.MiembroUtil;

@Service
public class MiembroService {
    
    @Autowired
    private MiembroRepository repository;

    public List<MiembroDTO> getAllMiembros() {
        List<Miembro> miembros = repository.findAll();
        return MiembroUtil.convertToDTO(miembros);
    }

    public List<MiembroDTO> getAllMiembrosByEntrenadorId(long id) {
        List<Miembro> miembros = repository.findAllByEntrenadorId(id);
        return MiembroUtil.convertToDTO(miembros);
    }

    public Miembro getMiembroById(long id) {
        Optional<Miembro> miembroOpcional = repository.findById(id);
        if (miembroOpcional.isPresent()) {
            return miembroOpcional.get();
        } else {
            return null;
        }
    }

    public MiembroDTO updateMiembro(long id, PutMiembroDTO miembro) {
        Miembro miembro_actual = getMiembroById(id);
        if (miembro_actual != null) {
            miembro_actual.setPeso(miembro.getPeso());
            miembro_actual.setAltura(miembro.getAltura());
            Miembro miembro_actualizado = repository.save(miembro_actual);
            return MiembroUtil.convertToDTO(miembro_actualizado);
        } else {
            return null;
        }
    }
}
