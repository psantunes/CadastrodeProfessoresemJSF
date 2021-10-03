package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ProfessorEfetivo;

public class ProfessorEfetivoDAO {

	public static boolean create(ProfessorEfetivo obj) {
    	boolean retorno = false;

		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(Querys.CREATE_PROFESSOR_EFETIVO.getQuery(),
								Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, obj.getNome());
			stmt.setLong(2, obj.getMatricula());
			stmt.setDouble(3, obj.getSalario());
			stmt.execute();
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) retorno = true;
		}catch(SQLException e){
			System.out.println("Ocorreu uma exceção no cadastro de professor efetivo");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Classe não encontrada no cadastro de professor efetivo");
		}
        return retorno;
	}

	public static List<ProfessorEfetivo> listAll() {
		List<ProfessorEfetivo> lista = new ArrayList<ProfessorEfetivo>();

		try(Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(Querys.LIST_ALL_PROFESSOR_EFETIVO.getQuery())){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				Long matricula = rs.getLong("matricula");
				Double salario = rs.getDouble("salario");
				lista.add(new ProfessorEfetivo(nome, matricula, salario));
			}
			return lista;
		}catch(SQLException e){
		System.out.println("Ocorreu uma exceção ao tenta acessar o BD para montar a lista de professores efetivos");
		}catch(Exception e){
		System.out.println("Ocorreu uma exceção ao criar a lista de professores efetivos");
		}
		return null;
	}

    public static boolean update(ProfessorEfetivo obj) {
 	boolean retorno = true;
     try(Connection connection = new ConnectionFactory().getConnection();
     PreparedStatement stmt = 
             connection.prepareStatement(Querys.UPDATE_PROFESSOR_EFETIVO.getQuery());){
         stmt.setString(1, obj.getNome());
         stmt.setDouble(2, obj.getSalario());
         stmt.setLong(3, obj.getMatricula());
         stmt.executeUpdate();
     }catch(SQLException e){
             System.out.println("Erro ao atualizar cadastro do professor efetivo");
             retorno = false;
     }catch(Exception e){  
    	 	System.out.println("Ocorreu uma exceção ao criar a lista de professores efetivos");
    	 	retorno = false;
	 }
     return retorno;
    }

	
    public static boolean delete(ProfessorEfetivo obj) {
    	boolean retorno = true;

    	try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(Querys.DELETE_PROFESSOR_EFETIVO.getQuery())){
            stmt.setLong(1, obj.getMatricula());
            stmt.executeUpdate();
        }catch(SQLException e){
                System.out.println("Exceção ao tentar remover professor efetivo");
                retorno = false;
        }catch(Exception e){  System.out.println("Ocorreu uma exceção ao criar a lista de professores efetivos");
		}
        return retorno;
    }

}
