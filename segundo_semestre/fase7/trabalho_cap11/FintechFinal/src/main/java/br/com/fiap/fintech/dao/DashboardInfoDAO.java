package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.DashboardInfo;

public interface DashboardInfoDAO {

    DashboardInfo buscarDashboardInfo(int usuarioId);

}
