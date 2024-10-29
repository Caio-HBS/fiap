package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.DashboardInfoDAO;
import br.com.fiap.fintech.model.DashboardInfo;

import java.sql.*;

public class OracleDashboardInfoDAO implements DashboardInfoDAO {

    private Connection conexao;

    @Override
    public DashboardInfo buscarDashboardInfo(int usuarioId) {
        DashboardInfo dashboardInfo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "SELECT su.nm_operacao AS nm_ultima_despesa, su.dt_operacao AS dt_ultima_despesa, su.valor " +
                    "AS valor_ultima_despesa, rec.nm_operacao AS nm_ultima_receita, rec.dt_operacao " +
                    "AS dt_ultima_receita, rec.valor AS valor_ultima_receita, inv.nm_investimento " +
                    "AS nm_ultimo_investimento, inv.valor_inicial AS valor_ultimo_investimento, inv.percent_mensal " +
                    "AS percent_mensal_investimento, inv.dt_inicio AS dt_inicio_ultimo_investimento FROM " +
                    "(SELECT o.id_usuario, o.nm_operacao, o.dt_operacao, o.valor FROM t_operacao o WHERE " +
                    "o.tipo_operacao = 'D' AND o.id_usuario = ? ORDER BY o.dt_operacao DESC FETCH FIRST 1 ROWS ONLY) " +
                    "su FULL OUTER JOIN (SELECT i.id_usuario, i.nm_investimento, i.valor_inicial, i.percent_mensal, " +
                    "i.dt_inicio FROM t_investimento i WHERE i.id_usuario = ? ORDER BY i.dt_inicio DESC FETCH FIRST " +
                    "1 ROWS ONLY) inv ON su.id_usuario = inv.id_usuario FULL OUTER JOIN (SELECT o.id_usuario, " +
                    "o.nm_operacao, o.dt_operacao, o.valor FROM t_operacao o WHERE o.tipo_operacao = 'R' AND " +
                    "o.id_usuario = ? ORDER BY o.dt_operacao DESC FETCH FIRST 1 ROWS ONLY) rec ON " +
                    "su.id_usuario = rec.id_usuario OR inv.id_usuario = rec.id_usuario"
            );

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, usuarioId);
            stmt.setInt(3, usuarioId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nmDespesa = rs.getString("nm_ultima_despesa");
                Date dtDespesa = rs.getDate("dt_ultima_despesa");
                double valorDespesa = rs.getDouble("valor_ultima_despesa");
                String nmReceita = rs.getString("nm_ultima_receita");
                Date dtReceita = rs.getDate("dt_ultima_receita");
                double valorReceita = rs.getDouble("valor_ultima_receita");
                String nmInvestimento = rs.getString("nm_ultimo_investimento");
                double valorInvestimento = rs.getDouble("valor_ultimo_investimento");
                int percentInvestimento = rs.getInt("percent_mensal_investimento");
                Date dtInvestimento = rs.getDate("dt_inicio_ultimo_investimento");

                dashboardInfo = new DashboardInfo(
                        nmDespesa,
                        dtDespesa != null ? dtDespesa.toLocalDate() : null,
                        valorDespesa, nmReceita,
                        dtReceita != null ? dtReceita.toLocalDate() : null,
                        valorReceita, nmInvestimento, valorInvestimento, percentInvestimento,
                        dtInvestimento != null ? dtInvestimento.toLocalDate() : null
                        );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dashboardInfo;
    }

}
