/**
* @author Antonio Paulo Serpa Antunes
*/

package dao;

public enum Querys {
    CREATE_PROFESSOR_EFETIVO("insert into professor(tipo, nome, matricula, salario) values ('efetivo', ?, ?, ?)"), 
    DELETE_PROFESSOR_EFETIVO("delete from professor where matricula=?"),
    UPDATE_PROFESSOR_EFETIVO("update professor set nome=?, salario=? where matricula=?"),
    LIST_ALL_PROFESSOR_EFETIVO("select * from professor where tipo='efetivo'"),

    CREATE_PROFESSOR_HORISTA("insert into professor(tipo, nome, matricula, totalHoras, valorHora) values ('horista', ?, ?, ?, ?)"), 
    DELETE_PROFESSOR_HORISTA("delete from professor where matricula=?"),
    UPDATE_PROFESSOR_HORISTA("update professor set nome=?, totalHoras=?, valorHora=? where matricula=?"),
    LIST_ALL_PROFESSOR_HORISTA("select * from professor where tipo='horista'"),

    AUTHENTICATE("select nome from usuario where nome=? and senha=?");
	
    private final String query;

    Querys(String query){
        this.query = query; 
    }

	public String getQuery() {
		return query;
	}

}
