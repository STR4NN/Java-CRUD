package VIEW;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class telaRegistro {
    JFrame telaRegistro = new JFrame("Registro");
    public telaRegistro(){

        telaRegistro.setBounds(500, 500, 500,500);
        telaRegistro.setDefaultCloseOperation(3);
        telaRegistro.setResizable(false);
        telaRegistro.setLayout(null);

        JLabel labelRegistroUsuario = new JLabel();
        labelRegistroUsuario.setText("Usuario: ");
        labelRegistroUsuario.setFont(new Font("Verdana", Font.BOLD, 25));

        labelRegistroUsuario.setBounds(35, 50, 250, 40);

        JTextField textRegistroUsuario = new JTextField();
        textRegistroUsuario.setBounds(60, 115, 400, 40);
        textRegistroUsuario.setEnabled(true);

        JLabel labelRegistroSenha = new JLabel();
        labelRegistroSenha.setText("Senha: ");
        labelRegistroSenha.setFont(new Font("Verdana", Font.BOLD, 25));

        labelRegistroSenha.setBounds(35, 210, 250, 40);

        JTextField textRegistroSenha = new JTextField();
        textRegistroSenha.setBounds(60, 285, 400, 40);
        textRegistroSenha.setEnabled(true);

        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.setBounds(150, 355, 150, 60);

        telaRegistro.add(botaoRegistro);
        telaRegistro.add(labelRegistroUsuario);
        telaRegistro.add(labelRegistroSenha);
        telaRegistro.add(textRegistroUsuario);
        telaRegistro.add(textRegistroSenha);


        telaRegistro.setVisible(true);

        botaoRegistro .addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             try {
                                                 String nome_usuario, senha_usuario;

                                                 nome_usuario = labelRegistroUsuario.getText();
                                                 senha_usuario = textRegistroSenha.getText();

                                                 UsuarioDTO objUsuarioDTO = new UsuarioDTO();



                                                 UsuarioDAO objusuarioDAO = new UsuarioDAO();
                                                 ResultSet rsRegistrousuarioDAO = objusuarioDAO.RegistrarUsuario(objUsuarioDTO);

                                                 if (rsRegistrousuarioDAO.next()) {
                                                     JOptionPane.showMessageDialog(null, "REGISTROU");
                                                     // chamar tela q eu quero abrir
                                                 } else {
                                                     JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                                                     //enviar mensagem dizendo incorreto
                                                 }
                                             } catch (SQLException erro) {
                                                 JOptionPane.showMessageDialog( null,"Botao REGISTRO VIEW" + erro);
                                             }

                                         }
                                     }

        );
    }

}
