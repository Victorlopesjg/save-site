package victor.ufrn.br.savesite.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import victor.ufrn.br.savesite.model.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Login login = new Login();
        login.setId(rs.getLong("id"));
        login.setEmail(rs.getString("email"));
        login.setNome(rs.getString("nome"));
        return login;
    }
}
