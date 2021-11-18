package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import com.example.clinica_odontologica_2.dto.PacienteDTO;
import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.model.Endereco;
import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.repository.IRepository;

import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import java.util.Map;

public class ConsultaRepositoryImpl implements IRepository<Consulta> {
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private Integer idGlobal =1;

    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;
    private EnderecoRepositoryImpl enderecoRepository;

    public ConsultaRepositoryImpl () {
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
        this.enderecoRepository = new EnderecoRepositoryImpl();
    }



    @Override
    public Consulta salvar(Consulta consulta) {
        Paciente paciente = pacienteRepository.buscarPorId(consulta.getPaciente().getId());
        if(paciente == null)
            return null;

        Dentista dentista = dentistaRepository.buscarPorId(consulta.getDentista().getId());
        if(dentista == null)
            return null;

        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);

        consultaDTOMap.put(idGlobal, consultaDTO);
        idGlobal++;

        return consulta;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        if(consultaDTO != null)
            return new Consulta(consultaDTO,
                                pacienteRepository.buscarPorId(consultaDTO.getId()),
                                dentistaRepository.buscarPorId(consultaDTO.getId()));

        return null;
    }

    @Override
    public void deletar(Integer id) {
        consultaDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        Map<Integer, Consulta> consultaMap = new HashMap<>();

        for(Map.Entry<Integer, ConsultaDTO> entry : consultaDTOMap.entrySet()) {
            Consulta consulta = new Consulta(entry.getValue(),
                                            pacienteRepository.buscarPorId(entry.getValue().getIdPaciente()),
                                            dentistaRepository.buscarPorId(entry.getValue().getIdDentista()));
            consultaMap.put(consulta.getId(), consulta);
        }
        return consultaMap;
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        if(consultaDTO == null)
            return null;
        consulta.setId(id);

        Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
        pacienteRepository.atualizar(paciente.getId(), consulta.getPaciente());

        Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
        dentistaRepository.atualizar(dentista.getId(), consulta.getDentista());

        ConsultaDTO consultaDTOUpdated = new ConsultaDTO(consulta);

        consultaDTOMap.put(id, consultaDTOUpdated);

        return consulta;
    }
}
