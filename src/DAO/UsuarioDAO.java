package DAO;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDAO {
        Connection conn;

        public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO){
           conn = new ConexaoDAO().conectaBD();

           try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            PreparedStatement pspm = conn.prepareStatement(sql);
            pspm.setString(1, objUsuarioDTO.getNome_usuario());
            pspm.setString(2, objUsuarioDTO.getSenha_usuario());

            ResultSet rs = pspm.executeQuery();
            return rs;

           } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null,"usuario DAO : " + erro);
           return null;
           }
      
           
        }

        public ResultSet RegistrarUsuario(UsuarioDTO novoUsuarioDTO){

            try{
                String registroDeUsuarios = "INSERT INTO usuario(nome_usuario, senha_usuario) VALUES (?, ?)";

                PreparedStatement pstm = conn.prepareStatement(registroDeUsuarios);

                pstm.setString(1, novoUsuarioDTO.getNome_usuario());
                pstm.setString(2, novoUsuarioDTO.getSenha_usuario());

                ResultSet resultset = pstm.executeQuery();
                return resultset;

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Novo usuario DAO : " + e);
                return null;
            }

        }
}
