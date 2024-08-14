package VIEW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

public class Interface {
    JLabel labelUsuario;
    JLabel labelSenha;

    public Interface() {
        JFrame tela = new JFrame("LOGIN");

        tela.setBounds(500, 500, 500, 500);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(3);
        tela.setResizable(false);

        JLabel labelUsuario = new JLabel();
        labelUsuario.setText("Usuario: ");
        labelUsuario.setFont(new Font("Verdana", Font.BOLD, 25));

        labelUsuario.setBounds(35, 50, 250, 40);

        JTextField textUsuario = new JTextField();
        textUsuario.setBounds(60, 115, 400, 40);
        textUsuario.setEnabled(true);

        JLabel labelSenha = new JLabel();
        labelSenha.setText("Senha: ");
        labelSenha.setFont(new Font("Verdana", Font.BOLD, 25));

        labelSenha.setBounds(35, 210, 250, 40);

        JTextField textSenha = new JTextField();
        textSenha.setBounds(60, 285, 400, 40);
        textSenha.setEnabled(true);

        JButton botaoLogin = new JButton("LOGIN");
        botaoLogin.setBounds(150, 355, 150, 60);

        tela.add(botaoLogin);
        tela.add(labelSenha);
        tela.add(textUsuario);
        tela.add(textSenha);
        tela.add(labelUsuario);
        tela.setVisible(true);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nome_usuario, senha_usuario;

                    nome_usuario = textUsuario.getText();
                    senha_usuario = textSenha.getText();

                    UsuarioDTO objUsuarioDTO = new UsuarioDTO();

                    objUsuarioDTO.setNome_usuario(nome_usuario);
                    objUsuarioDTO.setSenha_usuario(senha_usuario);

                    UsuarioDAO objusuarioDAO = new UsuarioDAO();
                    ResultSet rsusuarioDAO = objusuarioDAO.autenticacaoUsuario(objUsuarioDTO);

                    if (rsusuarioDAO.next()) {
                        JOptionPane.showMessageDialog(null, "Entrou no APP");
                        // chamar tela q eu quero abrir
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                        //enviar mensagem dizendo incorreto
                    }
                } catch (SQLException erro) {
                   JOptionPane.showMessageDialog( null,"Botao login viwe" + erro);
            }
        
        }
    }
    
        );

    }

    public static void main(String[] args) {

        Interface inter = new Interface();
        telaRegistro interfaceRegistro = new telaRegistro();
    }

}
