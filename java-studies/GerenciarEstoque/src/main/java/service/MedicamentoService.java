package service;

import dao.IDao;
import model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }
}
