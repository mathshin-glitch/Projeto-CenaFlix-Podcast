package Classes;

import javax.swing.JButton;

public class PermissaoUtil {

    public static void aplicarPermissoes(Usuario usuario, JButton... botoes) {

        if (usuario == null) {
            return;
        }

        String tipo = usuario.getTipo() != null ? usuario.getTipo().toUpperCase() : "";

        // Exemplo básico: permissões globais
        switch (tipo) {
            case "ADMINISTRADOR":
                for (JButton botao : botoes) {
                    botao.setEnabled(true); // todos os botões ativos
                }
                break;

            case "OPERADOR":
                for (JButton botao : botoes) {
                    if (botao.getText().equalsIgnoreCase("Excluir")) {
                        botao.setEnabled(false); // operador não pode excluir
                    } else {
                        botao.setEnabled(true);
                    }
                }
                break;

            case "USUARIO":
                for (JButton botao : botoes) {
                    if (botao.getText().equalsIgnoreCase("Cadastrar") || botao.getText().equalsIgnoreCase("Excluir")) {
                        botao.setEnabled(false); // usuário comum não pode cadastrar nem excluir
                    } else {
                        botao.setEnabled(true);
                    }
                }
                break;

            default:
                for (JButton botao : botoes) {
                    botao.setEnabled(false);
                }
                break;
        }
    }
}
