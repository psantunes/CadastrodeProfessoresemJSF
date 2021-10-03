package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ProfessorHorista;

public class ProfessorHoristaDAO {

	public static boolean create(ProfessorHorista obj) {
    	boolean retorno = false;

		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(Querys.CREATE_PROFESSOR_HORISTA.getQuery(),
								Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, obj.getNome());
			stmt.setLong(2, obj.getMatricula());
			stmt.setInt(3, obj.getTotalHoras());
			stmt.setDouble(4, obj.getValorHora());
			stmt.execute();
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) retorno = true;
		}catch(SQLException e){
			System.out.println("Ocorreu uma exceção no cadastro de professor horista");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Classe não encontrada no cadastro de professor horista");
		}
        return retorno;
	}

	public static List<ProfessorHorista> listAll() {
		List<ProfessorHorista> lista = new ArrayList<ProfessorHorista>();

		try(Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(Querys.LIST_ALL_PROFESSOR_HORISTA.getQuery())){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				Long matricula = rs.getLong("matricula");
				int totalHoras = rs.getInt("totalHoras");
				Double valorHora = rs.getDouble("valorHora");
				lista.add(new ProfessorHorista(nome, matricula, totalHoras, valorHora));
			}
			return lista;
		}catch(SQLException e){
		System.out.println("Ocorreu uma exceção ao tenta acessar o BD para montar a lista de professores horistas");
		}catch(Exception e){
		System.out.println("Ocorreu uma exceção ao criar a lista de professores horistas");
		}
		return null;
	}

    public static boolean update(ProfessorHorista obj) {
 	boolean retorno = true;
     try(Connection connection = new ConnectionFactory().getConnection();
     PreparedStatement stmt = 
             connection.prepareStatement(Querys.UPDATE_PROFESSOR_HORISTA.getQuery());){
         stmt.setString(1, obj.getNome());
         stmt.setDouble(2, obj.getTotalHoras());
         stmt.setDouble(3, obj.getValorHora());
         stmt.setLong(4, obj.getMatricula());
         stmt.executeUpdate();
     }catch(SQLException e){
             System.out.println("Erro ao atualizar cadastro do professor horista");
             retorno = false;
     }catch(Exception e){  
    	 	System.out.println("Ocorreu uma exceção ao criar a lista de professores horistas");
    	 	retorno = false;
	 }
     return retorno;
    }

	
    public static boolean delete(ProfessorHorista obj) {
    	boolean retorno = true;

    	try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(Querys.DELETE_PROFESSOR_HORISTA.getQuery())){
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
